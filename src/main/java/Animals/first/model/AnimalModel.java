package Animals.first.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private int wiek;
    private int nogi;

    // Getters and setters
    // WSZYSTKIE elementy z daną nazwą muszą mieć taką samą nazwe, w tym tworzone metody/funkcje. Czyli przykładowo
    // oprócz zmiany nazwy utworzonej zmiennej, jest w miejscu getName i setName należy zmienić na getNazwa i setNazwa
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public int getWiek() {
        return wiek;
    }
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
    public int getNogi() {
        return nogi;
    }
    public void setNogi(int nogi) {
        this.nogi = nogi;
    }
}