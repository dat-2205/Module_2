package view;

import controller.ProductManagement;
import model.Product;
import model.User;

import java.util.Scanner;

public class ProductMenu {
    private ProductManagement productManagement = new ProductManagement();
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int choice;
        System.out.println("1. Thêm sản phẩm.");
        System.out.println("2. Xoá sản phẩm.");
        System.out.println("3. Cập nhật sản phẩm.");
        System.out.println("4. Xem tất cả sản phẩm.");
        System.out.println("5. Tìm kiếm sản phẩm(Id).");
        System.out.println("Nhập lựa chọn: ");
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:{
                String id = "00" + (productManagement.getProductList().size()+1);
                Product product = getNewProduct(id);
                productManagement.add(product);
                break;
            }
            case 2:{
                System.out.println("Nhập id sản phẩm muốn xoá: ");
                String id = sc.nextLine();
                productManagement.delete(id);
                break;
            }
            case 3:{
                System.out.println("Nhập  id tài khoản muốn sửa");
                String id = sc.nextLine();
                int index = productManagement.findById(id);
                sc.nextLine();
                if(index != -1) {
                    Product product = getNewProduct(id);
                    productManagement.update(index,product);
                    System.out.println("Thay đổi thông tin thành công");
                }else {
                    System.out.println("Không tìm thấy sản phẩm");
                }
            }
            case 4: {
                System.out.println("Nhập id khoản muốn tìm: ");
                String id = sc.nextLine();
                int index = productManagement.findById(id);
                if(index!=-1) {
                    System.out.println(productManagement.getProductList().get(index));
                }
            }
        }
    }

    private Product getNewProduct(String id) {
        System.out.println("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        String productInformation = sc.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập danh mục sản phẩm: ");
        String kindOf = sc.nextLine();
        System.out.println("Nhập số lượng trong kho: ");
        int inStock = sc.nextInt();
        sc.nextLine();
        Product product = new Product(id,productName,productInformation,price,kindOf,inStock);
        return product;
    }
}
