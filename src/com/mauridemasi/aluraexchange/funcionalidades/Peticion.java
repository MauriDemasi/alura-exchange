package com.mauridemasi.aluraexchange.funcionalidades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mauridemasi.aluraexchange.modelos.Conversion;
import com.mauridemasi.aluraexchange.modelos.ConversionRecord;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Peticion extends Conversion {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public Peticion() {
    }

    ConversionRecord conversionData = null;

    public double generarValorDeConversion(String base_code, String target_code) {
        try {

            String encodedBaseCode = URLEncoder.encode(base_code, "UTF-8");
            String encodedTargetCode = URLEncoder.encode(target_code, "UTF-8");

            // Reemplaza con la URL correcta de la API
            String direccion = "https://v6.exchangerate-api.com/v6/311eb8ea9bedaaef4f3bc3a7/pair/" + encodedBaseCode + "/" + encodedTargetCode;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la solicitud fue exitosa
            if (response.statusCode() != 200) {
                System.err.println("Error: La API devolvió un estado de respuesta no válido: " + response.statusCode());
                return 0.0;
            }

            String responseBody = response.body();
            conversionData = gson.fromJson(responseBody, ConversionRecord.class);

            // Verificar el campo "result"
            if (conversionData == null || !"success".equals(conversionData.getResult())) {
                System.err.println("Error: No se pudo obtener una respuesta válida.");
                return 0.0;
            }

            return conversionData.getConversion_rate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public String getBase_code() {
        return conversionData.getBase_code();
    }

    public String getTarget_code() {
        return conversionData.getTarget_code();
    }

}
