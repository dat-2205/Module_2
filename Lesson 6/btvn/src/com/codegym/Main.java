package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KhachSan[] quanLi;
        int size = getSize();
        quanLi = initArray(size);
        showArray(quanLi);
        int choice;
        do {
            System.out.println("1. Them khach hang.");
            System.out.println("2. Xoa khach hang.");
            System.out.println("3. Thay doi thong tin khach hang.");
            System.out.println("4. Xem thong tin khach hang.");
            System.out.println("5. Xem toan bo khach san.");
            System.out.println("6. Thanh toan cho khach hang.");
            System.out.println("0. Thoat.");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    int addIndex = getIndex();
                    if(addIndex<0||addIndex>quanLi.length){
                        System.out.println("Vi tri khong hop le!");
                    }else {
                        quanLi = addGuest(quanLi,addIndex);
                    }
                    break;
                case 2:
                    int deleteIndex = getIndex();
                    if(deleteIndex<0||deleteIndex>quanLi.length-1){
                        System.out.println("Khong ton tai index nay!");
                    }else {
                        quanLi = deleteGuest(quanLi,deleteIndex);
                    }
                    break;
                case 3:
                    int fixIndex = getIndex();
                    do{
                        if(fixIndex<0 || fixIndex> quanLi.length-1){
                            System.out.println("Index khong hop le");
                            fixIndex = getIndex();
                        }
                    }while(fixIndex<0 || fixIndex> quanLi.length-1);
                    fixGuestInfor(quanLi,fixIndex);
                    break;
                case 4:
                    System.out.print("Nhap so cmt khach hang muon xem: ");
                    int cmtShow = sc.nextInt();
                    for(KhachSan i: quanLi) {
                        if(i.getCmt()==cmtShow){
                            System.out.println(i);
                        }
                    }
                    break;
                case 5:
                    showArray(quanLi);
                    break;
                case 6:
                    System.out.print("Nhap so cmt khach hang muon thanh toan: ");
                    int cmtPayment = sc.nextInt();
                    for(KhachSan i: quanLi) {
                        if(i.getCmt()==cmtPayment){
                            System.out.println(i);
                            System.out.print(i.Payment()+"$");
                        }
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le!!!");
            }
        }while (choice!=0);

        System.out.println(quanLi[0].Payment() + "$");
    }
    public static int getIndex() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        return index;
    }
    public static int getSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size: ");
        int size = sc.nextInt();
        return size;
    }
    public static KhachSan[] initArray(int size) {
        Scanner sc = new Scanner(System.in);
        KhachSan[] arr = new KhachSan[size];
        for(int i=0;i<size;i++){
            arr[i] = new KhachSan();
            System.out.println("Enter " + (i+1) + " guest.");

            System.out.print("Enter "+ (i+1) + " guest name ");
            String name = sc.next();
            arr[i].setName(name);

            System.out.print("Enter "+ (i+1) + " guest birthday ");
            String birth = sc.next();
            arr[i].setBirth(birth);

            System.out.print ("Enter "+ (i+1) + " guest cmt number ");
            int cmt = sc.nextInt();
            arr[i].setCmt(cmt);

            System.out.print("Enter " + (i+1) + " guest rom number ");
            int roomNumber = sc.nextInt();
            arr[i].setRoomNumber(roomNumber);

            System.out.print("Enter " + (i+1) + " guest rom class ");
            int roomClass = sc.nextInt();
            arr[i].setRoomClass(roomClass);

            System.out.print("Enter " + (i+1) + " guest rom day  ");
            int day = sc.nextInt();
            arr[i].setDay(day);
        }
        return arr;
    }
    public static void showArray(KhachSan[] array) {
        for(KhachSan i:array) {
            System.out.println(i.toString());
        }
    }
    public static KhachSan getNewInformation() {
        Scanner sc = new Scanner(System.in);
        KhachSan newGuest = new KhachSan();
        System.out.print("Enter guest name ");
        String name = sc.next();
        newGuest.setName(name);

        System.out.print("Enter guest birthday ");
        String birth = sc.next();
        newGuest.setBirth(birth);

        System.out.print ("Enter guest cmt number ");
        int cmt = sc.nextInt();
        newGuest.setCmt(cmt);

        System.out.print("Enter guest rom number ");
        int roomNumber = sc.nextInt();
        newGuest.setRoomNumber(roomNumber);

        System.out.print("Enter guest rom class ");
        int roomClass = sc.nextInt();
        newGuest.setRoomClass(roomClass);

        System.out.print("Enter guest rom day  ");
        int day = sc.nextInt();
        newGuest.setDay(day);

        return newGuest;
    }
    public static KhachSan[] addGuest(KhachSan[] arr, int index) {
        KhachSan newGuest = getNewInformation();
        KhachSan[] newArr = new KhachSan[arr.length + 1];
        for(int i=0;i<newArr.length;i++) {
            if(i<index){
                newArr[i] = arr[i];
            }else if(i==index) {
                newArr[i] = newGuest;
            }else {
                newArr[i] = arr[i-1];
            }
        }
        return newArr;
    }
    public static KhachSan[] deleteGuest(KhachSan[] arr, int index) {
        KhachSan[] newArr = new KhachSan[arr.length - 1];
        for(int i=0;i<arr.length;i++) {
            if(i<index){
                newArr[i] = arr[i];
            }else if(i==index) {
                continue;
            }else {
                newArr[i-1] = arr[i];
            }
        }
        return newArr;
    }
    public static void fixGuestInfor (KhachSan[] arr, int index) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter guest name ");
        String name = sc.next();
        arr[index].setName(name);

        System.out.print("Enter guest birthday ");
        String birth = sc.next();
        arr[index].setBirth(birth);

        System.out.print ("Enter guest cmt number ");
        int cmt = sc.nextInt();
        arr[index].setCmt(cmt);

        System.out.println("Change Complete");
    }
}
