package view;

import model.Product;
import model.User;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    public Scanner sc = new Scanner(System.in);
    private List<User> userList;
    private List<Product> productList;

    public AdminView(List<User> userList, List<Product> productList) {
        this.userList = userList;
        this.productList = productList;
    }

    public void run() {
        AdminUserView adminUserView = new AdminUserView(userList);
        AdminProductView adminProductView = new AdminProductView(productList);
        AdminRevenueView adminRevenueView = new AdminRevenueView(userList);
        int choice;
        do{
            System.out.println(".....TRANG QUẢN LÝ....");
            System.out.println("1. Quản lý tài khoản.");
            System.out.println("2. Quản lý sản phẩm.");
            System.out.println("3. Quản lý doanh thu.");
            System.out.println("0. Đăng xuất.");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:{
                    adminUserView.run();
                    break;
                }
                case 2:{
                    adminProductView.run();
                    break;
                }
                case 3: {
                    adminRevenueView.run();
                    break;
                }
            }
        }while(choice!=0);

    }
}
