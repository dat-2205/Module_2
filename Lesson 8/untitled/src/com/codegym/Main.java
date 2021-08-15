package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = getNumber(sc,"Enter a size: ");
        MaterialManagement materialManagement = new MaterialManagement(size) ;
        materialManagement.inputMaterial(size,sc);
        int choice;
        do{
            System.out.println("1. Them");
            System.out.println("2. Sua");
            System.out.println("3. Xoa");
            System.out.println("4. Tinh tien 1 san pham theo id");
            System.out.println("5. In ra 1 san pham");
            System.out.println("6. In ra toan bo san pham");
            System.out.println("0. Thoat");
            choice  = sc.nextInt();
            switch (choice) {
                case 1:
                    int addIndex = getNumber(sc,"Enter a index: ");
                    materialManagement.addMaterial(addIndex,sc);
                    System.out.println("Them thanh cong");
                    break;
                case 2:
                    int refactorIndex =getNumber(sc,"Enter a index: ");;
                    materialManagement.refactorMaterial(refactorIndex,sc);
                    System.out.println("Sua thanh cong");
                    break;
                case 3:
                    int deleteIndex = getNumber(sc,"Enter a index: ");;
                    materialManagement.deleteMaterial(deleteIndex,sc);
                    System.out.println("Xoa thanh cong");
                    break;
                case 4:
                    sc.nextLine();
                    String id = getString(sc,"Nhap id");
                    double relMoney = materialManagement.getRealMoney(sc,id);
                    System.out.printf("So tien phai tra la %.2f $ \n" , relMoney);
                    break;
                case 5:
                    sc.nextLine();
                    String findId = getString(sc,"Nhap id");
                    int indexFound = materialManagement.findMaterial(findId);
                    if(indexFound>=0 && indexFound<size) {
                        materialManagement.showAMaterial(findId);
                    }
                    break;
                case 6:
                    materialManagement.showMaterial();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while(choice!=0);
    }
    public static int getNumber(Scanner sc,String displayString) {
        System.out.print(displayString);
        int number = sc.nextInt();
        return number;
    }
    public static String getString(Scanner sc,String displayString) {
        System.out.println(displayString);
        String string = sc.nextLine();
        return string;
    }

}
