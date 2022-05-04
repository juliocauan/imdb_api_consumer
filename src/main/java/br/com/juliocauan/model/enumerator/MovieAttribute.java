package br.com.juliocauan.model.enumerator;

public enum MovieAttribute {
    TITLE(2),
    YEAR(4),
    IMAGE_URL(5),
    CREW(6),
    IMDB_RATING(7);

    public int pos;

    private MovieAttribute(int pos) {
        this.pos = pos;
    }
}
