package com.example.megaconvertor.service;

import android.os.StrictMode;

import com.example.megaconvertor.utils.CurrencyConverter;
import com.google.gson.JsonElement;

import org.json.JSONException;

import java.io.IOException;

public class MakeCurrencyRequestService {

    public String getCurrentRatesRelativeToEuro() {
        CurrencyConverter currencyConverter = new CurrencyConverter();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if(SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try {
                return currencyConverter.getCurrentRatesRelativeToEuro().get("rates").toString();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Double returnConvertionRate(String from, String to) {
        CurrencyConverter currencyConverter = new CurrencyConverter();

        if(from.equalsIgnoreCase(to)) {
            return 1.0;
        }

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if(SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try {
                JsonElement conversionElement = currencyConverter.getLatestCurrencyRates(from, to).get("rates");
                return Double.valueOf(conversionElement.getAsJsonObject().get(to).toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
