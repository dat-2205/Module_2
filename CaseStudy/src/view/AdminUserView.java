package view;

import controller.UserManagement;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminUserView {
    private List<User> userList;
    private UserManagement userManagement;
    private Scanner sc = new Scanner(System.in);

    public AdminUserView(List<User> userList) {
        this.userList = userList;
        userManagement = new UserManagement(this.userList);
    }

    public void run() {
        menu();
    }

    private void menu() {
        int choice;
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=0);
    }

    private void choiceHandle(int choice) {
        switch (choice) {
            case 1:{
                String id = "00" + (userManagement.getUserList().size()+1);
                User user = getNewUser(id);
                userManagement.add(user);
                break;
            }
            case 2:{
                System.out.println("Nhập id tài khoản muốn xoá: ");
                String id = sc.nextLine();
                userManagement.delete(id);
                break;
            }
            case 3:{
                System.out.println("Nhập  id tài khoản muốn sửa");
                String id = sc.nextLine();
                int index = userManagement.findById(id);
                if(index != -1) {
                    User user = getNewUser(id);
                    userManagement.update(index,user);
                    System.out.println("Thay đổi thông tin thành công");
                }else {
                    System.out.println("Không tìm thấy tài khoản");
                }
                break;
            }
            case 4: {
                System.out.println("Bạn muốn tìm theo: ");
                System.out.println("1. Theo id.");
                System.out.println("2. Theo username.");
                int findUserChoice = sc.nextInt();
                sc.nextLine();
                switch(findUserChoice) {
                    case 1:{
                        findByIdUserMenu();
                        break;
                    }
                    case 2:{
                        findByUserNameUserMenu();
                        break;
                    }
                }

                break;
            }
            case 5:{
                userManagement.showAll();
                break;
            }
        }
    }

    private void findByIdUserMenu() {
        System.out.println("Nhập id tài khoản muốn tìm: ");
        String id = sc.nextLine();
        int index = userManagement.findById(id);
        if(index!=-1) {
            System.out.println(userManagement.getUserList().get(index));
        }else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }
    private void findByUserNameUserMenu() {
        System.out.println("Nhập username tài khoản muốn tìm: ");
        String username = sc.nextLine();
        int index = userManagement.findByUserName(username);
        if(index!=-1) {
            System.out.println(userManagement.getUserList().get(index));
        }else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    private void displayMenu() {
        System.out.println("1. Tạo tài khoản mới.");
        System.out.println("2. Xoá tài khoản.");
        System.out.println("3. Sửa tài khoản.");
        System.out.println("4. Tìm kiếm tài khoản.");
        System.out.println("5. Xem tất cả tài khoản.");
        System.out.println("0. Đăng xuất.");
        System.out.println("Nhập lựa chọn: ");
    }

    public User getNewUser(String id) {
        int index;
        String username = getUserName();
        Matcher matcher;
        String password = getPassword();
        String role = getRoleUser();
        String name = getNameUser();
        String sex = getUserSex();
        System.out.println("Nhập ngày sinh: ");
        String birthday = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = new User(id,username,password,role,name,sex,birthday,email,date);
        return user;
    }

    private String getUserSex() {
        String sex;
        do{
            System.out.println("Nhập giới tính: ");
            sex = sc.nextLine();
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

    private String getRoleUser() {
        String role;
        do{
            System.out.println("Nhập quyền sử dụng: ");
            role = sc.nextLine();
            if(!role.equals("admin") && !role.equals("customer")) {
                System.err.println("Bạn  phải nhập là admin hoặc customer!");
            }
        }while(!role.equals("admin") && !role.equals("customer"));
        return role;
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
        int index;
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

            index = userManagement.findByUserName(username);
            if(index>=0) {
                System.err.println("Tên tài khoản đã tồn tại!");
            }
        }while(index>=0);
        return username;
    }
}
