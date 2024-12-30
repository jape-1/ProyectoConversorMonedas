import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Moneda buscarconversion(String monedainicial, String monedaconvertida) throws IOException, InterruptedException {

        String cadena  =  "https://v6.exchangerate-api.com/v6/ac18acc9ccb67498a17de28a/pair/"+monedainicial+"/"+monedaconvertida;
        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()  //que es lo que le pediremos al servidor
                    .uri(URI.create(cadena))
                    .build();

            response = client  //para administrar la respuesta recibida del request, body para el json
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }  //nuestro cliente

        String json = response.body();

        Gson gson = new Gson();//-- version que crea la predeterminada

        return gson.fromJson(json, Moneda.class);
    }
}
