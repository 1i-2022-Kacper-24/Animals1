package Animals.first.DTO;

public class LibraryDTO {
    private Long id;
    private String city;
    private String name;

    // Konstruktor bezargumentowy
    public LibraryDTO() {}

    // Konstruktor z argumentami
    public LibraryDTO(String city, String name) {
        this.city = city;
        this.name = name;
    }

    // Gettery i settery

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
