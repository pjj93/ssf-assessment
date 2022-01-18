package ibf2021.ssf.ssfassessment.models;

public class Book {
    private String title;
    private String description;
    private String excerpt;
    private String cached;

    public Book() {
        this.title = null;
        this.description = null;
        this.excerpt = null;
        this.cached = "false";
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getCached() {
        return cached;
    }

    public void setCached(String cached) {
        this.cached = cached;
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
