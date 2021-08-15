package com.codegym;

import java.time.LocalDate;

public class Meat extends Material{
    private double weight;

    public Meat() {
    }
    public Meat(double weight) {
        this.weight = weight;
    }
    public Meat(String id, String name, int cost, double weight) {
        super(id, name, cost);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat{" +super.toString()+
                ", weight=" + weight +
                '}';
    }

    @Override
    public double getAmount() {
        return getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }
}
