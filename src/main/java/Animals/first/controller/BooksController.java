package Animals.first.controller;

import Animals.first.DTO.BooksDTO;
import Animals.first.DTO.LibraryDTO;
import Animals.first.model.BooksModel;
import Animals.first.model.LibraryModel;
import Animals.first.repository.BookRepository;
import Animals.first.repository.LibraryRepository;

import Animals.first.service.BooksService;
import Animals.first.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private BooksService booksService;
    @Autowired
    private LibraryService libraryService;

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    public BooksController(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    // Odczyt wszystkich książek
    @GetMapping("/books")
    public List<BooksModel> getAllBooks() {
        return bookRepository.findAll();
    }

    // Dodanie nowej książki
    @PostMapping("/books")
    public ResponseEntity<BooksDTO> createBook(@RequestBody BooksDTO booksDTO) {
        BooksModel book = new BooksModel();
        book.setTitle(booksDTO.getTitle());
        book.setPages(booksDTO.getPages());
        book = bookRepository.save(book);
        return new ResponseEntity<>(toBooksDTO(book), HttpStatus.CREATED);

    }


    // Odczyt wszystkich bibliotek
    @GetMapping("/libraries")
    public List<LibraryModel> getAllLibraries() {
        return libraryRepository.findAll();
    }

    // Dodanie nowej biblioteki
    @PostMapping("/libraries")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        LibraryModel library = new LibraryModel();
        library.setCity(libraryDTO.getCity());
        library.setName(libraryDTO.getName());
        library = libraryRepository.save(library);
        return new ResponseEntity<>(toLibraryDTO(library), HttpStatus.CREATED);
    }

    // Metody pomocnicze do konwersji
    private BooksDTO toBooksDTO(BooksModel book) {
        return new BooksDTO(book.getTitle(), book.getPages());
    }

    private LibraryDTO toLibraryDTO(LibraryModel library) {
        return new LibraryDTO(library.getCity(), library.getName());
    }

}