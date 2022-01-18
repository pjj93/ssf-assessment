package ibf2021.ssf.ssfassessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2021.ssf.ssfassessment.models.Result;
import ibf2021.ssf.ssfassessment.services.BookService;

@Controller
@RequestMapping(path="/book")
public class SearchContoller {
    @Autowired
    private BookService bookSvc;

    @GetMapping
    public String searchBook(@RequestParam String query, Model model) {
        List<Result> bookList = bookSvc.search(query.toLowerCase().trim().replace(" ", "+"));
        model.addAttribute("query", query.toLowerCase().trim());
        model.addAttribute("results", bookList);
        return "results";
    }
}
