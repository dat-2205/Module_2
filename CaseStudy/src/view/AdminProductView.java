package view;

import controller.ProductManagement;
import model.Product;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminProductView {
    private List<Product> productList;
    private ProductManagement productManagement;
    private Scanner sc = new Scanner(System.in);
    private final String PATH = "product.txt";

    public AdminProductView(List<Product> productList) {
        this.productList = productList;
        productManagement = new ProductManagement(this.productList);
    }

    public void run() {
        menu();
    }

    private void menu() {
        int choice;
        getProductFromFile();
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=0);
    }

    private void getProductFromFile() {
        List <Product> productFormFile = productManagement.readProductFromFile(PATH);
        for(Product p: productFormFile) {
            productManagement.add(p);
        }
    }

    private void choiceHandle(int choice) {
        switch (choice) {
            case 1:{
                String id = "00" + (productManagement.getProductList().size()+1);
                Product product = getNewProduct(id);
                productManagement.add(product);
                productManagement.writeProductToFile(productList,PATH);
                break;
            }
            case 2:{
                System.out.println("Nhập id sản phẩm muốn xoá: ");
                String id = sc.nextLine();
                productManagement.delete(id);
                productManagement.writeProductToFile(productList,PATH);
                break;
            }
            case 3:{
                System.out.println("Nhập  id sản phẩm muốn sửa");
                String id = sc.nextLine();
                int index = productManagement.findById(id);
                if(index != -1) {
                    updateHandle(index);
                }else {
                    System.err.println("Không tìm thấy sản phẩm");
                }
                break;
            }
            case 4: {
                System.out.println("Nhập id sản phẩm tìm: ");
                String id = sc.nextLine();
                int index = productManagement.findById(id);
                if(index!=-1) {
                    System.out.println(productManagement.getProductList().get(index));
                }else{
                    System.err.println("Không tìm thấy sản phẩm!");
                }
                break;
            }
            case 5:{
                productManagement.showAll();
                break;
            }
            case 6:{
                productManagement.showAllKindOfProduct();
                System.out.println("Bạn muốn hiển thị sản phẩm danh mục: ");
                String kindOfProductToShow = sc.nextLine();
                productManagement.showProductByKindOf(kindOfProductToShow);
                break;
            }
            case 7:{
                System.out.println("1. Sắp xếp theo tên.");
                System.out.println("2. Sắp cếp theo giá.");
                System.out.print("Lựa chọn: ");
                int sortChoice = sc.nextInt();
                sc.nextLine();
                sortChoiceHandle(sortChoice);
                break;
            }
        }
    }

    private void updateHandle(int index) {
        int updateProductChoice;
        do{
            System.out.println("1. Sửa tên sản phẩm.");
            System.out.println("2. Sửa mô tả sản phẩm.");
            System.out.println("3. Sửa giá sản phẩm.");
            System.out.println("4. Sửa danh mục sản phẩm.");
            System.out.println("5. Sửa số lượng trong kho.");
            System.out.println("Nhập lựa chọn: ");
            updateProductChoice = sc.nextInt();
            sc.nextLine();
            Product productUpdate = productList.get(index);
            updateProductChoiceHandle(productUpdate,updateProductChoice);
            productManagement.writeProductToFile(productList,PATH);
            System.out.println("Thay đổi thông tin thành công");
        }while(updateProductChoice!=0);
    }

    private void sortChoiceHandle(int sortChoice) {
        switch (sortChoice) {
            case 1:{
                productManagement.sortByProductName();
                break;
            }
            case 2:{
                productManagement.sortByProductPrice();
                break;
            }
        }
    }


    private void updateProductChoiceHandle(Product productUpdate, int updateProductChoice) {
        switch (updateProductChoice) {
            case 1:{
                String productName = getProductName();
                productUpdate.setProductName(productName);
                System.out.println("Đã lưu thay đổi!");
                break;
            }
            case 2:{
                String productInformation = getProductInformation();
                productUpdate.setProductInformation(productInformation);
                System.out.println("Đã lưu thay đổi");
                break;
            }
            case 3:{
                double price = getProductPrice();
                productUpdate.setPrice(price);
                System.out.println("Đã lưu thay đổi");
                break;
            }
            case 4:{
                String kindOf = getKindOfProduct();
                productUpdate.setKindOf(kindOf);
                System.out.println("Đã lưu thay đổi!");
                break;
            }
            case 5:{
                int inStock = getInStock();
                productUpdate.setInStock(inStock);
                System.out.println("Đã lưu thay đổi!");
                break;

            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Thêm sản phẩm.");
        System.out.println("2. Xoá sản phẩm.");
        System.out.println("3. Cập nhật sản phẩm.");
        System.out.println("4. Tìm kiếm sản phẩm(Id).");
        System.out.println("5. Xem tât cả sản phẩm.");
        System.out.println("6. Xem sản phẩm theo danh mục.");
        System.out.println("7. Sắp xếp sản phẩm.");
        System.out.println("Nhập lựa chọn: ");
    }

    private Product getNewProduct(String id) {
        Matcher matcher;
        String productName = getProductName();
        String productInformation = getProductInformation();
        double price = getProductPrice();
        String kindOf = getKindOfProduct();
        int inStock = getInStock();
        Product product = new Product(id,productName,productInformation,price,kindOf,inStock);
        return product;
    }

    private int getInStock() {
        Matcher matcher;
        String quantityString;
        do{
            Pattern pattern = Pattern.compile("^[0-9]+$");
            System.out.println("Nhập số lượng trong kho: ");
            quantityString = sc.nextLine();
            matcher = pattern.matcher(quantityString);
            if(!matcher.matches()) {
                System.err.println("Số lượng không hợp lệ!");
            }
        }while(!matcher.matches());
        int inStock = Integer.parseInt(quantityString);
        return inStock;
    }

    private String getKindOfProduct() {
        String kindOf="";
        do{
            System.out.println("Nhập danh mục sản phẩm: ");
            kindOf = sc.nextLine();
            if(kindOf.equals("")) {
                System.err.println("Danh mục không được để rỗng!");
            }
        }while(kindOf.equals(""));
        return kindOf;
    }

    private double getProductPrice() {
        Matcher matcher;
        String priceString;
        do{
            Pattern pattern = Pattern.compile("^[0-9]+$");
            System.out.println("Nhập giá sản phẩm: ");
            priceString = sc.nextLine();
            matcher = pattern.matcher(priceString);
            if(!matcher.matches()) {
                System.err.println("Giá không hợp lệ!");
            }
        }while(!matcher.matches());
        return Double.parseDouble(priceString);
    }

    private String getProductInformation() {
        System.out.println("Nhập mô tả sản phẩm: ");
        String productInformation = sc.nextLine();
        String priceString;
        return productInformation;
    }

    private String getProductName() {
        String productName="";
        do{
            System.out.println("Nhập tên sản phẩm: ");
            productName = sc.nextLine();
            if(productName.equals("")) {
                System.err.println("Tên không được để trống!");
            }
        }while(productName.equals(""));
        return productName;
    }
}
