package br.com.juliocauan;

import java.io.PrintWriter;
import java.util.List;

import br.com.juliocauan.model.api.apiClient.ImdbClient.ImdbApiClient;
import br.com.juliocauan.model.api.apiClient.ImdbClient.MovieEndpoints;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbMovieJsonParser;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbSeriesJsonParser;
import br.com.juliocauan.model.entity.ImdbEntity.Movie;
import br.com.juliocauan.model.entity.ImdbEntity.Series;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {        
		String imdbJson = new ImdbApiClient().getBody(MovieEndpoints.TOP_250_MOVIES);
        List<Movie> movies = new ImdbMovieJsonParser(imdbJson).parse();

		imdbJson = new ImdbApiClient().getBody(MovieEndpoints.TOP_250_TVS);
        List<Series> series = new ImdbSeriesJsonParser(imdbJson).parse();

        new HTMLGenerator(new PrintWriter(MovieEndpoints.TOP_250_MOVIES.toString())).generate(movies);
        new HTMLGenerator(new PrintWriter(MovieEndpoints.TOP_250_TVS.toString())).generate(series);
    }

}
