package Animals.first.controller;

import Animals.first.DTO.BooksDTO;
import Animals.first.DTO.LibraryDTO;
import Animals.first.DTO.Mapper;
import Animals.first.model.BooksModel;
import Animals.first.model.LibraryModel;
import Animals.first.repository.BookRepository;
import Animals.first.repository.LibraryRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;




@RestController
@RequestMapping("/Books")
public class BooksController {



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

        LibraryModel library = libraryRepository.findByName(booksDTO.getLibraryName()).orElse(null);
        BooksModel book = new BooksModel();
        book.setTitle(booksDTO.getTitle());
        book.setPages(booksDTO.getPages());
        book.setLibrary(library);
        book = bookRepository.save(book);

        assert library != null;
        library.addBook(book);
        libraryRepository.save(library);

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
        LibraryModel library = libraryRepository.save(new LibraryModel(libraryDTO.getName(), libraryDTO.getCity()));
        return new ResponseEntity<>(toLibraryDTO(library), HttpStatus.CREATED);
    }

    // Metody pomocnicze do konwersji
    private BooksDTO toBooksDTO(BooksModel book) {
        return Mapper.toBooksDTO(book);
    }

    private LibraryDTO toLibraryDTO(LibraryModel library) {
        return new LibraryDTO(library.getCity(), library.getName());
    }

}