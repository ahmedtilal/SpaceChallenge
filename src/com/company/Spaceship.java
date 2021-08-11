package com.company;

public interface Spaceship {
    boolean launch();
    boolean land();
    boolean canCarry();
    void carry(Item item);
}
