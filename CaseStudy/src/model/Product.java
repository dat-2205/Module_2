package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String productName;
    private String productInformation;
    private double price;
    private String kindOf;
    private int inStock;

    public Product() {
    }

    public Product(String id, String productName, String productInformation, double price, String kindOf,int inStock) {
        this.id = id;
        this.productName = productName;
        this.productInformation = productInformation;
        this.price = price;
        this.kindOf = kindOf;
        this.inStock = inStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return  " + Id sản phẩm:  " + id +
                " | Tên sản phẩm: " + productName  +
                " |  Mô tả:  " + productInformation +
                " | Giá: " + price +
                " |  Danh mục: " + kindOf +
                " | Số lượng trong kho: " + inStock;
    }
}
