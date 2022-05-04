package br.com.juliocauan.model.api.jsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.Movie;
import br.com.juliocauan.model.enumerator.MovieAttribute;

public class ImdbMovieJsonParser extends JsonParser<MovieAttribute>{

    public ImdbMovieJsonParser(String json) {
        super(json);
    }

    @Override
    public List<Movie> parse() {
        String[] moviesArray = parseJson(getJson());
        List<Movie> movies = new ArrayList<Movie>();
        Stream.of(moviesArray).forEach(movie ->movies.add(
            new Movie(
                parseAttribute(movie, MovieAttribute.TITLE),
                parseAttribute(movie, MovieAttribute.YEAR),
                parseAttribute(movie, MovieAttribute.IMDB_RATING),
                parseAttribute(movie, MovieAttribute.IMAGE_URL)
            )));
        return movies;
    }

    @Override
    protected String[] parseJson(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    @Override
    protected String parseAttribute(String movie, MovieAttribute attribute) {
        return movie
            //Splits array by group
            .split("\",\"")[attribute.pos]
            //Removes group name
            .split("\":\"")[1]
            //Removes any remnant -> " <-
            .replaceAll("\"", "");
    }

}
