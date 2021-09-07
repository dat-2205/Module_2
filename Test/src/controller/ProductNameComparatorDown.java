package controller;

import model.Product;

import java.util.Comparator;

public class ProductNameComparatorDown implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getProductName().compareTo(o1.getProductName());
    }
}
