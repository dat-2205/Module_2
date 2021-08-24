package menu;

import controller.ClassManager;
import controller.StudentManager;
import model.Classes;

import java.util.Scanner;

public class ClassMenu {
    private StudentManager studentManager = new StudentManager();
    private ClassManager classManager = new ClassManager();
    private Scanner sc = new Scanner(System.in);

    public ClassMenu(StudentManager studentManager, ClassManager classManager) {
        this.studentManager = studentManager;
        this.classManager = classManager;
    }

    public void displayMenu() {
        System.out.println("1. Them 1 lop.");
        System.out.println("2. Sua 1 lop.");
        System.out.println("3. Xoa 1 lop.");
        System.out.println("4. In ra danh sach sinh vien trong 1 lop.");
        System.out.println("5. Xem so thanh vien trong 1 lop.");
        System.out.println("6. In ra tat ca cac lop.");
    }

    public void menu() {
        int choice;
        do {
            displayMenu();
            System.out.println("Enter a choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        } while (choice != 0) ;
    }

    private void choiceHandle(int choice) {
        switch (choice) {
            case 1: {
                boolean isInvalid = false;
                do {
                    System.out.println("Enter new class id: ");
                    String id = sc.nextLine();
                    if (classManager.getIndex(id) < 0) {
                        System.out.println("Enter new class name: ");
                        String name = sc.nextLine();
                        Classes classes = new Classes(id, name);
                        classManager.addNew(classes);
                        isInvalid = true;
                    } else {
                        System.out.println("Id is already exist!");
                    }
                } while (isInvalid==false);
                break;
            }
            case 2: {
                System.out.println("Enter class id: ");
                String id = sc.nextLine();
                if (classManager.getIndex(id) >= 0) {
                    System.out.println("Enter class new name: ");
                    String newName = sc.nextLine();
                    Classes classes = new Classes(id, newName);
                    for(int i=0;i<studentManager.getStudentList().size();i++) {
                        if(studentManager.getStudentList().get(i).getClassInfor().getId().equals(id)) {
                            studentManager.getStudentList().get(i).setClassInfor(classes);
                        }
                    }
                    classManager.update(id, classes);

                } else {
                    System.out.println("Class is not found!");
                }
                break;
            }
            case 3:{
                System.out.println("Enter class id: ");
                String id = sc.nextLine();
                if (classManager.getIndex(id) >= 0) {
                    classManager.remove(id);
                } else {
                    System.out.println("Class is not found!");
                }
                break;
            }
            case 4:{
                System.out.println("Enter class name want to show: ");
                String className = sc.nextLine();
                if(classManager.getIndexByName(className)>=0) {
                    classManager.showStudentInClass(studentManager.getStudentList(),className);
                }else {
                    System.out.println("Class does not exist!");
                }
                break;
            }
            case 5:{
                System.out.println("Enter class name want to show: ");
                String className = sc.nextLine();
                if(classManager.getIndexByName(className)>=0) {
                    int studentNumber = classManager.getStudentNumberInClass(studentManager.getStudentList(),className);
                    System.out.println("Number of student in class: " + studentNumber);
                }else {
                    System.out.println("Class does not exist!");
                }
                break;
            }
            case 6: {
                classManager.showAll();
                break;
            }
            case 0: {
                System.out.println("Back to menu before!");
                break;
            }
            default:
                System.out.println("Choice is illegal!!");
        }
    }
}