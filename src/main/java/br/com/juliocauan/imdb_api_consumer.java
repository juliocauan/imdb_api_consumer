package br.com.juliocauan;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.juliocauan.model.api.apiClient.ImdbClient.ImdbApiClient;
import br.com.juliocauan.model.api.apiClient.ImdbClient.MovieEndpoint;
import br.com.juliocauan.model.api.apiClient.MarvelClient.MarvelApiClient;
import br.com.juliocauan.model.api.apiClient.MarvelClient.MarvelEndpoint;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbMovieJsonParser;
import br.com.juliocauan.model.api.jsonParser.ImbdJsonParser.ImdbSeriesJsonParser;
import br.com.juliocauan.model.api.jsonParser.MarvelJsonParser.MarvelComicsJsonParser;
import br.com.juliocauan.model.entity.ImdbEntity.Movie;
import br.com.juliocauan.model.entity.ImdbEntity.Serie;
import br.com.juliocauan.model.entity.MarvelEntity.Comic;

public class imdb_api_consumer{
    public static void main(String[] args) throws Exception {     
        //MOVIES - IMDB  
		String json = new ImdbApiClient().getBody(MovieEndpoint.TOP_250_MOVIES);
        List<Movie> movies = new ImdbMovieJsonParser(json).parse();
        Collections.sort(movies, Comparator.comparing(Movie::year));

        //SERIES - IMDB
		json = new ImdbApiClient().getBody(MovieEndpoint.TOP_250_TVS);
        List<Serie> series = new ImdbSeriesJsonParser(json).parse();

        //COMICS - MARVEL
        json = new MarvelApiClient().getBody(MarvelEndpoint.COMICS);
        List<Comic> comics = new MarvelComicsJsonParser(json).parse();
        System.out.println(json);

        new HTMLGenerator(new PrintWriter(MovieEndpoint.TOP_250_MOVIES.toString())).generate(movies);
        new HTMLGenerator(new PrintWriter(MovieEndpoint.TOP_250_TVS.toString())).generate(series);
    }

}
