package org.ezone.pae.serviciosweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.ezone.pae.serviciosweb.model.Cliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private static final String URL =
            "https://sqpvqkkdfgtzdgrjrgxs.supabase.co/rest/v1/customers?select=*";

    public List<Cliente> obtenerClientes() throws IOException, InterruptedException {

        // Obtenemos la API Key desde IntelliJ.
        String apiKey = System.getenv("apiKey");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("La variable apiKey no está configurada.");
        }

        HttpClient cliente = HttpClient.newHttpClient();

        // Incluimos la API Key requerida por Supabase.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .timeout(Duration.ofSeconds(15))
                .header("apikey", apiKey)
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException(
                    "Error al obtener clientes. Código HTTP: " + response.statusCode()
            );
        }

        // Adaptamos los nombres de las propiedades JSON.
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        JsonNode datos = mapper.readTree(response.body());

        if (!datos.isArray()) {
            throw new IOException("La respuesta no contiene un arreglo JSON.");
        }

        List<Cliente> clientes = new ArrayList<>();

        for (JsonNode nodo : datos) {
            Cliente clienteActual = mapper.treeToValue(nodo, Cliente.class);
            clientes.add(clienteActual);
        }

        return clientes;
    }
}
