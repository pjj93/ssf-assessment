package ibf2021.ssf.ssfassessment.model;

import jakarta.json.JsonObject;

public class Book {
    private String id;
    private String title;

    public Book(JsonObject o) {

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
