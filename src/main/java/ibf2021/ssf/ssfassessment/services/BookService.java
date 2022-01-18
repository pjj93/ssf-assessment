package ibf2021.ssf.ssfassessment.services;

import static ibf2021.ssf.ssfassessment.Constants.URL_BOOK;
import static ibf2021.ssf.ssfassessment.Constants.URL_SEARCH;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ibf2021.ssf.ssfassessment.SsfAssessmentApplication;
import ibf2021.ssf.ssfassessment.models.Book;
import ibf2021.ssf.ssfassessment.models.Result;
import ibf2021.ssf.ssfassessment.repository.BookRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
@Service
public class BookService {
    private Logger logger = Logger.getLogger(SsfAssessmentApplication.class.getName());

    @Autowired
    private BookRepository bookRepo;

    public List<Result> search (String searchTerm) {
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
            List<Result> resultList = new ArrayList<>();
            for(JsonValue v: docs) {
                JsonObject o = (JsonObject)v;
                Result result = new Result(o);
                resultList.add(result);
            }
 
            return resultList;

        } catch (Exception ex) { }

        return Collections.EMPTY_LIST;
    }

    public Book getBook(String works_id) {
        
        String url = UriComponentsBuilder
        .fromUriString(URL_BOOK + "/" + works_id + ".json")
        .toUriString();

        // logger.log(Level.INFO, "url: " + url);

        RequestEntity<Void> req = RequestEntity
        .get(url)
        .accept(MediaType.APPLICATION_JSON)
        .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        // logger.log(Level.INFO, "Status code: " + resp.getStatusCodeValue());
        logger.log(Level.INFO, "Book: " + resp.getBody());

        Book book = new Book();

        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            final JsonReader reader = Json.createReader(is);
            final JsonObject body = reader.readObject();
            final String title = body.getString("title");
            book.setTitle(title);
            //final String description;
            
            if (body.containsKey("description")) {
                // Object obj = body.get("description");
                // if (obj instanceof String){
                    final String description = body.getString("description");
                    book.setDescription(description);
                // }
            } else {
                book.setDescription("<No Description available>");
            }
            if (body.containsKey("excerpts")) {
                final JsonArray excerpts = body.getJsonArray("excerpts");
                final String firstExcerpt = excerpts.getJsonObject(0).getString("excerpt");
                book.setExcerpt(firstExcerpt);
            } else {
                book.setExcerpt("<No Excerpt Available>");
            }

            return book;

        } catch (Exception ex) { 
            ex.printStackTrace();
        }

        return null;
    }
}
