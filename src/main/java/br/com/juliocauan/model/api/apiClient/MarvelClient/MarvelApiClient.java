package br.com.juliocauan.model.api.apiClient.MarvelClient;

import br.com.juliocauan.model.api.apiClient.ApiClient;

public class MarvelApiClient extends ApiClient<MarvelEndpoint>{

    public MarvelApiClient(String apiKey, String apiUrl) {
        super(apiKey, apiUrl);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected String makeUrl(MarvelEndpoint endpoint) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
