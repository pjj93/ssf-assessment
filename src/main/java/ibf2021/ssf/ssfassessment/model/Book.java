package ibf2021.ssf.ssfassessment.model;

import jakarta.json.JsonObject;

public class Book {
    private String id;
    private String title;
    private String cover;

    public Book(JsonObject o) {
        this.id = o.getString("key").replace("/works/", "");
        this.title = o.getString("title");
        this.cover = "https://covers.openlibrary.org/b/id/" + o.getJsonNumber("cover_i") + ".jpg";
    }

    public Book() {}

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
