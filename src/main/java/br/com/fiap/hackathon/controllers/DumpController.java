package br.com.fiap.hackathon.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DumpController {

    @GetMapping("/company")
    public String test(){
        String apiKey = "API KEY!";
        String apiUrl = "https://api.aimlapi.com/v1/chat/completions";
        String requestBody = "{" +
                "\"model\": \"gpt-4o\"," +
                "\"messages\": [" +
                "{\"role\": \"system\", \"content\": \"You are an AI assistant who knows everything.\"}," +
                "{\"role\": \"user\", \"content\": \"Tell me, why is the sky blue?\"}" +
                "]}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Oi!";
    }
        

}
