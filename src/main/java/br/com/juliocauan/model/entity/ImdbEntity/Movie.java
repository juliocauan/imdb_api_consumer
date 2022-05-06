package br.com.juliocauan.model.entity.ImdbEntity;

import br.com.juliocauan.model.entity.Content;

public class Movie extends Content{

    public Movie(String title, String year, String rating, String imageUrl){
        super(title, year, rating, imageUrl, ImdbContentType.MOVIE);
    }

}
