package com.converter.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateService {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String urlStr = API_URL + fromCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONObject rates = jsonResponse.getJSONObject("rates");
        
        return rates.getDouble(toCurrency);
    }
}
