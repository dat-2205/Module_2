package com.codegym;

public class Main {

    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Square(15);
        shape[1] = new Square(3);
        shape[2] = new Circle(2.5);

        for(Shape i: shape) {
            System.out.println(i);
            if(i instanceof Colorable) {
                Colorable colorable = (Colorable) i;
                colorable.howToColor();
            }
        }
    }
}
