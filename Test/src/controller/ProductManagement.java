package controller;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManagement {
    private List<Product> productList;

    public ProductManagement(List<Product> productList) {
        this.productList = productList;
    }

    public ProductManagement() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void update(int index, Product product) {
        productList.add(index,product);
    }

    public void showProduct(int begin, int end) {
        for(int i=begin;i<end;i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void showAll() {
        for(Product p: productList) {
            System.out.println(p);
        }
    }

    public void delete(int index) {
        productList.remove(index);
    }

    public int findByID(String id) {
        for(int i=0;i<productList.size();i++) {
            if(productList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void writeToFile(List<Product> productList,String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bfw = new BufferedWriter(fileWriter);
            for(Product p: productList) {
                bfw.write(p.toString()+"\n");
            }
            bfw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readFromFile(String path) {
        List<Product> readProductList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] object = line.split(",");
                String id = object[0];
                String productName = object[1];
                double price = Double.parseDouble(object[2]);
                int quantity = Integer.parseInt(object[3]);
                String information = object[4];
                Product product = new Product(id,productName,price,quantity,information);
                readProductList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readProductList;
    }

    public void sortByPrice() {
        ProductPriceComparator p = new ProductPriceComparator();
        Collections.sort(productList,p);
        showAll();
    }
    public void sortByProductName() {
        ProductNameComparator p = new ProductNameComparator();
        Collections.sort(productList,p);
        showAll();
    }
    public void sortByProductNameDown() {
        ProductNameComparatorDown p = new ProductNameComparatorDown();
        Collections.sort(productList,p);
        showAll();
    }
}
