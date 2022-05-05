package br.com.juliocauan.model.api.jsonParser;

import java.util.List;

import br.com.juliocauan.model.entity.Content;

public abstract class JsonParser<T extends Enum<T>> {

    private final String json;

    protected JsonParser(String json) {
        this.json = json;
    }

    public final String getJson(){
        return json;
    }

    protected abstract List<? extends Content> parse();
    protected abstract String[] parseJson(String json);
    protected abstract String parseAttribute(String content, T attribute);
    
}
