package org.example.IO;

import org.example.data.*;

public interface IO {

    void writeSouvenirs(SouvenirList souvenirs);


    void writeManufacturers(ManufacturerList manufacturers);

    void writePairs(MSPairList pairs);


    Manufacturer[] readManufacturers(ManufacturerList manufacturers);

    Souvenir[] readSouvenirs(SouvenirList souvenirs);

    ManufacturerSouvenirPair[] readPairs(MSPairList pairs);
}
