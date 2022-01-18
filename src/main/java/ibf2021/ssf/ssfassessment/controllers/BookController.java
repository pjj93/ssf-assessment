package ibf2021.ssf.ssfassessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2021.ssf.ssfassessment.services.BookService;

@Controller
@RequestMapping(path="/book")
public class BookController {
    
    @Autowired
    private BookService bookSvc;

}
