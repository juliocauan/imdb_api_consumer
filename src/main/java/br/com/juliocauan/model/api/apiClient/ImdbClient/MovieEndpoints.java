package br.com.juliocauan.model.api.apiClient.ImdbClient;

public enum MovieEndpoints {

    TOP_250_MOVIES("Top250Movies"),
    TOP_250_TVS("Top250TVs");

    public final String endpoint;

    MovieEndpoints(String endpoint){
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return String.format(this.endpoint + ".html");
    }

}
