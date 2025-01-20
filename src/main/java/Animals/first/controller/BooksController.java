package Animals.first.controller;

import Animals.first.model.BooksModel;
import Animals.first.model.LibraryModel;
import Animals.first.repository.BookRepository;
import Animals.first.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    // Odczyt wszystkich książek
    @GetMapping("/books")
    public List<BooksModel> getAllBooks() {
        return bookRepository.findAll();
    }



    // Odczyt wszystkich bibliotek
    @GetMapping("/libraries")
    public List<LibraryModel> getAllLibraries() {
        return libraryRepository.findAll();
    }


}
