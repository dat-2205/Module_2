package controller;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
   private List<Product> productList = new ArrayList<>();

    public ProductManagement() {
    }

    public ProductManagement(List<Product> productList) {
        this.productList = productList;
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
    public void show() {
        for(Product i: productList) {
            System.out.println(i);
        }
    }
    public int search(String id) {
        int index = -1;
        for(int i=0;i<productList.size();i++) {
            if(productList.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }
    public void update(int index,Product product) {;
        productList.set(index,product);
    }
    public void delete(String id) {
        int index = search(id);
        if(index >-1) {
            productList.remove(index);
        }else {
            System.out.println("Khong co san pham nay");
        }
    }

}
