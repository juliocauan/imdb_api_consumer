package br.com.juliocauan.model.api.apiClient.ImdbClient;

import br.com.juliocauan.model.api.apiClient.ApiClient;

public class ImdbApiClient extends ApiClient<MovieRequests> {

    public ImdbApiClient() {
        super("k_jngird0l", "https://imdb-api.com/en/API/");
    }

    @Override
    public String getBody(MovieRequests apiRequest) {
        return super.makeRequest(apiRequest);
    }

    @Override
    protected String makeUrl(MovieRequests request) {
        return String.format(getApiUrl() + request.url + "/" + getApiKey());
    }
    
}
