package br.com.juliocauan;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {

        String apiKey = "k_jngird0l";
        URI top250MoviesURI = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey);

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(top250MoviesURI).timeout(Duration.ofSeconds(30L)).header("Content-Type", "application/json").GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println("Status Code: " + response.statusCode());

		String json = response.body();
        String[] movies = parseJsonMovies(json);
        List<String> titles = parseAttribute(movies, GROUP.TITLE);
        List<String> urlImages = parseAttribute(movies, GROUP.IMAGE_URL);
        List<String> years = parseAttribute(movies, GROUP.YEAR);
        List<String> rating = parseAttribute(movies, GROUP.IMDB_RATING);
        List<String> crew = parseAttribute(movies, GROUP.CREW);
        crew.forEach(System.out::println);
    }

    private static List<String> parseAttribute(String[] movies, GROUP group) {
        return Stream.of(movies)
            //Splits array by group
            .map(movie -> movie.split("\",\"")[group.pos])
            //Removes group name
            .map(movie -> movie.split("\":\"")[1])
            //Removes any remnant -> " <-
            .map(movie -> movie.replaceAll("\"", ""))
            .collect(Collectors.toList());
    }

    private static String[] parseJsonMovies(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

}
