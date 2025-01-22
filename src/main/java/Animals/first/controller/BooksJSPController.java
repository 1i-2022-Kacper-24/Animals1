package Animals.first.controller;

import Animals.first.model.BooksModel;
import Animals.first.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Books")
public class BooksJSPController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/viewBooks")
    public String viewBooks(Model model) {
        List<BooksModel> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "view-books";
    }
}