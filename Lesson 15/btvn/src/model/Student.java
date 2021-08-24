package model;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String birthDay;
    private double mark;
    private Classes classInfor;

    public Student() {
    }

    public Student(String id, String name, String birthDay, double mark, Classes classInfor) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.mark = mark;
        this.classInfor = classInfor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Classes getClassInfor() {
        return classInfor;
    }

    public void setClassInfor(Classes classInfor) {
        this.classInfor = classInfor;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", mark=" + mark +
                ", classInfor=" + classInfor +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
