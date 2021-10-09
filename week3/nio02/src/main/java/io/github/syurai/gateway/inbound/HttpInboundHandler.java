package io.github.syurai.gateway.inbound;

import io.github.syurai.gateway.filter.ProxyBizFilter;
import io.github.syurai.gateway.outbound.okhttp.OkhttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    private OkhttpOutboundHandler okhttpOutboundHandler;
    ProxyBizFilter filter = new ProxyBizFilter();
    
    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.okhttpOutboundHandler = new OkhttpOutboundHandler(this.proxyServer);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            okhttpOutboundHandler.handle(fullRequest, ctx, filter);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
