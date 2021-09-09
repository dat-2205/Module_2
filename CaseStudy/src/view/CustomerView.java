package view;


import controller.ProductManagement;
import model.Bill;
import model.BillElement;
import model.Product;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=0);
        productManagement.writeProductToFile(productList,PATH);
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
                productManagement.showHotProduct();
                break;
            }
            case 4:{
                System.out.println("Nhập tên sản phẩm muốn hiển thị:");
                String productNameToShow = sc.nextLine();
                productManagement.showProductByName(productNameToShow);
                wantToBuyQuetion();
                break;
            }
            case 5: {
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
            case 6: {
                List<BillElement> billElements =  user.getCartValue();
                String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                double totalPayment=0;
                for(BillElement i : billElements) {
                    double price = i.getProduct().getPrice();
                    int quantity = i.getQuantity();
                    int index = productManagement.findById(i.getProduct().getId());
                    changeSoldProduct(index,quantity);
//                    int inStock = productManagement.getProductList().get(index).getInStock();
//                    productManagement.getProductList().get(index).setInStock(inStock-quantity);
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
            case 7: {
                System.out.println(user.getBillToString());
                break;
            }
            case 8:{
                int updateAccountChoice;
                System.out.println("1. Sửa mật khẩu.");
                System.out.println("2. Sửa tên người dùng.");
                System.out.println("3. Sửa  ngày sinh.");
                System.out.println("4. Sửa email.");
                System.out.println("5. Sửa giới tính.");
                System.out.print("Lựa chọn.");
                updateAccountChoice = sc.nextInt();
                switch(updateAccountChoice) {
                    case 1: {
                        String password = getPassword();
                        user.setPassword(password);
                        break;
                    }
                    case 2:{
                        String name = getNameUser();
                        user.setName(name);
                        break;
                    }
                    case 3:{
                        String birthday = getUserBirthDay();
                        user.setBirthday(birthday);
                        break;
                    }
                    case 4:{
                        String email = getUserEmail();
                        user.setEmail(email);
                        break;
                    }
                    case 5:{
                        String sex = getUserSex();
                        user.setPassword(sex);
                        break;
                    }
                }
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


    private void cartChoiceHanlde(List<BillElement> cart, int cartChoice) {
        switch (cartChoice) {
            case 1:{
                System.out.println("Nhập id sản phẩm không muốn mua nữa: ");
                String id = sc.nextLine();
                int index = findIndexById(cart, id);
                if(index!=-1){
                    int quantity = -1*(user.getCart().get(index).getQuantity());
                    changeInStockProduct(user.getCart().get(index).getProduct(),quantity);
                    cart.remove(index);
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

    private void wantToBuyQuetion() {
        System.out.println("Bạn muốn mua hàng: (y/n?)");
        String wantToBuy = sc.nextLine();
        buyProductHandle(wantToBuy);
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
                int inStock = 0;
                try{
                     inStock = productManagement.getProductList().get(index).getInStock();
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Bạn nhập id không đúng!");
                    break;
                }

                if(inStock == 0) {
                    System.out.println("Sản phẩm đã hết hàng!");
                    break;
                }
                if(index<0) {
                    System.out.println("Không có sản phẩm này!");
                    break;
                }
                System.out.println("Nhập số lượng muốn mua: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                if(quantity <=0) {
                    System.out.println("Số lượng không đúng!");
                    break;
                }
                if(quantity>inStock) {
                    System.out.println("Sản phầm chỉ còn " + inStock + " sản phẩm!");
                }else {
                    changeInStockProduct(productList.get(index),quantity);
                    Product chosenProduct =  productManagement.getProductList().get(index);
                    BillElement bl = duplicateBillElement(user.getCart(), chosenProduct);
                    if(bl==null){
                        BillElement cart = new BillElement(chosenProduct,quantity);
                        user.getCart().add(cart);
                    }else {
                        bl.setQuantity(bl.getQuantity()+quantity);
                    }
                    System.out.println("Đã thêm vào giỏ hàng!");
                }
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
        System.out.println("3. Xem sản phẩm bán chạy");
        System.out.println("4. Tìm kiếm sản phẩm theo tên(gần đúng).");
        System.out.println("5. Giỏ hàng");
        System.out.println("6. Thanh toán sản phẩm trong giỏ hàng.");
        System.out.println("7. Xem sản phẩm đã mua.");
        System.out.println("8. Sửa thông tin cá nhân.");
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

    private String getUserEmail() {
        Matcher matcher;
        String email;
        do{
            System.out.println("Nhập email: ");
            email = sc.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
            matcher = pattern.matcher(email);
            if(!matcher.matches()) {
                System.err.println("Email không đúng định dạng!(abc@gmail.com.vn)");
            }
        }while(!matcher.matches());
        return email;
    }

    private String getUserBirthDay() {
        Matcher matcher ;
        String birthday;
        do{
            System.out.println("Nhập ngày sinh: ");
            birthday = sc.nextLine();
            Pattern pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");
            matcher = pattern.matcher(birthday);
            if(!matcher.matches()) {
                System.err.println("Ngày sinh không đúng định dạng!(dd/mm/yyyy)");;
            }
        }while(!matcher.matches());
        return birthday;
    }

    private String getUserSex() {
        String sex;
        do{
            System.out.println("Nhập giới tính: ");
            sex = sc.nextLine();
            if(!sex.equals("male") && !sex.equals("female")){
                System.err.println("Giới tính là male hoặc female");
            }
        }while(!sex.equals("male") && !sex.equals("female"));
        return sex;
    }

    private String getNameUser() {
        String name;
        do{
            System.out.println("Nhập tên người dùng: ");
            name = sc.nextLine();
            if(name.equals("")) {
                System.err.println("Bạn phải nhập tên!");
            }
        }while(name.equals(""));
        return name;
    }


    private String getPassword() {
        Matcher matcher;
        String password ;
        do{
            System.out.println("Nhập mật khẩu: ");
            password = sc.nextLine();
            Pattern pattern = Pattern.compile("^\\w{3,}");
            matcher = pattern.matcher(password);
        }while(!matcher.matches());
        return password;
    }

    public void changeSoldProduct(int index, int quantity) {
        int sold = productList.get(index).getSold();
        productManagement.getProductList().get(index).setSold(sold+quantity);
    }
    public void changeInStockProduct(Product product, int quantity){
        if(quantity>0) {
            int inStock = product.getInStock();
            product.setInStock(inStock - quantity);
        }
        else {
            int newQuantity = -quantity;
            product.setInStock(newQuantity);
        }
    }
}
