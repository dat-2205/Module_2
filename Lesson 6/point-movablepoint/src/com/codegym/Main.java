package com.codegym;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(4,8);
        System.out.println(point1);
        MovablePoint mp1 = new MovablePoint(2,6,1.5f,1);
        System.out.println(mp1);
        mp1.move();
        System.out.println(mp1);
    }
}
