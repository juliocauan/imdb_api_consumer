package br.com.juliocauan;
public class Movie {

    private String title;
    private String imageUrl;
    private Float rating;
    private Short year;

    public Movie(String title, String year, String rating, String imageUrl){
        this.title = title;
        this.year = Short.valueOf(year);
        this.rating = Float.valueOf(rating);
        this.imageUrl = imageUrl;
    }
    public Short getYear() {
        return year;
    }
    public Float getRating() {
        return rating;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("|Title: %30s|\n|IMDb Rating: %24s|\n|Year: %31s|\n|Image Url: %s\n",
        getTitle(), getRating(), getYear(), getImageUrl());
    }

}
