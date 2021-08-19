import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int choice;
        do{
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phầm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Hiển thị sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm");
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            menu(choice,productManager,sc);
        }while(choice!=0);

    }
    public static void add(ProductManager productManager, Scanner sc) {
        System.out.println("Nhap id san pham: ");
        String id = sc.nextLine();
        System.out.println("Nhap name san pham: ");
        String name = sc.nextLine();
        System.out.println("Nhap price san pham: ");
        int price = sc.nextInt();
        Product product = new Product(id,name,price);
        productManager.addProduct(product);
    }
    public static void refactor(ProductManager productManager,String id,Scanner sc) {
        boolean isExist = isExist(productManager,id);
        if(isExist) {
            System.out.println("Nhap name san pham: ");
            String name = sc.nextLine();
            System.out.println("Nhap price san pham: ");
            int price = sc.nextInt();
            Product product = new Product(id,name,price);
            productManager.refactorProduct(id,product);
        }else {
            System.out.println("Id khong ton tai");
        }
    }
    public static void delete(ProductManager productManager, String id) {
        boolean isExist = isExist(productManager, id);
        if(isExist) {
            productManager.removeProduct(id);
        }else {
            System.out.println("Id khong ton tai");
        }
    }
    private static boolean isExist(ProductManager productManager, String id) {
        boolean isExist = false;
        for(Product i : productManager.getProducts()) {
            if(i.getId().equals(id)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    public static void menu(int choice,ProductManager p, Scanner sc) {
        switch (choice) {
            case 1:
                sc.nextLine();
                add(p,sc);
                break;
            case 2:
                sc.nextLine();
                System.out.println("Nhap id: ");
                String id = sc.nextLine();
                refactor(p,id,sc);
                break;
            case 3:
                sc.nextLine();
                System.out.println("Nhap id: ");
                String deleteId = sc.nextLine();
                delete(p,deleteId);
                break;
            case 4:
                p.showProducts();
                break;
            case 5:
                sc.nextLine();
                System.out.println("Nhap ten : ");
                String name = sc.nextLine();
                p.searchProduct(name);
                break;
            case 6:
                Collections.sort(p.getProducts());
                p.showProducts();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }
    }
}
