package com.codegym;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder(){}
    public Cylinder(double height) {
        this.height = height;
    }
    public Cylinder(double height,double radius,String color) {
        super(color,radius);
        this.height= height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getArea() {
        return 2*Math.PI*Math.pow(getRadius(),2) + 2*Math.PI*getRadius()*height;
    }
    public double getVolume() {
        return Math.PI*Math.pow(getRadius(),2)*height;
    }
    @Override
    public String toString() {
        return " A Cylinder with " +
                " height= " + getHeight() +
                " color= " + getColor() +
                " radius= " + getRadius() +
                " area= " + getArea() +
                " volume= " + getVolume();

    }
}
