package br.com.juliocauan.model.api.jsonParser.ImbdJsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.juliocauan.model.entity.ImdbEntity.Series;

public class ImdbSeriesJsonParser extends ImdbJsonParser{

    public ImdbSeriesJsonParser(String json) {
        super(json);
    }

    @Override
    public List<Series> parse() {
        String[] seriesArray = parseJson(getJson());
        List<Series> series = new ArrayList<Series>();
        Stream.of(seriesArray).forEach(serie -> series.add(
            new Series(
                parseTitle(serie),
                parseYear(serie),
                parseRating(serie),
                parseImageUrl(serie)
            )));
        return series;
    }

}
