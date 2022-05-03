package br.com.juliocauan;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ImdbApiClient {

    private String apiKey;

    public ImdbApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBody() {
        URI top250MoviesURI = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey);
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder()
            .uri(top250MoviesURI)
            .timeout(Duration.ofSeconds(30L))
            .header("Content-Type", "application/json")
            .GET().build();
		HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("Status Code: " + response.statusCode());
        return response.body();
    }
    
}
