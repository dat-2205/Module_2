package com.codegym;

public class Main {

    public static void main(String[] args) {
	    Circle c = new Circle();
        System.out.println(c);
	    Circle b = new Circle("yelllow",10);
        System.out.println(b);

        Cylinder a = new Cylinder();
        Cylinder x = new Cylinder(5,3,"red");
        System.out.println(a);
        System.out.println(x);
    }
}
