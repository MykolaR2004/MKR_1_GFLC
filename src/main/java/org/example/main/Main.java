package org.example.main;


import org.example.IO.IO;
import org.example.IO.IOProcessor;
import org.example.UI.ManufacturerFunctions;
import org.example.UI.manufacturerFunctionsProcessor;
import org.example.data.MSPairList;
import org.example.data.ManufacturerList;
import org.example.data.SouvenirList;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        new Main().run();
        }

    private void menu() {
        println("[1] Завершити програму");
        println("-= Основні функції =-");
        println("[2] Заповнити усі дані");
        println("[3] Вивести сувеніри за вказаним виробником");
        println("[4] Вивести сувеніри за вказаною країною");
        println("[5] Вивести інформацію про виробників, чиї ціни на сувеніри менше заданої");
        println("[6] Вивести інформацію по всіх виробниках та, для кожного виробника вивести інформацію\n" +
                "про всі сувеніри, які він виробляє.");
        println("[7] Вивести інформацію про виробників заданого сувеніру, виробленого у заданому року.");
        println("[8] Для кожного року вивести список сувенірів, зроблених цього року.");
        println("[9] Видалити заданого виробника та його сувеніри.");
        println("-= Додавання даних =-");
        println("[11] Додати сувенір");
        println("[12] Додати виробника");
        println("[13] Додати пару");
        println("-= Файлове введеня-виведення =-");
        println("[14] Запис у файл");
        println("[15] Читання з файлу");

        System.out.print(">> ");
    }
    private void run() {
        ManufacturerList manufacturers = new ManufacturerList();
        SouvenirList souvenirs = new SouvenirList();
        MSPairList pairs = new MSPairList();
        IO io = new IOProcessor();
        ManufacturerFunctions funs = new manufacturerFunctionsProcessor();
        loop:
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            switch (m) {

                case 2 -> {
                    funs.createPairs(pairs);
                    funs.createManufacturersData(manufacturers);
                    funs.createSouvenirsData(souvenirs);
                }
                case 3 -> funs.showSouvenirsByManufacturer(pairs, scanner, souvenirs);
                case 4 -> funs.showSouvenirsByCountry(pairs, scanner, manufacturers, souvenirs);
                case 5 -> funs.showManufacturersByPrice(pairs, scanner, manufacturers, souvenirs);
                case 6 -> funs.showAll(pairs, scanner, manufacturers, souvenirs);
                case 7 -> funs.showManufacturersBySouvenirYear(pairs, scanner, manufacturers, souvenirs);
                case 8 -> funs.showSouvenirsByYear(pairs, scanner, manufacturers, souvenirs);
                case 9 -> funs.delSouvenirsByManufacturers(pairs,manufacturers,souvenirs,scanner);

                case 11 -> funs.addSouvenir(souvenirs,scanner);
                case 12 -> funs.addManufacturer(manufacturers,scanner);
                case 13 -> funs.addPair(pairs,scanner);

                case 14 -> {
                    io.writeManufacturers(manufacturers);
                    io.writeSouvenirs(souvenirs);
                    io.writePairs(pairs);
                }
                case 15 -> {
                    manufacturers.setManufacturersList(io.readManufacturers(manufacturers));
                    souvenirs.setSouvenirsList(io.readSouvenirs(souvenirs));
                    pairs.setPairsList(io.readPairs(pairs));
                }
                case 1 -> {
                    break loop;
                }
            }
        }

    }

    private void println(String value) {
        System.out.println(value);
    }
}
