package ibf2021.ssf.ssfassessment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/book")
public class BookController {
    
    @GetMapping
    public String searchBook(@RequestParam String query, Model model) {
        model.addAttribute("results", query);

        return "search";
    }
}
