package br.com.juliocauan;

public enum GROUP {
    TITLE(2),
    YEAR(4),
    IMAGE_URL(5),
    CREW(6),
    IMDB_RATING(7);

    public int pos;

    private GROUP(int pos) {
        this.pos = pos;
    }
}
