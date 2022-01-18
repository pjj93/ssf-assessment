package ibf2021.ssf.ssfassessment.models;

import jakarta.json.JsonObject;

public class Book {
    private String title;
    private String description;
    private String exerpt;
    private Boolean isCached;

    public Book(JsonObject o) {
        this.title = o.getString("title");
    }

    public Boolean getIsCached() {
        return isCached;
    }

    public void setIsCached(Boolean isCached) {
        this.isCached = isCached;
    }

    public String getExerpt() {
        return exerpt;
    }

    public void setExerpt(String exerpt) {
        this.exerpt = exerpt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book() {}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
