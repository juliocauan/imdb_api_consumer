package br.com.juliocauan.model.entity;

import br.com.juliocauan.model.enumerator.ContentType;

public abstract class Content {

    private String title;
    private String imageUrl;
    private Float rating;
    private Short year;
    private ContentType type;

    public Content(String title, String year, String rating, String imageUrl, ContentType type){
        this.title = title;
        this.year = Short.valueOf(year);
        this.rating = Float.valueOf(rating);
        this.imageUrl = imageUrl;
        this.type = type;
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
    public final ContentType getType(){
        return type;
    }

    @Override
    public String toString() {
        return String.format("|Title: %30s|\n|Rating: %30s|\n|Year: %30s|\n|Type: %30s|\n|Image Url: %s|\n",
        getTitle(), getRating(), getYear(), getImageUrl(), getType());
    }

}
