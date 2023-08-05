package org.example.IO;

import org.example.data.*;

import java.io.*;

public class IOProcessor implements IO{

@Override
public void writeSouvenirs(SouvenirList souvenirs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("souvenirs.dat"))) {
            oos.writeObject(souvenirs.getSouvenirs());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeManufacturers(ManufacturerList manufacturers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("manufacturers.dat"))) {
            oos.writeObject(manufacturers.getManufacturers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writePairs(MSPairList pairs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pairs.dat"))) {
            oos.writeObject(pairs.getPairs());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Manufacturer[] readManufacturers(ManufacturerList manufacturers) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("manufacturers.dat"))) {
            Manufacturer[] manufacturs = (Manufacturer[]) ois.readObject();
            return manufacturs;
        } catch (IOException e) {
            System.out.println("manufacturers.dat Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("manufacturers.dat Not Found!");
        }
        return new Manufacturer[0];
    }

    @Override
    public Souvenir[] readSouvenirs(SouvenirList souvenirs) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("souvenirs.dat"))) {
            Souvenir[] souvs = (Souvenir[]) ois.readObject();
            return souvs;
        } catch (IOException e) {
            System.out.println("souvenirs.dat Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("souvenirs.dat Not Found!");
        }
        return new Souvenir[0];
    }

    @Override
    public ManufacturerSouvenirPair[] readPairs(MSPairList pairs) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pairs.dat"))) {
            ManufacturerSouvenirPair[] pars = (ManufacturerSouvenirPair[]) ois.readObject();
            return pars;
        } catch (IOException e) {
            System.out.println("pairs.dat Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("pairs.dat Not Found!");
        }
        return new ManufacturerSouvenirPair[0];
    }

}
