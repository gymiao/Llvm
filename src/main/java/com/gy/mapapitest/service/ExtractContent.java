package com.gy.mapapitest.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtractContent {
    public static String extract(String input) {


        // Remove 'data: [DONE]' from input string
        input = input.replace("data: [DONE]", "").trim();

        // Remove newlines between data chunks
        input = input.replace("\n", "");

        // Split input string into individual data chunks
        String[] dataChunks = input.split("data: ");

        StringBuilder stringBuilder = new StringBuilder("");
        // Iterate over each data chunk and extract content field
        for (String dataChunk : dataChunks) {
            if (!dataChunk.trim().isEmpty()) {
                try {
                    // Add missing quotes to JSON keys and parse JSON object
                    String jsonString = dataChunk.replaceAll("(\\w+):", "\"$1\":").trim();
                    JSONObject jsonObject = new JSONObject(jsonString);

                    // Extract content field from JSON object
                    JSONArray choicesArray = jsonObject.getJSONArray("choices");
                    for (int i = 0; i < choicesArray.length(); i++) {
                        JSONObject choice = choicesArray.getJSONObject(i);
                        JSONObject delta = choice.getJSONObject("delta");

                        if (delta.has("content")) {
                            String content = delta.getString("content");
                            content = content.replace("\n", "");
                            stringBuilder.append(content);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}