package org.example.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerSouvenirPair implements Serializable {
    private String name;
    private String souvenirName;

    public ManufacturerSouvenirPair(String name, String souvenirName) {
        this.name = name;
        this.souvenirName = souvenirName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    @Override
    public String toString() {
        return name + " - " + souvenirName;
    }
}
