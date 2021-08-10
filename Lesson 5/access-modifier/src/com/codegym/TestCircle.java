package com.codegym;

public class TestCircle {

    public static void main(String[] args) {
        Circle a = new Circle();
        Circle b = new Circle(3);
        System.out.println(b.getRadius());
        System.out.println(b.getArea());
        System.out.println(a.getRadius());
        System.out.println(a.getArea());
    }
}
