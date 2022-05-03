package br.com.juliocauan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ImdbMovieJsonParser {

    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movie> parse() {
        String[] moviesArray = parseJsonMovies(this.json);
        List<Movie> movies = new ArrayList<Movie>();
        Stream.of(moviesArray).forEach(movie ->movies.add(
            new Movie(
                parseAttribute(movie, GROUP.TITLE),
                parseAttribute(movie, GROUP.YEAR),
                parseAttribute(movie, GROUP.IMDB_RATING),
                parseAttribute(movie, GROUP.IMAGE_URL)
            )));
        return movies;
    }
    
    private static String[] parseJsonMovies(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    private static String parseAttribute(String movie, GROUP group) {
        return movie
            //Splits array by group
            .split("\",\"")[group.pos]
            //Removes group name
            .split("\":\"")[1]
            //Removes any remnant -> " <-
            .replaceAll("\"", "");
    }

}
