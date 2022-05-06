package br.com.juliocauan.model.api.apiClient.ImdbClient;

public enum MovieEndpoint {

    TOP_250_MOVIES("Top250Movies"),
    TOP_250_TVS("Top250TVs");

    public final String endpoint;

    MovieEndpoint(String endpoint){
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return String.format(this.endpoint + ".html");
    }

}
