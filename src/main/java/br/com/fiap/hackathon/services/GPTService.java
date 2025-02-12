package br.com.fiap.hackathon.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class GPTService {

    public String run(String systemContent, String userContent){
        String apiKey = System.getenv("GPT_API_KEY");
        System.out.println(apiKey);
        String apiUrl = "https://api.aimlapi.com/v1/chat/completions";
        
        // Construindo o JSON do requestBody dinamicamente
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-4o");
        requestBody.put("messages", new org.json.JSONArray()
            .put(new JSONObject().put("role", "system").put("content", systemContent))
            .put(new JSONObject().put("role", "user").put("content", userContent))
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray choices = jsonResponse.getJSONArray("choices");

            if (choices.length() > 0) {
                JSONObject message = choices.getJSONObject(0).getJSONObject("message");
                return message.getString("content").trim();  // Retorna a mensagem extraída
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Oi!";
    }
}
