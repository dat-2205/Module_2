package controller;

import model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements GeneralManager<Student>{
    private List<Student> studentList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public StudentManager() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    public int getIndex(String id) {
        int index = -1;
        for(int i=0;i<studentList.size();i++) {
            if(studentList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void sortStudentList() {
        Collections.sort(studentList);
    }
    @Override
    public void showAll() {
        for(Student i:studentList) {
            System.out.println(i);
        }
    }

    @Override
    public void addNew(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(String id, Student student) {
        try{
            int index = getIndex(id);
            studentList.set(index,student);
        }catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("Student not found!");
        }
    }

    @Override
    public void remove(String id) {
        int index = getIndex(id);
        try{
            studentList.remove(index);
            System.out.println("Remove complete!");
        }catch (ArrayIndexOutOfBoundsException a){
            System.err.println("Class not found!");
        }
    }
}
