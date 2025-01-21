package Animals.first.DTO;

import Animals.first.model.BooksModel;
import Animals.first.model.LibraryModel;

public class Mapper {

    public static BooksDTO toBooksDTO(BooksModel book) {
        String libraryName = book.getLibrary() != null ? book.getLibrary().getName() : null;
        return new BooksDTO(book.getTitle(), book.getPages(), libraryName);
    }

    public static LibraryDTO toLibraryDto(LibraryModel library) {
        return new LibraryDTO(library.getCity(), library.getName());
    }
}