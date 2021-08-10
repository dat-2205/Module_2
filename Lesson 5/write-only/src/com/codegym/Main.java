package com.codegym;

public class Main {
    public static Student nam = new Student();
    public static Student dat = new Student();
    static {
        nam.setName("Nam");
        nam.setClasses("LoveU");
        dat.setName("Dat");
        dat.setClasses("LoveU3000");
    }

    public static void main(String[] args) {
        System.out.println(nam.toString());
        System.out.println(dat.toString());
    }
}
