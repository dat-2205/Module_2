package view;

import controller.ProductManagement;
import controller.UserManagement;
import model.Product;
import model.User;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginView {
   public Scanner sc = new Scanner(System.in);
   private List<User> userList = new ArrayList<>();
   private List<Product> productList = new ArrayList<>();
   private final String PATH_USER = "user.txt";
   private final String PATH_PRODUCT = "product.txt";

    public LoginView() {
    }

    public void run() {
       int choice;
       readProductFromFile(PATH_PRODUCT);
       readUserFromFile(PATH_USER);
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
                   UserManagement userManagement = new UserManagement(userList);
                   userManagement.writeToFile(userManagement.getUserList(),PATH_USER);
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
        String id = "00" + (userList.size()+1);
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = getNewUser(id);
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

    public void readProductFromFile(String path) {
        ProductManagement productManagement = new ProductManagement(productList);
        List <Product> productFormFile = productManagement.readProductFromFile(path);
            for(Product p: productFormFile) {
                productManagement.add(p);
            }
    }

    public void readUserFromFile(String path) {
        UserManagement userManagement = new UserManagement(userList);
        List <User> userListFromFile = userManagement.readFromFile(path);
        for(User u: userListFromFile) {
            userManagement.add(u);
        }
    }

    public User getNewUser(String id) {
        int index;
        String username = getUserName();
        Matcher matcher;
        String password = getPassword();
        String name = getNameUser();
        String sex = getUserSex();
        String birthday = getUserBirthDay();
        String email = getUserEmail();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = new User(id,username,password, "customer",name,sex,birthday,email,date);
        return user;
    }

    private String getUserEmail() {
        Matcher matcher;
        String email;
        do{
            System.out.println("Nhập email: ");
            email = sc.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
            matcher = pattern.matcher(email);
            if(!matcher.matches()) {
                System.err.println("Email không đúng định dạng!(abc@gmail.com.vn)");
            }
        }while(!matcher.matches());
        return email;
    }

    private String getUserBirthDay() {
        Matcher matcher ;
        String birthday;
        do{
            System.out.println("Nhập ngày sinh: ");
            birthday = sc.nextLine();
            Pattern pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");
            matcher = pattern.matcher(birthday);
            if(!matcher.matches()) {
                System.err.println("Ngày sinh không đúng định dạng!(dd/mm/yyyy)");;
            }
        }while(!matcher.matches());
        return birthday;
    }

    private String getUserSex() {
        String sex;
        do{
            System.out.println("Nhập giới tính: ");
            sex = sc.nextLine();
            if(!sex.equals("male") && !sex.equals("female")){
                System.err.println("Giới tính là male hoặc female");
            }
        }while(!sex.equals("male") && !sex.equals("female"));
        return sex;
    }

    private String getNameUser() {
        String name;
        do{
            System.out.println("Nhập tên người dùng: ");
            name = sc.nextLine();
            if(name.equals("")) {
                System.err.println("Bạn phải nhập tên!");
            }
        }while(name.equals(""));
        return name;
    }

    private String getPassword() {
        Matcher matcher;
        String password ;
        do{
            System.out.println("Nhập mật khẩu: ");
            password = sc.nextLine();
            Pattern pattern = Pattern.compile("^\\w{3,}");
            matcher = pattern.matcher(password);
        }while(!matcher.matches());
        return password;
    }

    private String getUserName() {
        String username;
        do {
            Matcher matcher;
            do{
                System.out.println("Nhập tên tài khoản: ");
                username = sc.nextLine();
                Pattern pattern = Pattern.compile("^\\w+$");
                matcher = pattern.matcher(username);
                if(!matcher.matches()){
                    System.err.println("Tên tài khoản không hợp lệ!(không chứa ký tự đặc biệt, không chứa dấu cách)");
                }
            }while(!matcher.matches());


            if(!checkUsername(username)) {
                System.err.println("Tên tài khoản đã tồn tại!");
            }
        }while(!checkUsername(username));
        return username;
    }


}
