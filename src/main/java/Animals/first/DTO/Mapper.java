package Animals.first.DTO;

import Animals.first.model.BooksModel;
import Animals.first.model.LibraryModel;

public class Mapper {

    public static BooksDTO toBooksDTO(BooksModel book) {
        return new BooksDTO(book.getTitle(), book.getPages());
    }

    public static LibraryDTO toLibraryDto(LibraryModel library) {
        return new LibraryDTO(library.getCity(), library.getName());
    }
}