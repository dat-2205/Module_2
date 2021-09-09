package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String sex;
    private String birthday;
    private String email;
    private String dateCreate;
    private List<BillElement> cart = new ArrayList<>();
    private List<Bill> paid = new ArrayList<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, String role, String date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.dateCreate = date;
    }

    public User(String id, String username, String password, String role, String name,String sex, String birthday, String email, String dateCreate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.dateCreate = dateCreate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<BillElement> getCart() {
        return cart;
    }
    public List<BillElement> getCartValue() {
        List<BillElement> bl = new ArrayList<>();
        for(BillElement billElement : cart) {
            bl.add(billElement);
        }
        return bl;
    }


    public void setCart(List<BillElement> cart) {
        this.cart = cart;
    }

    public List<Bill> getPaid() {
        return paid;
    }

    public void setPaid(List<Bill> paid) {
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String showCart() {
        String s = "";
        for(BillElement billElement : cart) {
            s += billElement.toString()+"\n";
        }
        return s;
    }
    public String getBillToString() {
        String s = "";
        for(Bill bill : paid) {
            s +=  bill.showBillElement()
                 + " ~ " + bill.getDate() + "\n"
                 + " ~ " + bill.getTotalPayment() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        if(role.equals("customer")) {
            return  " + Id người dùng: " + id + '\n' +
                    " + Username: " + username + '\n' +
                    " + Password: " + password + '\n' +
                    " + Quyền sử dùng: " + role + '\n' +
                    " + Tên người dùng: " + name + '\n' +
                    " + Giới tính: " + sex + '\n' +
                    " + Sinh nhật: " + birthday + '\n' +
                    " + Email: " + email + '\n' +
                    " + Ngày lập tài khoản: " + dateCreate + '\n' +
                    " + Giỏ hàng: " + showCart() + "\n"+
                    " + Đã mua: " + getBillToString();
        }
        else {
            return " + Id người dùng: " + id + '\n' +
                    " + Username: " + username + '\n' +
                    " + Password: " + password + '\n' +
                    " + Quyền sử dùng: " + role + '\n' +
                    " + Tên người dùng: " + name + '\n' +
                    " + Giới tính: " + sex + '\n' +
                    " + Sinh nhật: " + birthday + '\n' +
                    " + Email: " + email + '\n' +
                    " + Ngày lập tài khoản: " + dateCreate + '\n';
        }
    }
}
