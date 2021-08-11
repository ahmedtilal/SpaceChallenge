package com.company;

public class U2 extends Rocket {


    public U2() {
        this.weight = 18000;
        this.limit = 29000;
        this.cost = 120; // $120 Million
    }

    @Override
    public boolean launch() {
        double explosionProbability = Math.random() * (this.weight / this.limit);
        return !(explosionProbability <= 0.04);
    }

    @Override
    public boolean land() {
        double explosionProbability = Math.random() * (this.weight / this.limit);
        return !(explosionProbability <= 0.08);
    }


}
