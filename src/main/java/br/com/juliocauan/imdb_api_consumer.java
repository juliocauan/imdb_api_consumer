package br.com.juliocauan;

import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {

        String apiKey = "k_jngird0l";
        String htmlName = "Top250Movies";
        URI top250MoviesURI = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey);

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(top250MoviesURI).timeout(Duration.ofSeconds(30L)).header("Content-Type", "application/json").GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println("Status Code: " + response.statusCode());
		String json = response.body();
        
        List<Movie> movies = Movie.parseJsonToMovieList(json);
        HTMLGenerator html = new HTMLGenerator(new PrintWriter(htmlName));
        html.generate(movies);
    }

}
