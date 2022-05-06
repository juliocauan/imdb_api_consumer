package br.com.juliocauan.model.api.jsonParser.ImbdJsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.ImdbEntity.Serie;

public class ImdbSeriesJsonParser extends ImdbJsonParser{

    public ImdbSeriesJsonParser(String json) {
        super(json);
    }

    @Override
    public List<Serie> parse() {
        String[] seriesArray = parseJson(getJson());
        List<Serie> series = new ArrayList<Serie>();
        Stream.of(seriesArray).forEach(serie -> series.add(
            new Serie(
                parseTitle(serie),
                parseYear(serie),
                parseRating(serie),
                parseImageUrl(serie)
            )));
        return series;
    }

}
