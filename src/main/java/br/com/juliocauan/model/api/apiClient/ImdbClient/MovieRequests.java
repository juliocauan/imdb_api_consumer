package br.com.juliocauan.model.api.apiClient.ImdbClient;

public enum MovieRequests {

    TOP_250_MOVIES("Top250Movies"),
    TOP_250_TVS("Top250TVs");

    public String url;

    MovieRequests(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(this.url + ".html");
    }

}
