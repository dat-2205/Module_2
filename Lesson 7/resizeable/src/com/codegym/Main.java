package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape[] shape;
        int size = getSize();
        shape = initArray(size);
        showArray(shape);
        System.out.println();
        setNewSize(shape);
        showArray(shape);
    }
    public static Scanner setScanner() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public static int getSize() {
        System.out.print("Enter a size: ");
        int size = setScanner().nextInt();
        return size;
    }
    public static Shape[] initArray(int size){
        Shape[] shapeArray = new Shape[size];
        for(int i=0;i<size;i++) {
            System.out.println("Enter shape you want: ");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            int choice = setScanner().nextInt();
            switch(choice) {
                case 1:
                    Circle circle = new Circle() ;
                    System.out.print("Enter circle radius: ");
                    double radius = setScanner().nextDouble();
                    circle.setRadius(radius);
                    System.out.print("Enter circle color: ");
                    String color = setScanner().next();
                    circle.setColor(color);
                    shapeArray[i] = circle;
                    break;
                case 2:
                    Rectangle rectangle = new Rectangle() ;
                    System.out.print("Enter rectangle width: ");
                    double width = setScanner().nextDouble();
                    rectangle.setWidth(width);
                    System.out.print("Enter rectangle length: ");
                    double length = setScanner().nextDouble();
                    rectangle.setLength(length);
                    System.out.print("Enter rectangle color: ");
                    String colorRectangle = setScanner().next();
                    rectangle.setColor(colorRectangle);
                    shapeArray[i] = rectangle;
                    break;
                case 3:
                    Square square = new Square() ;
                    System.out.print("Enter square side : ");
                    double side = setScanner().nextDouble();
                    square.setSide(side);
                    System.out.print("Enter square color: ");
                    String colorSquare = setScanner().next();
                    square.setColor(colorSquare);
                    shapeArray[i] = square;
                    break;
                default:
                    System.out.println("Khong hop le");
            }
        }
        return shapeArray;
    }
    public static void showArray(Shape[] array) {
        for (Shape i : array ) {
            if(i instanceof Circle) {
                Circle circle = (Circle) i;
                System.out.println(circle);
            }else if(i instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) i;
                System.out.println(rectangle);
            }else if(i instanceof Square) {
                Square square = (Square) i;
                System.out.println(square);
            }
        }
    }
    public static void setNewSize(Shape[] array) {
        for (Shape i : array ) {
            if(i instanceof Circle) {
                Circle circle = (Circle) i;
                circle.resize(Math.random()*101);
            }else if(i instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) i;
                rectangle.resize(Math.random()*101);
            }else if(i instanceof Square) {
                Square square = (Square) i;
                square.resize(Math.random()*101);

            }
        }
    }
}
