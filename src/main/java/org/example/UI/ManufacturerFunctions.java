package org.example.UI;

import org.example.data.MSPairList;
import org.example.data.ManufacturerList;
import org.example.data.SouvenirList;

import java.util.Scanner;

public interface ManufacturerFunctions {

    void createSouvenirsData(SouvenirList souvenirs);

    void createPairs(MSPairList pair);

    void showSouvenirsByCountry(MSPairList pairs, Scanner sc, ManufacturerList manufacturers, SouvenirList souvenirs);

    void showAll(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs);

    void createManufacturersData(ManufacturerList manufacturers);

    void showSouvenirsByManufacturer(MSPairList pairs, Scanner scanner, SouvenirList souvenirs);

    void showManufacturersByPrice(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs);


    void showManufacturersBySouvenirYear(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs);

    void showSouvenirsByYear(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs);

    void delSouvenirsByManufacturers(MSPairList pairs, ManufacturerList manufacturers, SouvenirList souvenirs, Scanner scanner);

    void addSouvenir(SouvenirList souvenirs, Scanner scanner);

    void addManufacturer(ManufacturerList manufacturers, Scanner scanner);

    void addPair(MSPairList pairs, Scanner scanner);
}
