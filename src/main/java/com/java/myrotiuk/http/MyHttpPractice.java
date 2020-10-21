package com.java.myrotiuk.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Send HTTP GET Request using Java 11 HttpClient and parse JSON response into objects
 */
public class MyHttpPractice {
    private static final String POST_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POST_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //parse JSON inti Object
        ObjectMapper mapper = new ObjectMapper();
        List<Post> postList = mapper.readValue(response.body(), new TypeReference<List<Post>>(){});
        postList.forEach(System.out::println);
    }
}
