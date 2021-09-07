package view;

import controller.UserManagement;
import model.User;

import java.util.List;
import java.util.Scanner;

public class CustomerUserView {
    private List<User> userList;
    private UserManagement userManagement;
    private Scanner sc = new Scanner(System.in);

    public CustomerUserView(List<User> userList) {
        this.userList = userList;
        userManagement = new UserManagement(this.userList);
    }
    public void run() {
        int choice;
        System.out.println("....ĐĂNG KÝ....");
    }
}
