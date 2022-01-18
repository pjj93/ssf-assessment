package ibf2021.ssf.ssfassessment.services;

import static ibf2021.ssf.ssfassessment.Constants.URL_SEARCH;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ibf2021.ssf.ssfassessment.SsfAssessmentApplication;
import ibf2021.ssf.ssfassessment.model.Book;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
@Service
public class BookService {
    private Logger logger = Logger.getLogger(SsfAssessmentApplication.class.getName());

    public List<Book> search (String searchTerm) {
        // logger.log(Level.INFO, "Search query >>> " + searchTerm);
        
        String url = UriComponentsBuilder
        .fromUriString(URL_SEARCH)
        .queryParam("title", searchTerm)
        .queryParam("limit", 20)
        .toUriString();

        RequestEntity<Void> req = RequestEntity
        .get(url)
        .accept(MediaType.APPLICATION_JSON)
        .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        // logger.log(Level.INFO, "Status code: " + resp.getStatusCodeValue());
        // logger.log(Level.INFO, "Book: " + resp.getBody());

        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            final JsonReader reader = Json.createReader(is);
            final JsonObject body = reader.readObject();
            final JsonArray docs = body.getJsonArray("docs");
            List<Book> bookList = new ArrayList<>();
            for(JsonValue v: docs) {
                JsonObject o = (JsonObject)v;
                Book book = new Book(o);
                bookList.add(book);
            }
 
            return bookList;

        } catch (Exception ex) { }

        return Collections.EMPTY_LIST;
    }
}
