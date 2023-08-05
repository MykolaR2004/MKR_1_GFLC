package org.example.data;


public class SouvenirList {
    private int size = 0;
    private Souvenir[] souvenirs = new Souvenir[1];

    public void setSouvenirsList(Souvenir[] souvs){
        souvenirs = souvs;
        size = souvenirs.length;
    }
    private void ensureCapacity(int newCapacity) {
        if (newCapacity <= souvenirs.length) return;
        Souvenir[] newArray = new Souvenir[souvenirs.length + 1];
        System.arraycopy(souvenirs, 0, newArray, 0, souvenirs.length);
        souvenirs = newArray;
    }
    public void addSouvenir(Souvenir souvenir) {
        ensureCapacity(size + 1);
        souvenirs[size++] = souvenir;
    }

    public void removeSouvenir(String souvenir) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (souvenirs[i].getSouvenirName().equals(souvenir)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            for (int i = index; i < size - 1; i++) {
                souvenirs[i] = souvenirs[i + 1];
            }
            size--;
            souvenirs[size] = null;
        }
    }



    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public Souvenir[] getSouvenirs() {
        return souvenirs;
    }


}
