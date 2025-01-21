package Animals.first.DTO;

public class BooksDTO {
    private Long id;
    private String title;
    private int pages;
    private String libraryName;

    // Konstruktor bezargumentowy
    public BooksDTO() {}

    // Konstruktor z argumentami
    public BooksDTO(String title, int pages, String libraryName) {
        this.title = title;
        this.pages = pages;
        this.libraryName = libraryName;
    }

    // Gettery i settery

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

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

}