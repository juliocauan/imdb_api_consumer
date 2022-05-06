package br.com.juliocauan.model.api.jsonParser;

import java.util.List;

import br.com.juliocauan.model.entity.Content;

public interface JsonParser<T extends Enum<T>> {

    List<? extends Content> parse();
    
}
