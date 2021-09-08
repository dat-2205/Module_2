package controller;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement implements ManagementInterface<Product>{
    private List<Product> productList;
    private Scanner sc = new Scanner(System.in);

    public ProductManagement(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int index, Product product) {
        productList.set(index,product);
    }

    @Override
    public void delete(String id) {
        int index = findById(id);
        if(index!=-1) {
            productList.remove(index);
            System.out.println("Xoá thành công!");
        }else {
            System.err.println("Không tìm thấy tài khoản!");
        }
    }

    @Override
    public void showAll() {
        int count = 0;
        for (Product p: productList) {
            System.out.println(p);
            count++;
            if(count==5) {
                count = 0;
                sc.nextLine();
            }
        }
    }
    public List<String> getAllKindOfProduct() {
        List<String> kindOfProduct = new ArrayList<>();
        for(Product product : productList) {
            String kindOf = product.getKindOf();
            if(!kindOfProduct.contains(kindOf)) {
                kindOfProduct.add(kindOf);
            }
        }
        return kindOfProduct;
    }
    public void showAllKindOfProduct() {
        List<String> kindOfProduct = getAllKindOfProduct();
        System.out.println("Danh mục các sản phẩm: ");
        for(int i=0;i< kindOfProduct.size();i++) {
            System.out.println("  " + (i+1) + ". " +kindOfProduct.get(i));
        }
        System.out.println(".........");
    }
    public void showProductByKindOf(String kindOfProductToShow) {
        for(Product product : productList) {
            if(product.getKindOf().contains(kindOfProductToShow)) {
                System.out.println(product);
            }
        }
    }
    public void showProductByName(String nameProductToShow) {
        for(Product product : productList) {
            if(product.getKindOf().contains(nameProductToShow)) {
                System.out.println(product);
            }
        }
    }
    @Override
    public int findById(String id) {
        for (int i=0;i<productList.size();i++) {
            if(productList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void writeProductToFile(List<Product> productList,String path) {
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

    public List<Product> readProductFromFile(String path) {
        List<Product> readProductList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readProductList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return readProductList;
    }

    public void sortByProductName() {
        ProductNameComparator p = new ProductNameComparator();
        Collections.sort(productList,p);
        showAll();
    }
    public void sortByProductPrice() {
        ProductPriceComparator p = new ProductPriceComparator();
        Collections.sort(productList,p);
        showAll();
    }
}
