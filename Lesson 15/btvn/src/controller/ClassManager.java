package controller;

import model.Classes;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassManager implements GeneralManager<Classes>{
    private List<Classes> classesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ClassManager() {
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public void showStudentInClass(List<Student> students,String className) {
        for(Student i : students) {
            if(i.getClassInfor().getClassName().equals(className)) {
                System.out.println(i);
            }
        }
    }
    public int getStudentNumberInClass(List<Student> students,String className) {
        int count = 0;
        for(Student i : students) {
            if(i.getClassInfor().getClassName().equals(className)) {
                count++;
            }
        }
        return count;
    }
    public int getIndex(String classId) {
        int index = -1;
        for(int i=0;i<classesList.size();i++) {
            if(classesList.get(i).getId().equals(classId)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public int getIndexByName(String className) {
        int index = -1;
        for(int i=0;i<classesList.size();i++) {
            if(classesList.get(i).getClassName().equals(className)) {
                index = i;
                break;
            }
        }
        return index;
    }
    @Override
    public void showAll() {
        for(Classes i:classesList) {
            System.out.println(i);
        }
    }

    @Override
    public void addNew(Classes classes) {
        classesList.add(classes);
    }

    @Override
    public void update(String id, Classes classes) {
        try{
            int index = getIndex(id);
            classesList.set(index,classes);
        }catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("Class not found!");
        }
    }

    @Override
    public void remove(String id) {
        int index = getIndex(id);
        try{
            classesList.remove(index);
            System.out.println("Remove complete!");
        }catch (ArrayIndexOutOfBoundsException a){
            System.err.println("Class not found!");
        }
    }
}
