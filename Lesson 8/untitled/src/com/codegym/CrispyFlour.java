package com.codegym;

import java.time.LocalDate;

public class CrispyFlour extends Material{
    private int quantity;
    private int expiry;

    public CrispyFlour() {
    }
    public CrispyFlour(int quantity,int expiry) {
        this.quantity = quantity;
        this.expiry = expiry;
    }
    public CrispyFlour(String id, String name, int cost, int quantity,int expiry) {
        super(id, name, cost);
        this.quantity = quantity;
        this.expiry = expiry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +super.toString()+
                ", quantity=" + quantity +
                ", expiry=" + expiry +
                '}';
    }

    @Override
    public double getAmount() {
        return getCost()*quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(expiry);
    }
}
