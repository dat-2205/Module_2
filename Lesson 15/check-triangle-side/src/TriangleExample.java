import exception.IllegalTriangleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleExample {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int check = -1;
        do{
            try {
                inputTriangleSide();

            } catch (NumberFormatException e) {
                System.err.println("Ban phai nhap so!");
            }catch (IllegalTriangleException e) {
                System.err.println("Khong dung!");
            }
        }while(check<0);
    }
    public static void inputTriangleSide() throws IllegalTriangleException {
        System.out.println("Nhap canh a:");
        String a = sc.nextLine();
        double side1 = Double.parseDouble(a);
        if(side1<=0) {
            throw new IllegalTriangleException();
        }
        System.out.println("Nhap canh b:");
        String b = sc.nextLine();
        double side2 = Double.parseDouble(b);
        if(side2<=0) {
            throw new IllegalTriangleException();
        }
        System.out.println("Nhap canh c:");
        String c = sc.nextLine();
        double side3 = Double.parseDouble(c);
        if(side3<=0) {
            throw new IllegalTriangleException();
        }
        if(side1+side2<side3 || side1+side3<side2 || side2+side3<side1) {
            throw new IllegalTriangleException();
        }
    }
}
