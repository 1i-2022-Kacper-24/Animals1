package Animals.first.service;

import Animals.first.model.LibraryModel;
import Animals.first.repository.BookRepository;
import Animals.first.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryModel addLibrary(LibraryModel library) {
        return libraryRepository.save(library);
    }

    public List<LibraryModel> getAllLibraries() {
        return libraryRepository.findAll();
    }
}