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

    // Dodanie nowej książki
    @PostMapping("/books")
    public ResponseEntity<BooksModel> addBook(@RequestBody BooksModel newBook) {
        Optional<LibraryModel> library = libraryRepository.findById(newBook.getLibrary().getId());
        if (!library.isPresent()) {
            return ResponseEntity.badRequest().build(); // lub zwróć odpowiedni kod błędu
        }

        newBook.setLibrary(library.get());
        BooksModel savedBook = bookRepository.save(newBook);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedBook);
    }

    // Odczyt wszystkich bibliotek
    @GetMapping("/libraries")
    public List<LibraryModel> getAllLibraries() {
        return libraryRepository.findAll();
    }

    // Dodanie nowej biblioteki
    @PostMapping("/libraries")
    public ResponseEntity<LibraryModel> addLibrary(@RequestBody LibraryModel newLibrary) {
        LibraryModel savedLibrary = libraryRepository.save(newLibrary);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedLibrary.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedLibrary);
    }
}
