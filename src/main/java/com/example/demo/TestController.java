package com.example.demo;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class TestController {
    @GetMapping("/facts")
    public String hello() {
        StringBuilder response = null;
        String fact = null;

        String prefix = "Cat-fact of the day: ";

        try {
            String apiUrl = "https://catfact.ninja/fact";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonObject = new JSONObject(response.toString());
                fact = jsonObject.getString("fact");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;

        return prefix + fact;
    }
}
