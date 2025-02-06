package com.xxl.intelligent.manager;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * DeepSeek
 *
 * @Author: xxl
 * @Date: 2025/2/6 15:55
 */
@Service
public class DeepSeekManager {

    @Value("deepSeek.apiKey")
    private static String apiKey;

    /**
     * API地址
     */
//    private final static String baseUrl = "https://api.deepseek.com/v1";
    private final static String baseUrl = "https://api.deepseek.com/v1/chat/completions";

    private final static String model = "deepseek-chat";

    /**
     * AI 对话
     *
     * @param message
     * @return
     */
    public static String doChat(String message) {
        System.out.println("AI 请求参数" + message);
        apiKey = "sk-5b39f97595444f6cb0339e3c55bb0e76";

        // 构建请求体
        JSONObject requestBody = new JSONObject();
        requestBody.set("model", "deepseek-chat");

        JSONObject[] messages = new JSONObject[]{
//                new JSONObject().set("role", "system").set("content", "You are a helpful assistant"),
//                new JSONObject().set("role", "user").set("content", "Hello")
                new JSONObject().set("role", "user").set("content", message)
        };
        requestBody.set("messages", messages);
        requestBody.set("stream", false);

        // 发送 HTTP POST 请求
        HttpResponse response = HttpRequest.post(baseUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();

        // 解析响应
        if (response.isOk()) {
            JSONObject responseBody = JSONUtil.parseObj(response.body());
            String content = responseBody.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getStr("content");
            System.out.println("Response: " + content);
            return content;
        } else {
            System.out.println("Request failed with status code: " + response.getStatus());
            System.out.println("Response body: " + response.body());
            return response.body();
        }
    }
}
