package com.codegym;

public class Square extends Rectangle implements Resizeable {
    private double side =1.0;

    public Square() {}
    public Square(double side) {
        super(side,side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        setLength(side) ;
        setWidth(side);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getWidth()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        setSide(getLength()+getLength()*(percent/100));
    }
}
