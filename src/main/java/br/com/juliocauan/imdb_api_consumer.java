package br.com.juliocauan;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.juliocauan.model.api.apiClient.ImdbClient.ImdbApiClient;
import br.com.juliocauan.model.api.apiClient.ImdbClient.MovieEndpoint;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbMovieJsonParser;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbSeriesJsonParser;
import br.com.juliocauan.model.entity.ImdbEntity.Movie;
import br.com.juliocauan.model.entity.ImdbEntity.Series;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {     
        //MOVIES - IMDB  
		String imdbJson = new ImdbApiClient().getBody(MovieEndpoint.TOP_250_MOVIES);
        List<Movie> movies = new ImdbMovieJsonParser(imdbJson).parse();
        Collections.sort(movies, Comparator.comparing(Movie::year));

        //SERIES - IMDB
		imdbJson = new ImdbApiClient().getBody(MovieEndpoint.TOP_250_TVS);
        List<Series> series = new ImdbSeriesJsonParser(imdbJson).parse();

        new HTMLGenerator(new PrintWriter(MovieEndpoint.TOP_250_MOVIES.toString())).generate(movies);
        new HTMLGenerator(new PrintWriter(MovieEndpoint.TOP_250_TVS.toString())).generate(series);
    }

}
