package br.com.juliocauan.model.entity;

import br.com.juliocauan.model.entity.interfaces.Content;

public class Movie extends Content{

    public Movie(String title, String year, String rating, String imageUrl){
        super(title, year, rating, imageUrl);
    }
    
}
