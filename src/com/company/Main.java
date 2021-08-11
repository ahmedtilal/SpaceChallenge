package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        File phase1 = new File("phase-1.txt");
        File phase2 = new File("phase-2.txt");
        ArrayList<Item> phase1Items = simulation.loadItems(phase1);
        ArrayList<Item> phase2Items = simulation.loadItems(phase2);

        ArrayList<Rocket> phase1U1 = simulation.loadU1(phase1Items);
        ArrayList<Rocket> phase2U1 = simulation.loadU1(phase2Items);

        int totalU1Cost = simulation.runSimulation(phase1U1) + simulation.runSimulation(phase2U1);

        System.out.println("Total cost for using U1 is $" + totalU1Cost + " Million Dollars.");

        ArrayList<Rocket> phase1U2 = simulation.loadU2(phase1Items);
        ArrayList<Rocket> phase2U2 = simulation.loadU2(phase2Items);

        int totalU2Cost = simulation.runSimulation(phase1U2) + simulation.runSimulation(phase2U2);

        System.out.println("Total cost for using U2 is $" + totalU2Cost + " Million Dollars.");
    }
}
