package com.company;

public class U1 extends Rocket {


    public U1() {
        this.weight = 10000;
        this.limit = 18000;
        this.cost = 100;    // $100 Million
    }

    @Override
    public boolean launch() {
        double explosionProbability = Math.random() * (this.weight / this.limit);
        return !(explosionProbability <= 0.05);
    }

    @Override
    public boolean land() {
        double explosionProbability = Math.random() * (this.weight / this.limit);
        return !(explosionProbability <= 0.01);
    }

}
