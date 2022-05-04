package br.com.juliocauan.model.api.apiClient;

public abstract class ApiClient {
    
    private String apiKey;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public final String getApiKey() {
        return apiKey;
    }

    public abstract String getBody();

}