package br.com.juliocauan.model.entity.ImdbEntity;

import br.com.juliocauan.model.entity.Content;

public record Movie(String title, Short year, Float rating, String imageUrl) implements Content{

    static ImdbContentType contentType = ImdbContentType.MOVIE;

}
