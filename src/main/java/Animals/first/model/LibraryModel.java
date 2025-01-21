package Animals.first.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_service")
public class LibraryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BooksModel> booksList = new ArrayList<>();

    // Konstruktor bezargumentowy
    public LibraryModel() {}
    public LibraryModel(String name, String city) {
        this.name = name;
        this.city = city;
    }

// Gettery i settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<BooksModel> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BooksModel> booksList) {
        this.booksList = booksList;
    }

    public void addBook(BooksModel book) {
        booksList.add(book);
        book.setLibrary(this);
    }
}