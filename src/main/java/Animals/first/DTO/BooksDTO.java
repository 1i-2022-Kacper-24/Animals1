package Animals.first.DTO;

public class BooksDTO {
    private Long id;
    private String title;
    private int pages;

    // Konstruktor bezargumentowy
    public BooksDTO() {}

    // Konstruktor z argumentami
    public BooksDTO(String title, int pages) {
        this.title = title;
        this.pages = pages;
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
}