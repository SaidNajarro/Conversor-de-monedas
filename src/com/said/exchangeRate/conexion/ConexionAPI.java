package com.said.exchangeRate.conexion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.said.exchangeRate.modelos.TipoDeCambio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConexionAPI {

    private static final String claveAPI = "72a733ab5a6e925625c29d66";
    private final HttpClient client;
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();

    public ConexionAPI() {
        this.client = HttpClient.newHttpClient();
    }

    public String obtenerCambioJson(String coidgoMoneda){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+claveAPI+"/latest/"+coidgoMoneda))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.err.println("Error al obtener tasa de cambio: " + e.getMessage());
            return null;
        }
    }

    public TipoDeCambio obtenerTipoDeCambio(String json){
        Map<String, Object> jsonMap = gson.fromJson(json, Map.class);

        //Lo que se hace es que se está casteando los elementos a Double del jsonMap
        Map<String, Double> conversionRates = (Map<String, Double>) jsonMap.get("conversion_rates");

        TipoDeCambio tipoDeCambio = new TipoDeCambio();

        tipoDeCambio.setUSD(conversionRates.get("USD"));
        tipoDeCambio.setEUR(conversionRates.get("EUR"));
        tipoDeCambio.setJPY(conversionRates.get("JPY"));
        tipoDeCambio.setGBP(conversionRates.get("GBP"));
        tipoDeCambio.setAUD(conversionRates.get("AUD"));

        return tipoDeCambio;
    }
}
