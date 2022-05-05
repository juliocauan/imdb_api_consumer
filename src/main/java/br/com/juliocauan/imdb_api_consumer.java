package br.com.juliocauan;

import java.io.PrintWriter;
import java.util.List;

import br.com.juliocauan.model.api.apiClient.ImdbClient.ImdbApiClient;
import br.com.juliocauan.model.api.apiClient.ImdbClient.MovieRequests;
import br.com.juliocauan.model.api.jsonParser.ImdbMovieJsonParser;
import br.com.juliocauan.model.entity.Movie;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {        
		String imdbJson = new ImdbApiClient().getBody(MovieRequests.TOP_250_MOVIES);
        
        List<Movie> movies = new ImdbMovieJsonParser(imdbJson).parse();
        new HTMLGenerator(new PrintWriter(MovieRequests.TOP_250_MOVIES.toString())).generate(movies);
    }

}
