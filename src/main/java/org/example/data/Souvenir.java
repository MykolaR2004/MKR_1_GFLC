package org.example.data;

import java.io.Serializable;
import java.time.LocalDate;

public class Souvenir implements Serializable {
    private String souvenirName;
    private String requisites;
    private LocalDate releaseDate;
    private int price;

    public Souvenir(String souvenirName, String requisites, LocalDate releaseDate, int price) {
        this.souvenirName = souvenirName;
        this.requisites = requisites;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getReleaseYear() {
        return releaseDate.getYear();
    }

    @Override
    public String toString() {
        return souvenirName + " (" + releaseDate + ") - " + price + " UAH.";
    }

}
