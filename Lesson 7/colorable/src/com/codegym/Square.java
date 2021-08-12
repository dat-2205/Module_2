package com.codegym;

public class Square extends Shape implements Colorable{
    private double side;

    public Square(double side) {
        this.side = side;
    }
    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return this.side*this.side;
    }
    public double getPerimeter() {
        return this.side*4;
    }
    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color= " + getColor()+
                ", area= " + getArea()+
                ", perimeter= " + getPerimeter()+
                '}';
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
