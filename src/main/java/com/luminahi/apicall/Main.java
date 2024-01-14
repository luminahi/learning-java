package com.luminahi.apicall;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

public class Main {

    private static String fetch() {
        String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImthcmVuQG1haWwuY29tIiwiaWF0IjoxNzA1MTk3OTgwNDQ0LCJleHAiOjE3MDUyMDE1ODA0NDR9.MoCWfdCvSAE0FlXzlsamr813OF62gHgyboKW1HSKrZE";
        String response = "";

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("http://localhost:3000/api/v1/teachers/2"))
            .header("Authorization", "Bearer " + accessToken).GET().build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(request, BodyHandlers.ofString());
            response = httpResponse.body();

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static void main(String[] args) {

        Gson gson = new Gson();

        // String requestJson = gson.toJson(new Teacher("alex", "lima", "alex@mail.com", 1));
        // System.out.println(requestJson);

        String response = fetch();
        System.out.println(response);
        Result obj = gson.fromJson(response, Result.class);

        System.out.println(obj.result.getId());
        System.out.println(obj.result.getCourseId());
        System.out.println(obj.result.getEmail());
        System.out.println(obj.result.getFirstName());
        System.out.println(obj.result.getLastName());
    }
}