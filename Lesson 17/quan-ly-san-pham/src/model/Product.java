package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String company;
    private double price;
    private String information;

    public Product() {
    }

    public Product(String id, String name, String company, double price, String information) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.information = information;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                '}';
    }
}
