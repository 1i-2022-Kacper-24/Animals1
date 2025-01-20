package Animals.first.service;

import Animals.first.model.BooksModel;
import Animals.first.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BooksModel addAnimal(BooksModel book) {
        return bookRepository.save(book);
    }

    public List<BooksModel> getAllBooks() {
        return bookRepository.findAll();
    }
}