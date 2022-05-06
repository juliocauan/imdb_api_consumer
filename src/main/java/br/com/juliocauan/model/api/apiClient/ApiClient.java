package br.com.juliocauan.model.api.apiClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public abstract class ApiClient<T extends Enum<T>> {
    
    private final String apiKey;
    private final String apiUrl;

    protected ApiClient(String apiKey, String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    protected final String getApiKey() {
        return apiKey;
    }
    protected final String getApiUrl(){
        return apiUrl;
    }

    protected abstract String makeUrl(T endpoint);

    public final String getBody(T endpoint) {
        try {

            URI url = URI.create(makeUrl(endpoint));
            HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .timeout(Duration.ofSeconds(30L))
                .header("Content-Type", "application/json")
                .GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode() + "\nFor " + endpoint.name() + " request");
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
