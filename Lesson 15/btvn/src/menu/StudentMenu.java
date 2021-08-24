package menu;

import controller.ClassManager;
import controller.StudentManager;
import model.Classes;
import model.Student;

import java.util.Scanner;

public class StudentMenu {
    private StudentManager studentManager = new StudentManager();
    private ClassManager classManager = new ClassManager();
    private Scanner sc = new Scanner(System.in);

    public StudentMenu(StudentManager studentManager, ClassManager classManager) {
        this.studentManager = studentManager;
        this.classManager = classManager;
    }

    public void displayMenu() {
        System.out.println("1. Them moi thong tin sinh vien.");
        System.out.println("2. Sua thong tin sinh vien.");
        System.out.println("3. Xoa thong tin sinh vien.");
        System.out.println("4. Sap xep sinh vien theo ten.");
        System.out.println("5. Tim kiem sinh vien");
        System.out.println("6. In ra danh sach tat ca sinh vien.");
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
                    System.out.println("Enter new student id: ");
                    String id = sc.nextLine();
                    if (studentManager.getIndex(id) < 0) {
                        System.out.println("Enter new student name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter new student birth day: ");
                        String birthDay = sc.nextLine();
                        System.out.println("Enter new student mark: ");
                        double mark = sc.nextDouble();
                        sc.nextLine();
                        int index;
                        do{
                            System.out.println("Enter new student class name: ");
                            String className = sc.nextLine();
                            index = classManager.getIndexByName(className);
                            if(index>=0) {
                                Classes classInfor = classManager.getClassesList().get(index);
                                Student student = new Student(id,name,birthDay,mark, classInfor);
                                studentManager.addNew(student);
                                isInvalid = true;
                            }else {
                                System.out.println("Class is not found!!");
                            }
                        }while(index<0);
                    } else {
                        System.out.println("Id is already exist!");
                    }
                } while (!isInvalid);
                break;
            }
            case 2: {
                System.out.println("Enter student id: ");
                String id = sc.nextLine();
                if (studentManager.getIndex(id) >= 0) {
                    System.out.println("Enter new student name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter new student birth day: ");
                    String birthDay = sc.nextLine();
                    System.out.println("Enter new student mark: ");
                    double mark = sc.nextDouble();
                    sc.nextLine();
                    int index;
                    do {
                        System.out.println("Enter new student class name: ");
                        String className = sc.nextLine();
                        index = classManager.getIndexByName(className);
                        if (index >= 0) {
                            Classes classInfor = classManager.getClassesList().get(index);
                            Student student = new Student(id, name, birthDay, mark, classInfor);
                            studentManager.update(id, student);
                        } else {
                            System.out.println("Class is not found!!");
                        }
                    } while (index < 0);
                }else {
                    System.out.println("Class is not found!");
                }
                break;
            }
            case 3:{
                System.out.println("Enter student id: ");
                String id = sc.nextLine();
                if (studentManager.getIndex(id) >= 0) {
                    studentManager.remove(id);
                } else {
                    System.out.println("Student not found!");
                }
                break;
            }
            case 4:{
                studentManager.sortStudentList();
                System.out.println("Da sap xep.");
                studentManager.showAll();
                break;
            }
            case 5:{
                System.out.println("Enter student id want to find: ");
                String studentId = sc.nextLine();
                int studentIndex = studentManager.getIndex(studentId);
                if(studentIndex>=0){
                    Student foundStudent =  studentManager.getStudentList().get(studentIndex);
                    System.out.println(foundStudent);
                }else {
                    System.out.println("Student not found!!");
                }
                break;
            }
            case 6: {
                studentManager.showAll();
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
