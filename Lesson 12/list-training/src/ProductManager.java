import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager{
    private List<Product> products;
    private int index=0;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public ProductManager(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
        this.products.add(index,product);
        index++;
    }
    public void refactorProduct(String id, Product product) {
        for(Product i : products) {
            if(i.getId().equals(id)) {
                i.setId(product.getId());
                i.setName(product.getName());
                i.setPrice(product.getPrice());
                break;
            }
        }
    }
    public void removeProduct(String id) {
        for(int i=0; i<products.size();i++) {
            if(products.get(i).getId().equals(id)) {
               this.products.remove(i);
               index--;
                break;
            }
        }
    }
    public void showProducts() {
        for (Product i: products) {
            System.out.println(i);
        }
    }
    public void searchProduct(String name) {
        boolean isExist =false;
        for (Product i : products) {
            if(i.getName().equals(name)) {
                System.out.println(i);
                isExist = true;
                break;
            }
        }
        if(isExist==false) {
            System.out.println("Ten khong ton tai");
        }
    }
    public List<Product> getProducts() {
        return products;
    }
    public void sortProduct() {
        Collections.sort(products);
    }
}
