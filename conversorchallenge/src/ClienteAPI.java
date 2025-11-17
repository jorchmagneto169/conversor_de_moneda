import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ClienteAPI {

    private static final String API_KEY = "d1bd7b1532e2a1be8d1ab14c";

    public static double obtenerTasa(String base, String destino) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino;

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa: " + e.getMessage());
            return 0;
        }
    }
}