package Animals.first.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "books_service")
public class BooksModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int pages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libraryid", nullable = false)
    @JsonBackReference
    private LibraryModel library;

    public BooksModel() {}


    // Getters and setters
    // WSZYSTKIE elementy z daną nazwą muszą mieć taką samą nazwe, w tym tworzone metody/funkcje. Czyli przykładowo
    // oprócz zmiany nazwy utworzonej zmiennej, jest w miejscu getName i setName należy zmienić na getNazwa i setNazwa
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
}