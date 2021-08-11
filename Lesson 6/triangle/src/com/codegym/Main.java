package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape x = new Triangle(3,4,5);
        System.out.println(x);
        Triangle y = new Triangle();
        System.out.println("Enter side1: ");
        double side1 = sc.nextDouble();
        y.setSide1(side1);
        System.out.println("Enter side2: ");
        double side2 = sc.nextDouble();
        y.setSide2(side2);
        System.out.println("Enter side3: ");
        double side3 = sc.nextDouble();
        y.setSide3(side3);
        System.out.println("Enter triangle color: ");
        String color = sc.next();
        y.setColor(color);
        System.out.println(y);
    }
}
