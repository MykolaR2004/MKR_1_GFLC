package org.example.data;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class MSPairList {
    private int size = 0;
    private ManufacturerSouvenirPair[] pairs = new ManufacturerSouvenirPair[1];


    private void ensureCapacity(int newCapacity) {
        if (newCapacity <= pairs.length) return;
        ManufacturerSouvenirPair[] newArray = new ManufacturerSouvenirPair[pairs.length + 1];
        System.arraycopy(pairs, 0, newArray, 0, pairs.length);
        pairs = newArray;
    }

    public void addPair(ManufacturerSouvenirPair pair) {
        ensureCapacity(size + 1);
        pairs[size++] = pair;
    }

    public void removePair(String pair) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (pairs[i].getName().equals(pair)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            for (int i = index; i < size - 1; i++) pairs[i] = pairs[i + 1];
            size--;
            pairs[size] = null;
        }
    }



    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public ManufacturerSouvenirPair[] getPairs() {
        return pairs;
    }

    public void setPairsList(ManufacturerSouvenirPair[] pars){
        pairs = pars;
        size = pairs.length;
    }

    public void showSouvenirsByManufacturer(String name, SouvenirList souvenirs) {
        for (int i = 0; i < pairs.length; i++) {
        if (name.equals(pairs[i].getName()) ) {
            for (int j = 0; j < souvenirs.getSize(); j++) {
                if (pairs[i].getSouvenirName().equals(souvenirs.getSouvenirs()[j].getSouvenirName()))
                    System.out.println(souvenirs.getSouvenirs()[j]);
                }
            }
        }
    }

    public void showSouvenirsByCountry(String country, ManufacturerList manufacturers, SouvenirList souvenirs) {
        for (int i = 0; i < manufacturers.getSize(); i++) {
            if (country.equals(manufacturers.getManufacturers()[i].getCountry())) {
                System.out.println(manufacturers.getManufacturers()[i]);
                showSouvenirsByManufacturer(manufacturers.getManufacturers()[i].getName(), souvenirs);
            }
        }
    }


    public void showManufacturersByPrice(int price, ManufacturerList manufacturers, SouvenirList souvenirs) {
        for (int i = 0; i < souvenirs.getSize(); i++) {
            if (price > (souvenirs.getSouvenirs()[i].getPrice())) {
                for (int j = 0; j < size; j++)
                    if (souvenirs.getSouvenirs()[i].getSouvenirName().equals(pairs[j].getSouvenirName()))
                        for (int n = 0; n < manufacturers.getSize(); n++)
                            if (pairs[j].getName().equals(manufacturers.getManufacturers()[n].getName()))
                System.out.println(manufacturers.getManufacturers()[n]);
            }
        }
    }

    public void showAllSouvsAndMans(ManufacturerList manufacturers, SouvenirList souvenirs) {
        for (int i = 0; i < manufacturers.getSize(); i++) {
            System.out.println(manufacturers.getManufacturers()[i].getName());
            showSouvenirsByManufacturer(manufacturers.getManufacturers()[i].getName(),souvenirs);
        }
    }

    public void showManufacturersBySouvenirYear(String name, LocalDate date, ManufacturerList manufacturers, SouvenirList souvenirs) {
        int year = date.getYear();
        for (int i = 0; i < souvenirs.getSize(); i++) {
            if (year == (souvenirs.getSouvenirs()[i].getReleaseDate().getYear())
            && name.equals(souvenirs.getSouvenirs()[i].getSouvenirName())) {
                for (int j = 0; j < size; j++) {
                    if (name.equals(pairs[j].getSouvenirName())) {
                        for (int n = 0; n < manufacturers.getSize(); n++)
                            if (pairs[j].getName().equals(manufacturers.getManufacturers()[n].getName()))
                                System.out.println(manufacturers.getManufacturers()[n]);
                    }
                }
            }
        }
    }

    public void showSouvenirsByYear(SouvenirList souvenirs) {
        Souvenir[] sovs = souvenirs.getSouvenirs();
        Arrays.sort(sovs, Comparator.comparingInt(Souvenir::getReleaseYear));
        for (Souvenir sov : sovs) {
            {
                System.out.println(sov);
            }
        }
    }

    public void delSouvenirsByManufacturers(String manufacturer, ManufacturerList manufacturers, SouvenirList souvenirs) {
        for (int i = 0; i < manufacturers.getSize(); i++) {
            if(manufacturers.getManufacturers()[i].getName().equals(manufacturer)) {
                    manufacturers.removeManufacturer(manufacturer);
                    for (int j = 0; j < souvenirs.getSize(); j++) {
                    if(manufacturer.equals(pairs[j].getName())) {
                        for (int n = 0; n < souvenirs.getSize(); n++) {
                            if (souvenirs.getSouvenirs()[n].getSouvenirName().equals(pairs[j].getSouvenirName())) {
                                souvenirs.removeSouvenir(souvenirs.getSouvenirs()[i].getSouvenirName());
                            }
                        }
                    }
                }
                removePair(manufacturer);
            }
        }
    }

}
