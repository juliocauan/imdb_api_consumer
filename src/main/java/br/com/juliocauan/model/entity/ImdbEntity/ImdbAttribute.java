package br.com.juliocauan.model.entity.ImdbEntity;

public enum ImdbAttribute {
    TITLE(2),
    YEAR(4),
    IMAGE_URL(5),
    CREW(6),
    IMDB_RATING(7);

    public int pos;

    private ImdbAttribute(int pos) {
        this.pos = pos;
    }
}
