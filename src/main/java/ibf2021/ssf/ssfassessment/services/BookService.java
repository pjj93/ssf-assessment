package ibf2021.ssf.ssfassessment.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import ibf2021.ssf.ssfassessment.SsfAssessmentApplication;
import ibf2021.ssf.ssfassessment.model.Book;

@Service
public class BookService {
    private Logger logger = Logger.getLogger(SsfAssessmentApplication.class.getName());

    public List<Book> search (String searchTerm) {
        logger.log(Level.INFO, "Search query >>> " + searchTerm);
        return null;
    }
}
