package br.com.juliocauan.model.entity.config;

public abstract class Content {

    private String title;
    private String imageUrl;
    private Float rating;
    private Short year;

    public Content(String title, String year, String rating, String imageUrl){
        this.title = title;
        this.year = Short.valueOf(year);
        this.rating = Float.valueOf(rating);
        this.imageUrl = imageUrl;
    }
    
    public final Short getYear() {
        return year;
    }
    public final Float getRating() {
        return rating;
    }
    public final String getImageUrl() {
        return imageUrl;
    }
    public final void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public final String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("|Title: %30s|\n|Rating: %29s|\n|Year: %31s|\n|Image Url: %s\n",
        getTitle(), getRating(), getYear(), getImageUrl());
    }

}
