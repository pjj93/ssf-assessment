package ibf2021.ssf.ssfassessment.models;

import jakarta.json.JsonObject;

public class Book {
    private String id;
    private String title;

    public Book(JsonObject o) {
        this.id = o.getString("key").replace("/works/", "");
        this.title = o.getString("title");
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
}
