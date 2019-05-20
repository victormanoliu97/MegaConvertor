package com.example.megaconvertor.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverterService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String BASE_URL_LATEST_RATES = "https://api.exchangeratesapi.io/latest?base=";

    private static final String BASE_URL_CONVERT_API = "https://data.fixer.io/api/convert?access_key=";
    private static final String API_KEY = "2c5c97d961aba6ae6f61371ce2e74796";

    public JsonObject convert(String fromUnit, String toUnit, Double amount) throws IOException, JSONException {

        URL url = new URL(BASE_URL_CONVERT_API + API_KEY + "&from=" + fromUnit + "&to=" + toUnit + "&amount=" + amount);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);

        StringBuilder builder = null;
        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            String line;
            builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));


            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        JSONObject jsonObject = null;
        if (builder != null) {
            jsonObject = new JSONObject(builder.toString());
        }

        JsonParser jsonParser = new JsonParser();

        return jsonParser.parse(String.valueOf(jsonObject)).getAsJsonObject();
    }



    public JsonObject getLatestCurrencyRates(String fromUnit, String toUnit) throws IOException, JSONException {

        URL url = new URL(BASE_URL_LATEST_RATES + fromUnit + "&symbols=" + toUnit);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);

        StringBuilder builder = null;
        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            String line;
            builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));


            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        JSONObject jsonObject = null;
        if (builder != null) {
            jsonObject = new JSONObject(builder.toString());
        }

        JsonParser jsonParser = new JsonParser();

        return jsonParser.parse(String.valueOf(jsonObject)).getAsJsonObject();
    }
}
