package com.codegym;

public class Nguoi {
    private String name = "null";
    private String birth = "null";
    private int cmt = 0;

    public Nguoi() {}
    public Nguoi(String name, String birth, int cmt) {
        this.name = name;
        this.birth = birth;
        this.cmt = cmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getCmt() {
        return cmt;
    }

    public void setCmt(int cmt) {
        this.cmt = cmt;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", cmt=" + cmt +
                '}';
    }
}
