import controller.ClassManager;
import controller.StudentManager;
import menu.ClassMenu;
import menu.StudentMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        ClassManager classManager = new ClassManager();
        ClassMenu classMenu = new ClassMenu(studentManager,classManager);
        StudentMenu studentMenu = new StudentMenu(studentManager,classManager);
        int choice;
        do {
            System.out.println("1. Quan li sinh vien.");
            System.out.println("2. Quan li lop hoc.");
            System.out.println("Enter a choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    studentMenu.menu();
                    break;
                }
                case 2: {
                    classMenu.menu();
                }
            }
        }while(choice!=0);
    }
}
