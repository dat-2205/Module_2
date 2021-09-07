package view;

import controller.UserManagement;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserMenu {
    private UserManagement userManagement = new UserManagement();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        menu();
    }

    private void menu() {
        int choice;
        do{
            System.out.println("1. Tạo tài khoản mới.");
            System.out.println("2. Xoá tài khoản.");
            System.out.println("3. Sửa tài khoản.");
            System.out.println("4. Tìm kiếm tài khoản.");
            System.out.println("0. Đăng xuất.");
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
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
                    sc.nextLine();
                    if(index != -1) {
                        User user = getNewUser(id);
                        userManagement.update(index,user);
                        System.out.println("Thay đổi thông tin thành công");
                    }else {
                        System.out.println("Không tìm thấy tài khoản");
                    }
                }
                case 4: {
                    System.out.println("Nhập id khoản muốn tìm: ");
                    String id = sc.nextLine();
                    int index = userManagement.findById(id);
                    if(index!=-1) {
                        System.out.println(userManagement.getUserList().get(index));
                    }
                }
            }
        }while(choice!=0);
    }

    public User getNewUser(String id) {
        int index;
        String username="";
        do {
            System.out.println("Nhập tên tài khoản: ");
            username = sc.nextLine();
            index = userManagement.findByUserName(username);
            if(index>0) {
                System.out.println("Tên tài khoản đã tồn tại!");
            }
        }while(index>0);
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        System.out.println("Nhập quyền sử dụng: ");
        String role = sc.nextLine();
        System.out.println("Nhập tên người dùng: ");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthday = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = new User(id,username,password,role,name,sex,birthday,email,date);
        return user;
    }
}
