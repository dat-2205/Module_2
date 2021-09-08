package view;

import model.Product;
import model.User;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginView {
   public Scanner sc = new Scanner(System.in);
   private List<User> userList = new ArrayList<>();
   private List<Product> productList = new ArrayList<>();

    public LoginView() {
        userList.add(new User("001","dat1","dat1","admin","1/1/1000"));
        userList.add(new User("002","dat2","dat2","customer","1/1/1000"));
    }

    public void run() {


       int choice;
       do{
           displayMenu();
           choice = sc.nextInt();
           sc.nextLine();
           switch (choice) {
               case 1: {
                   doLogin();
                   break;
               }
               case 2:{
                   doRegister();
                   break;
               }
           }
       }while(choice!=0);

   }

    private void displayMenu() {
        System.out.println("....ĐĂNG NHẬP ĐỂ SỬ DỤNG....");
        System.out.println("1. Đăng nhập.");
        System.out.println("2. Đăng ký.");
        System.out.println("Nhập lựa chọn.");
    }

    private void doLogin() {
        System.out.println("Nhập tên tài khoản: ");
        String username = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        User login = doLogin(username,password);
        if(login!=null) {
            if(login.getRole().equals("admin")){
                AdminView adminView = new AdminView(userList,productList);
                adminView.run();
            }else if (login.getRole().equals("customer")) {
                CustomerView customerView = new CustomerView(login,productList);
                customerView.run();
            }
        }else{
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }
    }

    private void doRegister() {
        System.out.println("....ĐĂNG KÝ....");
        boolean isInvalid = false;
        String username = "";
        do{
            System.out.println("1. Nhập tên tài khoản: ");
            username = sc.nextLine();
            isInvalid = checkUsername(username);
            if(!isInvalid) {
                System.out.println("Tên tài khoản đã được sử dụng!");
            }
        }while(!isInvalid);
        System.out.println("2. Nhập mật khẩu.");
        String password = sc.nextLine();
        System.out.println("3. Nhập tên người dùng.");
        String name = sc.nextLine();
        System.out.println("4. Nhập giới tính.");
        String sex = sc.nextLine();
        System.out.println("5. Nhập ngày sinh.");
        String birthday = sc.nextLine();
        System.out.println("6. Nhập email.");
        String email = sc.nextLine();
        String id = "00" + (userList.size()+1);
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = new User(id,username,password,"customer",name,sex,birthday,email,date);
        userList.add(user);
        System.out.println("Đăng ký thành công!");
    }

    public User doLogin(String username, String password) {
        for(User i: userList) {
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                return i;
            }
        }
        return null;
    }
    public boolean checkUsername(String username) {
        for(User i: userList) {
            if(i.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public void writeProductToFile(List<Product> productList,String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readProductFromFile(String path) {
        List<Product> readProductList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readProductList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return readProductList;
    }


}
