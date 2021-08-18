package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = getSize();
        BienLai[] bienLais ;
        bienLais = initArray(size);
        int choice;
        do{
            System.out.println("1. Add new guest ");
            System.out.println("2. Delete a guest ");
            System.out.println("3. Show a guest ");
            System.out.println("4. Show all guest ");
            System.out.println("5. Get a bill ");
            System.out.println("0. Exit ");
            choice = getScanner().nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter a index: ");
                    int index = getScanner().nextInt();
                    bienLais = addNewGuest(bienLais,index);
                    break;
                case 2:
                    System.out.println("Enter a index: ");
                    int deleteIndex = getScanner().nextInt();
                    bienLais = deleteGuest(bienLais,deleteIndex);
                    break;
                case 3:
                    String id = getID();
                    int findIndex = findGuest(bienLais,id);
                    if(findIndex>=0) {
                        System.out.println(bienLais[findIndex]);
                    }else {
                        System.out.println("Khong co id nay!");
                    }
                    break;
                case 4:
                    displayArray(bienLais);
                    break;
                case 5:
                    String idBill = getID();
                    int billIndex = findGuest(bienLais,idBill);
                    if(billIndex>=0) {
                        System.out.println(totalBill(bienLais,billIndex)+ " $ ");
                    }else {
                        System.out.println("Khong co id nay!");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while(choice!=0);
    }
    public static Scanner getScanner() {
       Scanner sc = new Scanner(System.in);
       return sc;
    }
    public static int getSize() {
        System.out.println("Enter a size: ");
        int size = getScanner().nextInt();
        return size;
    }
    public static BienLai[] initArray(int size) {
        BienLai[] bienLais = new BienLai[size];
        for(int i=0;i<size;i++) {
            bienLais[i] = getBienLaiInfor(i);
        }
        return bienLais;
    }
    public static KhachHang getKhachHangInfor(int i) {
        System.out.println("Enter guest " + (i+1)+ " name: ");
        String name = getScanner().nextLine();
        System.out.println("Enter guest " + (i+1)+ " address: ");
        String address = getScanner().nextLine();
        System.out.println("Enter guest " + (i+1)+ " id: ");
        String id = getScanner().nextLine();
        KhachHang khachHang = new KhachHang(name,address,id);
        return khachHang;
    }
    public static BienLai getBienLaiInfor(int i) {
        KhachHang khachHang = getKhachHangInfor(i);
        System.out.println("Enter " + (i+1)+ " old electric number: ");
        double oldElectricNumber = getScanner().nextDouble();
        System.out.println("Enter " + (i+1)+ "new electric number: ");
        double newElectricNumber = getScanner().nextDouble();
        BienLai bienLais = new BienLai(khachHang,oldElectricNumber,newElectricNumber);
        return bienLais;
    }
    public static void displayArray(BienLai[] bienLais) {
        for(BienLai i : bienLais) {
            System.out.println(i);
        }
    }
    public static int findGuest(BienLai[] bienLais,String id) {
        int index = -1;
        for(int i=0;i<bienLais.length;i++) {
            if(bienLais[i].getKhachHang().getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
    public static double totalBill(BienLai[] bienLais,int index) {
        return bienLais[index].getTotalBill();
    }
    public static BienLai[] addNewGuest(BienLai[] bienLais,int index) {
        BienLai[] newBienLais = new BienLai[bienLais.length+1];
        for(int i=0;i<newBienLais.length;i++) {
            if(i<index) {
                newBienLais[i] = bienLais[i];
            }else if(i==index) {
                newBienLais[i] = getBienLaiInfor(i);
            }else if(i>index){
                newBienLais[i] = bienLais[i-1];
            }
        }
        return newBienLais;
    }
    public static BienLai[] deleteGuest(BienLai[] bienLais,int index) {
        BienLai[] newBienLais = new BienLai[bienLais.length-1];
        for(int i=0;i<bienLais.length;i++) {
            if(i<index) {
                newBienLais[i] = bienLais[i];
            }else if(i==index){
                continue;
            }else if(i>index){
                newBienLais[i-1] = bienLais[i];
            }
        }
        return newBienLais;
    }
    public static String getID() {
        System.out.println("Enter a id: ");
        String id = getScanner().nextLine();
        return id;
    }
}
