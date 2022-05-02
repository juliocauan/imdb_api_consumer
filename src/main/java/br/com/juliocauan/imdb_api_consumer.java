package br.com.juliocauan;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {
		HttpClient client = HttpClient.newBuilder()
			.version(Version.HTTP_2)
			.build();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_jngird0l"))
			.timeout(Duration.ofMinutes(1))
			.header("Content-Type", "application/json")
			.GET()
			.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.statusCode());
		String json = response.body().substring(10, response.body().length()-20);
		System.out.println(json);
		ArrayList<String> movies = new ArrayList<String>();
    }
}
