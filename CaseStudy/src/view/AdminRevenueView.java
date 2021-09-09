package view;

import controller.UserManagement;
import model.Bill;
import model.BillElement;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRevenueView {
    private List<User> userList;
    private List<Bill> bills;
    private UserManagement userManagement;
    private Scanner sc = new Scanner(System.in);

    public AdminRevenueView(List<User> user) {
        this.userList = user;
        this.bills = getBillList();
        userManagement = new UserManagement(user);
    }

    public void run() {
        int choice;
        System.out.println("....TRANG BÁO CÁO DOANH THU....");
        System.out.println("1. Xem doanh thu tháng.");
        System.out.println("2. Xem số lượng các sản phẩm bán trong tháng.");
        System.out.print("Lựa chọn: ");
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice) {
            case 1: {
                int month = getMonth();
                double revenue = getRevenue(month);
                System.out.println("Doanh thu của tháng " + month);
                System.out.println(" -" + revenue);
            }
            case 2:{
                int month = getMonth();
                getProductSoldInMonth(month);
                break;
            }
        }
    }

    private void getProductSoldInMonth(int month) {
        List<BillElement> billElements = new ArrayList<>();
        for(Bill b : bills) {
            String monthString = b.getDate().substring(3,5);
            int m = Integer.parseInt(monthString);
            if(m == month) {
                billElements.addAll(b.getBillElement());
            }
        }
        List<Product> productList = new ArrayList<>();
        for(int i=0;i<billElements.size();i++) {
            if(productList.contains(billElements.get(i).getProduct())){
                continue;
            }
            int quantity = billElements.get(i).getQuantity();
            for(int j=i+1;j<billElements.size();i++) {
                if(billElements.get(i).getProduct().getId().equals(billElements.get(j).getProduct().getId())){
                     quantity  += billElements.get(j).getQuantity();
                }
            }
            billElements.get(i).getProduct().setSold(quantity);
            productList.add(billElements.get(i).getProduct());
        }
        for(Product p : productList) {
            System.out.println(" + Id sản phẩm:  " + p.getId() +
                    " | Tên sản phẩm: " + p.getProductName()  +
                    " |  Mô tả:  " + p.getProductInformation() +
                    " | Giá: " + p.getPrice() +
                    " |  Danh mục: " + p.getKindOf() +
                    " | Đã bán: " + p.getSold()
            );
        }
    }

    private int getMonth() {
        int month;
        do{
            System.out.println("Nhập tháng muốn xem: ");
            month = sc.nextInt();
            sc.nextLine();
            if(month<0 || month>13) {
                System.out.println("Bạn nhập tháng không hợp lệ!");
            }
        }while(month<0 || month>13);
        return month;
    }

    private double getRevenue(int month) {
        double revenue = 0;
        for(Bill b : bills) {
           String monthString = b.getDate().substring(3,5);
           int m = Integer.parseInt(monthString);
           if(m == month) {
               revenue += b.getTotalPayment();
           }
        }
        return revenue;
    }

    private List<Bill> getBillList() {
        List<Bill> billList = new ArrayList<>();
        for(User u : userList) {
            billList.addAll(u.getPaid());
        }
        return billList;
    }
}
