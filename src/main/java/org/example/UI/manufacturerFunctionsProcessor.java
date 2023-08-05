package org.example.UI;

import org.example.data.*;

import java.time.LocalDate;
import java.util.Scanner;

public class manufacturerFunctionsProcessor implements ManufacturerFunctions{

    @Override
    public void createManufacturersData(ManufacturerList manufacturers){
        manufacturers.addManufacturer(new Manufacturer("Приватбанк","Україна"));
        manufacturers.addManufacturer(new Manufacturer("Монобанк","Україна"));
        manufacturers.addManufacturer(new Manufacturer("be quiet!","Німеччина"));
        manufacturers.addManufacturer(new Manufacturer("НУК","Україна"));
    }

    @Override
    public void createSouvenirsData(SouvenirList souvenirs){
        souvenirs.addSouvenir(new Souvenir("Фірмова чашка","-", LocalDate.of(2020,11,25),100));
        souvenirs.addSouvenir(new Souvenir("Фірмова футболка","-", LocalDate.of(2020,11,25),100));
        souvenirs.addSouvenir(new Souvenir("Фірмові наліпки","-", LocalDate.of(2022,11,25),200));
        souvenirs.addSouvenir(new Souvenir("Фірмова кепка","-", LocalDate.of(2021,11,25),100));
        souvenirs.addSouvenir(new Souvenir("Фірмові магніти","-", LocalDate.of(2019,11,25),50));
    }

    @Override
    public void createPairs(MSPairList pairs){
        pairs.addPair(new ManufacturerSouvenirPair("Монобанк","Фірмова чашка"));
        pairs.addPair(new ManufacturerSouvenirPair("Монобанк","Фірмова футболка"));
        pairs.addPair(new ManufacturerSouvenirPair("Монобанк","Фірмові наліпки"));
        pairs.addPair(new ManufacturerSouvenirPair("be quiet!","Фірмові наліпки"));
        pairs.addPair(new ManufacturerSouvenirPair("be quiet!","Фірмова футболка"));
        pairs.addPair(new ManufacturerSouvenirPair("Приватбанк","Фірмова футболка"));
        pairs.addPair(new ManufacturerSouvenirPair("Приватбанк","Фірмові магніти"));
        pairs.addPair(new ManufacturerSouvenirPair("НУК","Фірмова кепка"));
        pairs.addPair(new ManufacturerSouvenirPair("НУК","Фірмові магніти"));
    }

    @Override
    public void showSouvenirsByManufacturer(MSPairList pairs, Scanner sc, SouvenirList souvenirs) {
        String nothing = sc.nextLine();
        System.out.print("Назва сувеніра >> ");
        String name = sc.nextLine();
        pairs.showSouvenirsByManufacturer(name, souvenirs);
    }

    @Override
    public void showManufacturersByPrice(MSPairList pairs, Scanner sc, ManufacturerList manufacturers, SouvenirList souvenirs) {
        System.out.print("Ціна сувеніра >> ");
        int price = sc.nextInt();
        pairs.showManufacturersByPrice(price, manufacturers, souvenirs);
    }

    @Override
    public void showManufacturersBySouvenirYear(MSPairList pairs, Scanner sc, ManufacturerList manufacturers, SouvenirList souvenirs) {
        System.out.print("День >> ");
        int d = sc.nextInt();
        System.out.print("Місяць >> ");
        int m = sc.nextInt();
        System.out.print("Рік >> ");
        int y = sc.nextInt();
        String nothing = sc.nextLine();
        System.out.print("Назва сувеніру >> ");
        String name = sc.nextLine();
        LocalDate date = LocalDate.of(y, m, d);
        pairs.showManufacturersBySouvenirYear(name, date, manufacturers, souvenirs);
    }

    @Override
    public void showSouvenirsByYear(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs) {
        pairs.showSouvenirsByYear(souvenirs);
    }



    @Override
    public void showSouvenirsByCountry(MSPairList pairs, Scanner sc, ManufacturerList manufacturers, SouvenirList souvenirs) {
        System.out.print("Назва країни >> ");
        String country = sc.next();
        pairs.showSouvenirsByCountry(country, manufacturers, souvenirs);
    }

    @Override
    public void showAll(MSPairList pairs, Scanner scanner, ManufacturerList manufacturers, SouvenirList souvenirs) {
        pairs.showAllSouvsAndMans(manufacturers, souvenirs);
    }

    @Override
    public void delSouvenirsByManufacturers(MSPairList pairs, ManufacturerList manufacturers, SouvenirList souvenirs, Scanner sc) {
        String nothing = sc.nextLine();
        System.out.print("Виробник >> ");
        String manufacturer = sc.nextLine();
        pairs.delSouvenirsByManufacturers(manufacturer, manufacturers, souvenirs);
    }

    @Override
    public void addSouvenir(SouvenirList souvenirs, Scanner scanner) {
        String nothing = scanner.nextLine();
        System.out.print("Назва сувеніра >> ");
        String souvenirName = scanner.nextLine();
        System.out.print("Реквізити виробника >> ");
        String requisites = scanner.nextLine();
        System.out.println("Рік, місяць, день випуску >> ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println("Ціна (ЦІЛЕ ЧИСЛО!) >> ");
        int price = scanner.nextInt();
        souvenirs.addSouvenir(new Souvenir(souvenirName,requisites,LocalDate.of(year,month,day),price));
    }

    @Override
    public void addManufacturer(ManufacturerList manufacturers, Scanner scanner) {
        String nothing = scanner.nextLine();
        System.out.print("Назва виробника >> ");
        String name = scanner.nextLine();
        System.out.print("Країна >> ");
        String country = scanner.nextLine();
        manufacturers.addManufacturer(new Manufacturer(name,country));
    }

    @Override
    public void addPair(MSPairList pairs, Scanner scanner) {
        String nothing = scanner.nextLine();
        System.out.print("Назва виробника >> ");
        String manufactureName = scanner.nextLine();
        System.out.print("Назва сувеніру >> ");
        String souvenirName = scanner.nextLine();
        pairs.addPair(new ManufacturerSouvenirPair(manufactureName,souvenirName));
    }

}
