package ibf2021.ssf.ssfassessment.models;

public class Book {
    private String title;
    private String description;
    private String excerpt;
    private Boolean isCached;

    public Book() {
        this.title = null;
        this.description = null;
        this.excerpt = null;
        this.isCached = false;
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Boolean getIsCached() {
        return isCached;
    }

    public void setIsCached(Boolean isCached) {
        this.isCached = isCached;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
