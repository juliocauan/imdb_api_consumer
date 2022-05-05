package br.com.juliocauan.model.api.apiClient;

public abstract class ApiClient {
    
    private String apiKey;

    protected ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public final String getApiKey() {
        return apiKey;
    }

    protected abstract String getBody();

}
