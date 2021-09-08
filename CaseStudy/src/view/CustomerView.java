package view;

import controller.BillManagement;
import controller.ProductManagement;
import controller.UserManagement;
import model.Bill;
import model.BillElement;
import model.Product;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CustomerView {
    private User user;
    private List<Product> productList;
    private ProductManagement productManagement;
    private Scanner sc = new Scanner(System.in);
    private final String PATH = "product.txt";

    public CustomerView(User user,List<Product> productList) {
        this.user = user;
        this.productList = productList;
        productManagement = new ProductManagement(productList);
    }

    public void run() {
        int choice;
        getProductFromFile();
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=0);
        productManagement.writeProductToFile(productList,PATH);
    }

    private void getProductFromFile() {
        List<Product> productListFromFile = productManagement.readProductFromFile(PATH);
        for(Product p: productListFromFile ) {
            productList.add(p);
        }
    }

    private void choiceHandle(int choice) {
        switch(choice) {
            case 1: {
                productManagement.showAll();
                wantToBuyQuetion();
                break;
            }
            case 2:{
                productManagement.showAllKindOfProduct();
                System.out.println("Bạn muốn hiển thị sản phẩm trong danh mục: ");
                String kindOfProductToShow = sc.nextLine();
                productManagement.showProductByKindOf(kindOfProductToShow);
                wantToBuyQuetion();
                break;
            }
            case 3:{
                System.out.println("Nhập tên sản phẩm muốn hiển thị:");
                String productNameToShow = sc.nextLine();
                productManagement.showProductByName(productNameToShow);
                wantToBuyQuetion();
                break;
            }
            case 4: {
                List<BillElement> cart = user.getCart();
                int cartChoice;
                do{
                    showUserCart(cart);
                    System.out.println("1. Xoá bỏ sản phẩm trong giỏ hàng.");
                    System.out.println("2. Sửa số lượng muốn mua.");
                    System.out.println("0. Quay lại.");
                    cartChoice = sc.nextInt();
                    sc.nextLine();
                    cartChoiceHanlde(cart, cartChoice);
                }while(cartChoice!=0);
                break;
            }
            case 5: {
                List<BillElement> billElements =  user.getCartValue();
                String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                double totalPayment=0;
                for(BillElement i : billElements) {
                    double price = i.getProduct().getPrice();
                    int quantity = i.getQuantity();
                    int index = productManagement.findById(i.getProduct().getId());
                    int inStock = productManagement.getProductList().get(index).getInStock();
                    productManagement.getProductList().get(index).setInStock(inStock-quantity);
                    totalPayment += price*quantity;
                }
                String user = this.user.getName();
                Bill bill = new Bill(billElements,date,totalPayment,user);
                System.out.println(".... Hoá đơn thanh toán....");
                System.out.println("   Tài khoản sử dụng: " + this.user.getUsername());
                System.out.println(bill);
                this.user.getPaid().add(bill);
                this.user.getCart().clear();
                System.out.println("Hàng sẽ được ship tới chỗ bạn!");
                break;
            }
            case 6: {
                System.out.println(user.getBillToString());
                break;
            }
        }
    }

    private void showUserCart(List<BillElement> cart) {
        System.out.println("Giỏ hàng: \n");
        for(BillElement i: cart){
            System.out.println(i.getProduct());
            System.out.println(" + Số lượng: " + i.getQuantity());
        }
    }

    private void wantToBuyQuetion() {
        System.out.println("Bạn muốn mua hàng: (y/n?)");
        String wantToBuy = sc.nextLine();
        buyProductHandle(wantToBuy);
    }

    private void cartChoiceHanlde(List<BillElement> cart, int cartChoice) {
        switch (cartChoice) {
            case 1:{
                System.out.println("Nhập id sản phẩm không muốn mua nữa: ");
                String id = sc.nextLine();
                if(deleteCartElemnt(cart, id)){
                    System.out.println("Đã xoá");
                }else {
                    System.out.println("Không tìm thấy sản phẩm này!");
                }
                break;
            }
            case 2:{
                System.out.println("Nhập sẩn phẩm muốn sửa: ");
                String id = sc.nextLine();
                int index = findIndexById(cart, id);
                if(index >=0) {
                    int newQuantity;
                    do{
                        System.out.println("Nhập số lượng mới: ");
                        newQuantity = sc.nextInt();
                        sc.nextLine();
                        if(newQuantity>0) {
                            cart.get(index).setQuantity(newQuantity);
                        }else {
                            System.out.println("Số lượng không hợp lệ!");
                        }
                    }while (newQuantity<=0);
                }else {
                    System.out.println("Không có sản phẩm này trong giỏ hàng!");
                }
                break;
            }
        }
    }

    private boolean deleteCartElemnt(List<BillElement> cart, String id) {
        for(BillElement i: cart) {
            if(i.getProduct().getId().equals(id)) {
                cart.remove(i);
                return true;
            }
        }
        return false;
    }

    public int findIndexById(List<BillElement> billElements,String id) {
        for(int i=0;i<billElements.size();i++) {
            if(billElements.get(i).getProduct().getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    private void buyProductHandle(String wantToBuy) {
        if(wantToBuy.equals("y")){
            String isContinue = "";
            do{
                System.out.println("Chọn sản phẩm muốn thêm vào giỏ hàng(Id): ");
                String id = sc.nextLine();
                int index = productManagement.findById(id);
                int inStock = productManagement.getProductList().get(index).getInStock();
                if(inStock ==0) {
                    System.out.println("Sản phẩm đã hết hàng!");
                }
                if(index<0) {
                    System.out.println("Không có sản phẩm này!");
                    break;
                }
                System.out.println("Nhập số lượng muốn mua: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                if(quantity>inStock) {
                    System.out.println("Sản phầm chỉ còn " + inStock + " sản phẩm!");
                }
                if(quantity ==0) {
                    break;
                }
                Product chosenProduct =  productManagement.getProductList().get(index);
                BillElement bl = duplicateBillElement(user.getCart(), chosenProduct);
                if(bl==null){
                    BillElement cart = new BillElement(chosenProduct,quantity);
                    user.getCart().add(cart);
                }else {
                    bl.setQuantity(bl.getQuantity()+quantity);
                }
                System.out.println("Đã thêm vào giỏ hàng!");
                System.out.println("Tiếp tục mua hàng?(Y/N)");
                isContinue = sc.nextLine();
                if(isContinue.toLowerCase(Locale.ROOT).equals("y")){
                    productManagement.showAll();
                }
            }while(isContinue.equals("y"));
        }else {
            System.out.println("Quay lại!");
        }
    }

    private void displayMenu() {
        System.out.println("Xin chào " + user.getName());
        System.out.println("....MENU MUA SẮM....");
        System.out.println("1. Xem danh sách tất cả sản phẩm.");
        System.out.println("2. Xem sản phẩm theo danh mục.");
        System.out.println("3. Tìm kiếm sản phẩm theo tên(gần đúng).");
        System.out.println("4. Giỏ hàng");
        System.out.println("5. Thanh toán sản phẩm trong giỏ hàng.");
        System.out.println("6. Xem sản phẩm đã mua.");
        System.out.println("0. Đăng xuất.");
        System.out.println("Nhập lựa chọn: ");
    }
    private BillElement duplicateBillElement(List<BillElement> billElements,Product product) {
        for(int i=0;i<billElements.size();i++) {
            if(billElements.get(i).getProduct().getId().equals(product.getId())){
                return billElements.get(i);
            }
        }
        return null;
    }
}
