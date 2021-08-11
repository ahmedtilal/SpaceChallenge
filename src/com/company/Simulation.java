package com.company;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(File file) {
        Scanner scanner = null;
        ArrayList<Item> items = new ArrayList<>();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            String line = scanner.nextLine();
            var lineArr = line.split("=");
            String name = lineArr[0];
            int weight = Integer.parseInt(lineArr[1]);
            Item item = new Item(name, weight);
            items.add(item);
        }

        return items;
    }

    public ArrayList<Rocket> loadU1(@NotNull ArrayList<Item> items) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();

        U1 rocket = new U1();
        for (Item item : items) {
            if (rocket.weight + item.weight() > rocket.limit) {
                rocketsList.add(rocket);
                rocket = new U1();
            }
            rocket.carry(item);
        }

        return rocketsList;
    }

    public ArrayList<Rocket> loadU2(@NotNull ArrayList<Item> items) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();

        U2 rocket = new U2();
        for (Item item : items) {
            if (!rocket.canCarry(item)) {
                rocketsList.add(rocket);
                rocket = new U2();
            }
            rocket.carry(item);
        }
        return rocketsList;
    }

    public int runSimulation(@NotNull ArrayList<Rocket> rockets) {
        int totalCost = 0;
        for (Rocket rocket : rockets) {
            boolean success = rocket.launch() && rocket.land();
            if (!success) {
                totalCost += rocket.cost;
                success = rocket.launch() && rocket.land();
            }
           totalCost += rocket.cost;
        }
        return totalCost;
    }
}
