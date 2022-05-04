package br.com.juliocauan.model.api.jsonParser;

import java.util.List;

import br.com.juliocauan.model.entity.Content;

public interface JsonParser {

    public List<? extends Content> parse();
    public String[] parseJson(String json);
    public String parseAttribute(String content, int pos);
    
}
