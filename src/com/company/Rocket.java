package com.company;

import org.jetbrains.annotations.NotNull;

public class Rocket implements Spaceship {
    int weight = 0;
    int limit;
    int cost;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(@NotNull Item item) {
        return (weight + item.weight()) <= limit;
    }

    @Override
    public void carry(@NotNull Item item) {
        this.weight += item.weight();
    }
}
