package com.codegym;

public class KhachSan extends Nguoi{
    private int roomNumber= 0;
    private int roomClass = 1;
    private int day = 0;

    public KhachSan() {}
    public KhachSan(int roomNumber, int roomClass, int day) {
        this.roomNumber = roomNumber;
        this.roomClass = roomClass;
        this.day = day;
    }
    public KhachSan(String name, String birth, int cmt, int roomNumber, int roomClass, int day){
        super(name,birth,cmt);
        this.roomNumber = roomNumber;
        this.roomClass = roomClass;
        this.day = day;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(int roomClass) {
        this.roomClass = roomClass;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public int Payment() {
        int invoice = 0;
        switch (roomClass) {
            case 1:
                invoice = day*1000;
                break;
            case 2:
                invoice = day*1300;
                break;
            case 3:
                invoice = day*1700;
                break;
            case 4:
                invoice = day*2000;
                break;
            case 5:
                invoice = day*2500;
                break;
        }
        return invoice;
    }

    @Override
    public String toString() {
        return "KhachSan{" +
                super.toString() +
                ", roomNumber=" + roomNumber +
                ", roomClass=" + roomClass +
                ", day=" + day +
                '}';
    }
}
