package com.example.demo;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtils {
    
    public static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    // GET调用
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    
    // POST调用
	public static String post(String url, String json) throws IOException {
    	RequestBody body = RequestBody.create(json, JSON);
    	Request request = new Request.Builder()
    			.url(url)
    			.post(body)
    			.build();
    	try (Response response = client.newCall(request).execute()) {
    	  return response.body().string();
    	}
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8801";
        String text = OkHttpUtils.get(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        // 清理资源
        OkHttpUtils.client = null;
    }
}
