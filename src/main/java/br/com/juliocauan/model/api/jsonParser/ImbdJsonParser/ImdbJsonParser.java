package br.com.juliocauan.model.api.jsonParser.ImbdJsonParser;

import br.com.juliocauan.model.api.jsonParser.JsonParser;
import br.com.juliocauan.model.entity.ImdbEntity.ImdbAttribute;

public abstract class ImdbJsonParser implements JsonParser<ImdbAttribute> {
    
    private final String json;

    protected ImdbJsonParser(String json) {
        this.json = json;
    }

    protected final String getJson(){
        return json;
    }

    protected String[] parseJson(String json) {
        return json.substring(11, json.length()-21).split("\\}.\\{");
    }

    protected String parseAttribute(String content, ImdbAttribute attribute) {
        return content
            //Splits array by group
            .split("\",\"")[attribute.pos]
            //Removes group name
            .split("\":\"")[1]
            //Removes any remnant -> " <-
            .replaceAll("\"", "");
    }

    protected String parseTitle(String content){
        return parseAttribute(content, ImdbAttribute.TITLE);
    }
    protected Short parseYear(String content){
        return Short.valueOf(parseAttribute(content, ImdbAttribute.YEAR));
    }
    protected Float parseRating(String content){
        return Float.valueOf(parseAttribute(content, ImdbAttribute.IMDB_RATING));
    }
    protected String parseImageUrl(String content){
        return parseAttribute(content, ImdbAttribute.IMAGE_URL);
    }
}
