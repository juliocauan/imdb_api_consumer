package br.com.juliocauan.model.api.jsonParser.ImbdJsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.ImdbEntity.Movie;

public class ImdbMovieJsonParser extends ImdbJsonParser{

    public ImdbMovieJsonParser(String json) {
        super(json);
    }

    @Override
    public List<Movie> parse() {
        String[] moviesArray = parseJson(getJson());
        List<Movie> movies = new ArrayList<Movie>();
        Stream.of(moviesArray).forEach(movie ->movies.add(
            new Movie(
                parseTitle(movie),
                parseYear(movie),
                parseRating(movie),
                parseImageUrl(movie)
            )));
        return movies;
    }
    
}
