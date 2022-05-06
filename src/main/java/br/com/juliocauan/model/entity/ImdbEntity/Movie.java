package br.com.juliocauan.model.entity.ImdbEntity;

import br.com.juliocauan.model.entity.Content;

public record Movie(String title, Short year, Float rating, String imageUrl) implements Content,
    Comparable<Movie>{

    static ImdbContentType contentType = ImdbContentType.MOVIE;

    @Override
    public int compareTo(Movie other) {
        return this.rating().compareTo(other.rating());
    }

}
