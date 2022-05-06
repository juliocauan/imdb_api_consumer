package br.com.juliocauan.model.entity.MarvelEntity;

import br.com.juliocauan.model.entity.Content;

public record Comic(String title, Short year, Float rating, String imageUrl) implements Content{

    static MarvelContentType contentType = MarvelContentType.COMIC;

}
