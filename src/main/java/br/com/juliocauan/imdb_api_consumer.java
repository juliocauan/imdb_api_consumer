package br.com.juliocauan;

import java.io.PrintWriter;
import java.util.List;

import br.com.juliocauan.model.api.apiClient.ImdbApiClient;
import br.com.juliocauan.model.api.jsonParser.ImdbMovieJsonParser;
import br.com.juliocauan.model.entity.Movie;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {

        String apiKey = "k_jngird0l";
        String htmlName = "Top250Movies.html";
        
		String json = new ImdbApiClient(apiKey).getBody();
        
        List<Movie> movies = new ImdbMovieJsonParser(json).parse();
        new HTMLGenerator(new PrintWriter(htmlName)).generate(movies);
    }

}
