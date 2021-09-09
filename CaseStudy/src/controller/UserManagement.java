package controller;

import model.Product;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagement implements ManagementInterface<User>{
    private List<User> userList;

    public UserManagement(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public void update(int index,User user) {

        userList.set(index,user);
    }

    @Override
    public void delete(String id) {
        int index = findById(id);
        if(index!=-1) {
            userList.remove(index);
            System.out.println("Xoá thành công!");
        }else {
            System.err.println("Không tìm thấy tài khoản!");
        }
    }

    @Override
    public void showAll() {
        int count1=1;
        int count2=1;
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getRole().equals("admin")){
                System.out.println("Quản trị viên " + count1 );
                count1++;
            }else {
                System.out.println("Khách hàng " + count2);
                count2++;
            }
            System.out.println(userList.get(i) + "\n");
        }
    }

    public void showAllAdmin() {
        int count1=1;
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getRole().equals("admin")){
                System.out.println("Quản trị viên " + count1 );
                count1++;
                System.out.println(userList.get(i) + "\n");
            }
        }
    }

    public void showAllCustomer() {
        int count1=1;
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getRole().equals("customer")){
                System.out.println("Khách hàng " + count1 );
                count1++;
                System.out.println(userList.get(i) + "\n");
            }
        }
    }

    @Override
    public int findById(String id) {
       for(int i=0;i<userList.size();i++) {
           if(userList.get(i).getId().equals(id)) {
               return i;
           }
       }
       return -1;
    }
    public int findByUserName(String username) {
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void writeToFile(List<User> userList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readFromFile(String path) {
        List<User> readProductList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readProductList = (List<User>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return readProductList;
    }
}
