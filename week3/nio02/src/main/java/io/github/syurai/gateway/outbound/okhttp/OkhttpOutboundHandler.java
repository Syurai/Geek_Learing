package io.github.syurai.gateway.outbound.okhttp;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.github.syurai.gateway.filter.ProxyBizFilter;
import io.github.syurai.gateway.router.HttpEndpointRouter;
import io.github.syurai.gateway.router.RandomHttpEndpointRouter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpOutboundHandler {
	
	private List<String> backendUrls;
	private ExecutorService proxyService;
	
	OkHttpClient client = new OkHttpClient();
    HttpEndpointRouter router = new RandomHttpEndpointRouter();
    
	public OkhttpOutboundHandler(List<String> backends) {
		this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());
		
		int cores = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 1000;
        int queueSize = 2048;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();//.DiscardPolicy();
        proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"), handler);
	}
	
	private String formatUrl(String backend) {
        return backend.endsWith("/")?backend.substring(0,backend.length()-1):backend;
    }
	
	public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, ProxyBizFilter filter) {
        String backendUrl = router.route(this.backendUrls);
        filter.filter(fullRequest, ctx);
        final String url = backendUrl + fullRequest.uri();
        proxyService.submit(()->fetchGet(fullRequest, ctx, url));
    }
	
	private void fetchGet(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final String url) {
		Request request = new Request.Builder()
                .url(url)
                .build();
		
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
