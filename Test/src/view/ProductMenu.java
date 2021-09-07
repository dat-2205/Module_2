package view;

import controller.ProductManagement;
import model.Product;

import java.util.Scanner;

public class ProductMenu {
    private ProductManagement productManagement = new ProductManagement();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int choice;
        do{
            choice = displayMenu();
            sc.nextLine();
            menuChoiceHandle(choice);
        }while(choice!=0);

    }

    private int displayMenu() {
        int choice;
        System.out.println(".....CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM.....");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới.");
        System.out.println("3. Cập nhật.");
        System.out.println("4. Xoá");
        System.out.println("5. Sắp xếp.");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất.");
        System.out.println("7. Đọc từ file.");
        System.out.println("8. Ghi vào file.");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");
        choice = sc.nextInt();
        return choice;
    }

    private void menuChoiceHandle(int choice) {
        switch(choice) {
            case 1:{
                productManagement.showAll();
                break;
            }
            case 2:{
                System.out.println("Nhập id sản phẩm: ");
                String id = sc.nextLine();
                System.out.println("Nhập tên sản phẩm: ");
                String productName = sc.nextLine();
                System.out.println("Nhập giá sản phẩm: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.println("Nhập số lượng sản phẩm: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập mô tả sản phẩm: ");
                String productInformation = sc.nextLine();
                Product product = new Product(id,productName,price,quantity,productInformation);
                productManagement.add(product);
                System.out.println("Thêm thành công!");
                break;
            }
            case 3:{
                System.out.println("Nhập id sản phẩm muốn sửa: ");
                String id = sc.nextLine();
                int index = productManagement.findByID(id);
                if(index!=-1) {
                    int updateChoice;
                    do{
                        System.out.println("1. Sửa tên sản phẩm.");
                        System.out.println("2. Sửa giá sản phẩm.");
                        System.out.println("3. Sửa số lượng sản phẩm.");
                        System.out.println("4. Sửa mô tả sản phẩm.");
                        System.out.println("0. Thoát");
                        System.out.print("Lựa chọn: ");
                        updateChoice = sc.nextInt();
                        sc.nextLine();
                        updateChoiceHandle(index, updateChoice);
                    }while(updateChoice!=0);
                }else {
                    System.err.println("Không tìm thấy sản phẩm!");
                }
                break;
            }
            case 4:{
                System.out.println("Nhập id sản phẩm muốn sửa: ");
                String id = sc.nextLine();
                int index = productManagement.findByID(id);
                if(index!=-1) {
                    productManagement.delete(index);
                }else {
                    System.err.println("Không tìm thấy sản phẩm!");
                }
                break;
            }
            case 5:{
                System.out.println("1. Sắp xếp tăng dần theo tên.");
                System.out.println("2. Sắp xếp giảm dần theo tên.");
                System.out.print("Lựa chọn: ");
                int sortChoice = sc.nextInt();
                sc.nextLine();
                sortChoiceHandle(sortChoice);
                break;
            }
            case 6:{
                System.out.println("Sản phẩm có giá đắt nhất là: ");
                Product max = productManagement.getProductList().get(0);
                for(int i=1;i<productManagement.getProductList().size();i++) {
                    if(productManagement.getProductList().get(i).getPrice()>max.getPrice()) {
                        max = productManagement.getProductList().get(i);
                    }
                }
                System.out.println(max);
                break;
            }
            case 7:{
                System.out.println("Nếu đọc sẽ làm thay đổi dữ liệu hiện tại. Bạn muốn tiếp tục (y/n?)");
                String answer = sc.nextLine();
                if(answer.equals("y")) {
                    productManagement.setProductList(productManagement.readFromFile("product.csv"));
                    System.out.println("Đã lấy dữ liệu từ file.");
                }else {
                    System.out.println("Huỷ đọc file");
                }
                break;
            }
            case 8:{
                System.out.println("Bạn chắc chưa?");
                String answer = sc.nextLine();
                if(answer.equals("y")) {
                    productManagement.writeToFile(productManagement.getProductList(),"product.csv");
                    System.out.println("Đã ghi file.");
                }else {
                    System.out.println("Huỷ ghi file");
                }
                break;
            }
        }
    }

    private void sortChoiceHandle(int sortChoice) {
        switch(sortChoice) {
            case 1: {
                productManagement.sortByProductName();
                break;
            }
            case 2: {
                productManagement.sortByProductNameDown();
            }
        }
    }

    private void updateChoiceHandle(int index, int updateChoice) {
        switch(updateChoice) {
            case 1:{
                System.out.println("Nhập tên mới: ");
                String newProductName = sc.nextLine();
                productManagement.getProductList().get(index).setProductName(newProductName);
                break;
            }
            case 2:{
                System.out.println("Nhập giá mới: ");
                double newProductPrice = sc.nextDouble();
                productManagement.getProductList().get(index).setPrice(newProductPrice);
                break;
            }
            case 3:{
                System.out.println("Nhập số lượng mới: ");
                int newProductQuantity = sc.nextInt();
                productManagement.getProductList().get(index).setQuantity(newProductQuantity);
                break;
            }
            case 4:{
                System.out.println("Nhập mô tả mới: ");
                String newProductInformation = sc.nextLine();
                productManagement.getProductList().get(index).setProductInformation(newProductInformation);
                break;
            }
        }
    }

    private void showProduct(int begin, int end) {
        for(int i=begin;i<end;i++) {
            System.out.println(productManagement.getProductList().get(i).toString());
        }
    }
}
