package br.com.juliocauan.model.api.jsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.Movie;
import br.com.juliocauan.model.enumerator.GROUP;

public class ImdbMovieJsonParser implements JsonParser{

    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    @Override
    public List<Movie> parse() {
        String[] moviesArray = parseJson(this.json);
        List<Movie> movies = new ArrayList<Movie>();
        Stream.of(moviesArray).forEach(movie ->movies.add(
            new Movie(
                parseAttribute(movie, GROUP.TITLE.pos),
                parseAttribute(movie, GROUP.YEAR.pos),
                parseAttribute(movie, GROUP.IMDB_RATING.pos),
                parseAttribute(movie, GROUP.IMAGE_URL.pos)
            )));
        return movies;
    }

    @Override
    public String[] parseJson(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    @Override
    public String parseAttribute(String movie, int pos) {
        return movie
            //Splits array by group
            .split("\",\"")[pos]
            //Removes group name
            .split("\":\"")[1]
            //Removes any remnant -> " <-
            .replaceAll("\"", "");
    }

}
