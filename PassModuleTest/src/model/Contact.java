package model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;
    private String facebook;
    private String gender;
    private String birthday;
    private String relationship;

    public Contact() {
    }

    public Contact(String name, String phoneNumber, String email, String facebook) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.facebook = facebook;
    }

    public Contact(String name, String phoneNumber, String email, String facebook, String gender, String birthday, String relationship) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.facebook = facebook;
        this.gender = gender;
        this.birthday = birthday;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return  "Tên Liên Hệ: " + name + '\'' +
                " | Số điện thoại: " + phoneNumber + '\'' +
                " | Email: " + email + '\'' +
                " | Facebook: " + facebook + '\'' +
                " | Giới tính: " + gender + '\'' +
                " | Sinh nhật: " + birthday + '\'' +
                " | Người này thuộc: " + relationship + '\'';
    }
}
