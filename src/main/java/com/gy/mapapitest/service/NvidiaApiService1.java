package com.gy.mapapitest.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NvidiaApiService1 {

    private static final String sk = "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";

    public static Response query(String content) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n" +
                "    \"model\": \"meta/llama3-70b-instruct\",\n" +
                "    \"messages\": [{\"role\":\"user\",\"content\":\""+ content +"\"}],\n" +
                "    \"temperature\": 0.5,\n" +
                "    \"top_p\": 1,\n" +
                "    \"max_tokens\": 1024,\n" +
                "    \"stream\": true\n" +
                "}");
        Request request = new Request.Builder()
                .url("https://integrate.api.nvidia.com/v1/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + sk)
                .build();

        Response response = client.newCall(request).execute();

        return response;
    }
}