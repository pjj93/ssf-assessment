package ibf2021.ssf.ssfassessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2021.ssf.ssfassessment.models.Book;
import ibf2021.ssf.ssfassessment.services.BookService;

@Controller
@RequestMapping(path="/book")
public class BookController {
    
    @Autowired
    private BookService bookSvc;

    @GetMapping(path="/{works_id}")
    public String searchBook(@PathVariable String works_id, Model model) {
        Book book = bookSvc.getBook(works_id);
        return "book";
    }
}
