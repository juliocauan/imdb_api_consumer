package br.com.juliocauan.model.api.apiClient.ImdbClient;

import br.com.juliocauan.model.api.apiClient.ApiClient;

public class ImdbApiClient extends ApiClient<MovieEndpoint> {

    public ImdbApiClient() {
        super("k_jngird0l", "https://imdb-api.com/en/API/");
    }

    @Override
    protected String makeUrl(MovieEndpoint request) {
        return String.format(getApiUrl() + request.endpoint + "/" + getApiKey());
    }
    
}
