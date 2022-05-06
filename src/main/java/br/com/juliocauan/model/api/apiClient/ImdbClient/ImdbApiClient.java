package br.com.juliocauan.model.api.apiClient.ImdbClient;

import br.com.juliocauan.model.api.apiClient.ApiClient;

public class ImdbApiClient extends ApiClient<MovieEndpoints> {

    public ImdbApiClient() {
        super("k_jngird0l", "https://imdb-api.com/en/API/");
    }

    @Override
    public String getBody(MovieEndpoints apiRequest) {
        return super.makeRequest(apiRequest);
    }

    @Override
    protected String makeUrl(MovieEndpoints request) {
        return String.format(getApiUrl() + request.endpoint + "/" + getApiKey());
    }
    
}
