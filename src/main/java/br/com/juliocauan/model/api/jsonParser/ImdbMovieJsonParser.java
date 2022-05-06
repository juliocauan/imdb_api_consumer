package br.com.juliocauan.model.api.jsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.ImdbEntity.ImdbAttribute;
import br.com.juliocauan.model.entity.ImdbEntity.Movie;

public class ImdbMovieJsonParser implements JsonParser<ImdbAttribute>{

    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    @Override
    public List<Movie> parse() {
        String[] moviesArray = parseJson(json);
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

    @Override
    public String[] parseJson(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    @Override
    public String parseAttribute(String content, ImdbAttribute attribute) {
        return content
            //Splits array by group
            .split("\",\"")[attribute.pos]
            //Removes group name
            .split("\":\"")[1]
            //Removes any remnant -> " <-
            .replaceAll("\"", "");
    }
    private String parseTitle(String content){
        return parseAttribute(content, ImdbAttribute.TITLE);
    }
    private Short parseYear(String content){
        return Short.valueOf(parseAttribute(content, ImdbAttribute.YEAR));
    }
    private Float parseRating(String content){
        return Float.valueOf(parseAttribute(content, ImdbAttribute.IMDB_RATING));
    }
    private String parseImageUrl(String content){
        return parseAttribute(content, ImdbAttribute.IMAGE_URL);
    }
    
}
