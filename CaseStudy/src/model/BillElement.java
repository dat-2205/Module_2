package model;

public class BillElement {
    private Product product;
    private int quantity;

    public BillElement(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  " + Id sản phẩm:  " + product.getId() +
                " | Tên sản phẩm: " + product.getProductName()  +
                " |  Mô tả:  " + product.getProductInformation() +
                " | Giá: " + product.getPrice() +
                " |  Danh mục: " + product.getKindOf() + "\n" +
                "  -Số lượng: " + quantity;
    }
}
