package br.com.juliocauan.model.api.apiClient.MarvelClient;

public enum MarvelEndpoint {
    COMICS("comics");

    public final String endpoint;

    MarvelEndpoint(String endpoint){
        this.endpoint = endpoint;
    }

}
