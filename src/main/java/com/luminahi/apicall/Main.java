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

    private static String fetch(String uri) {
        String response = "";

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(uri))
            .GET().build();
            
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

        String response = fetch("https://dummyjson.com/products/1");
        Product product = gson.fromJson(response, Product.class);

        System.out.println(product);

    }
}