package br.com.juliocauan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Movie {

    private String title;
    private String imageUrl;
    private Float rating;
    private Short year;

    public static List<Movie> parseJsonToMovieList(String json) {
        String[] moviesArray = parseJsonMovies(json);
        List<Movie> movies = new ArrayList<Movie>();
        Stream.of(moviesArray).forEach(movie -> movies.add(new Movie(movie)));
        return movies;
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
    private static String[] parseJsonMovies(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    private Movie(String movie){
        this.title = parseAttribute(movie, GROUP.TITLE);
        this.imageUrl = parseAttribute(movie, GROUP.IMAGE_URL);
        this.rating = Float.valueOf(parseAttribute(movie, GROUP.IMDB_RATING));
        this.year = Short.valueOf(parseAttribute(movie, GROUP.YEAR));
    }
    public Movie(String title, Short year) {
        this.title = title;
        this.year = year;
        this.rating = 0f;
    }
    public Movie(String title, Short year, String imageUrl) {
        this(title, year);
        this.imageUrl = imageUrl;
    }
    public Short getYear() {
        return year;
    }
    public Float getRating() {
        return rating;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("|Title: %30s|\n|IMDb Rating: %24s|\n|Year: %31s|\n|Image Url: %s\n",
        getTitle(), getRating(), getYear(), getImageUrl());
    }

}
