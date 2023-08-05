package org.example.data;

import java.time.LocalDate;

public class ManufacturerList {
    private int size = 0;
    public Manufacturer[] manufacturers = new Manufacturer[1];
    public Manufacturer[] getManufacturers() {
        return manufacturers;
    }
    public void setManufacturersList(Manufacturer[] manufacturs) {
        manufacturers = manufacturs;
        size = manufacturers.length;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity <= manufacturers.length) return;
        Manufacturer[] newArray = new Manufacturer[manufacturers.length + 1];
        System.arraycopy(manufacturers, 0, newArray, 0, manufacturers.length);
        manufacturers = newArray;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }



    public void showProductsByCountry(String country) {
        for (int i = 0; i < size; i++) {
            if (manufacturers[i].getCountry().equals(country)) {
                System.out.println(manufacturers[i]);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(manufacturers[i]).append("\n");
        }
        return sb.toString();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        ensureCapacity(size + 1);
        manufacturers[size++] = manufacturer;
    }

    public void removeManufacturer(String manufacturer) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (manufacturers[i].getName().equals(manufacturer)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            for (int i = index; i < size - 1; i++) {
                manufacturers[i] = manufacturers[i + 1];
            }
            size--;
            manufacturers[size] = null;
        }
    }
}

