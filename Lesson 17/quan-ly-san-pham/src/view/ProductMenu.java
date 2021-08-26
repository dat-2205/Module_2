package view;

import controller.ProductManagement;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ProductManagement  pm = new ProductManagement();
        int choice;
        do{
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi tat ca san pham");
            System.out.println("3. Tim kiem san pham.");
            System.out.println("4. Sua san pham");
            System.out.println("5. Xoa san pham");
            System.out.println("6. Backup du lieu");
            System.out.println("Enter a choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(pm, choice);
        }while(choice!=0);
    }

    private static void choiceHandle(ProductManagement pm, int choice) {
        switch(choice) {
            case 1:{
                Product product = getNewProduct();
                pm.add(product);
                writeToFile(pm.getProductList(),"product.txt");
                break;
            }
            case 2:{
                pm.show();
                break;
            }
            case 3:{
                String id = getIdProduct();
                int index = pm.search(id);
                if(index <0) {
                    System.out.println("Khong co san pham nay");
                }else {
                    System.out.println(pm.getProductList().get(index));
                }
                break;
            }
            case 4:{
                String id = getIdProduct();
                int index = pm.search(id);
                if(index <0) {
                    System.out.println("Khong co san pham nay");
                }else {
                    Product product = getNewProduct();
                    pm.update(index,product);
                }
                break;
            }
            case 5:{
                String id = getIdProduct();
                pm.delete(id);
                break;
            }
            case 6:{
                List<Product> backupProduct = getProductFromFileStream("product.txt");
                pm.setProductList(backupProduct);
                break;
            }
            case 0:
                System.exit(0);
        }
    }

    private static Product getNewProduct() {
        String id = getIdProduct();
        String name = getNameProduct();
        String company = getCompanyProduct();
        double price = 0;
        do {
            try {
                price = getPriceProduct();
            }catch (NumberFormatException e) {
                System.err.println("Ban phai nhap so!");
            }
        }while(price == 0);
        String information = getInformation();
        Product product = new Product(id,name,company,price,information);
        return product;
    }

    private static String getInformation() {
        System.out.println("Nhap thong tin them san pham: ");
        String information = sc.nextLine();
        return information;
    }

    private static double getPriceProduct() {
        System.out.println("Nhap gia san pham: ");
        String priceString = sc.nextLine();
        double price = Double.parseDouble(priceString);
        return price;
    }

    private static String getCompanyProduct() {
        System.out.println("Nhap nha san xuat san pham: ");
        return sc.nextLine();
    }

    private static String getNameProduct() {
        System.out.println("Nhap ten san pham: ");
        return sc.nextLine();
    }

    private static String getIdProduct() {
        System.out.println("Nhap id san pham: ");
        return sc.nextLine();
    }

    private static List<Product> getProductFromFileStream(String path) {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    private static void writeToFile(List<Product> productList, String path) {
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
}
