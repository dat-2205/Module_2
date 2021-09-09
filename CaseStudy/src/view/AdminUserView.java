package view;

import controller.UserManagement;
import model.Bill;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminUserView {
    private List<User> userList;
    private UserManagement userManagement;
    private Scanner sc = new Scanner(System.in);
    private final String PATH = "user.txt";

    public AdminUserView(List<User> userList) {
        this.userList = userList;
        userManagement = new UserManagement(this.userList);
    }

    public void run() {
        menu();
    }

    private void menu() {
        int choice;
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=0);
    }

    private void choiceHandle(int choice) {
        switch (choice) {
            case 1:{
                String id = "00" + (userManagement.getUserList().size()+1);
                User user = getNewUser(id);
                userManagement.add(user);
                userManagement.writeToFile(userList,PATH);
                break;
            }
            case 2:{
                System.out.println("Nhập id tài khoản muốn xoá: ");
                String id = sc.nextLine();
                userManagement.delete(id);
                userManagement.writeToFile(userList,PATH);
                break;
            }
            case 3:{
                System.out.println("Nhập  id tài khoản muốn sửa");
                String id = sc.nextLine();
                int index = userManagement.findById(id);
                if(index != -1) {
                    System.out.println("1. Sửa mật khẩu!");
                    System.out.println("2. Sửa tên người sử dụng.");
                    System.out.println("3. Sửa giới tính.");
                    System.out.println("4. Sửa ngày sinh");
                    System.out.println("5. Sửa email.");
                    System.out.println("6. Sửa quyền đăng nhập.");
                    System.out.print("Lựa chọn: ");
                    int updateUserChoice = sc.nextInt();
                    sc.nextLine();
                    updateUserChoiceHandle(index, updateUserChoice);
                    userManagement.writeToFile(userList,PATH);
                }else {
                    System.out.println("Không tìm thấy tài khoản");
                }
                break;
            }
            case 4: {
                System.out.println("Bạn muốn tìm theo: ");
                System.out.println("1. Theo id.");
                System.out.println("2. Theo username.");
                int findUserChoice = sc.nextInt();
                sc.nextLine();
                switch(findUserChoice) {
                    case 1:{
                        findByIdUserMenu();
                        break;
                    }
                    case 2:{
                        findByUserNameUserMenu();
                        break;
                    }
                }

                break;
            }
            case 5:{
                System.out.println("1. Xem tất cả khách hàng.");
                System.out.println("2. Xem tất cả quản trị viên.");
                System.out.println("3. Xem tất cả.");
                int showUserChoice = sc.nextInt();
                sc.nextLine();
                switch(showUserChoice) {
                    case 1:{
                        userManagement.showAllCustomer();
                        break;
                    }
                    case 2:{
                        userManagement.showAllAdmin();
                        break;
                    }
                    case 3:{
                        userManagement.showAll();
                    }
                }
                break;
            }
            case 6:{
                int month;
                do{
                    System.out.println("Nhập tháng muốn xem: ");
                    month  = sc.nextInt();
                    sc.nextLine();
                    if(month<=0 || month>12) {
                        System.err.println("Tháng không hợp lệ!");
                    }else {
                        break;
                    }
                }while(true);
                List<User> userCreateInMonth = getUserCreateInMonth(month);
                System.out.println("Khách hàng mới trong tháng " + month);
                for (User u: userCreateInMonth) {
                    System.out.println(u + "\n");
                }
                break;
            }
            case 7:{
                User max = new User();
                double highestUserPaid=0;
                for (User u: userList) {
                    double total=0;
                    for(Bill b : u.getPaid()) {
                        total += b.getTotalPayment();
                    }
                    if(total>highestUserPaid) {
                        highestUserPaid = total;
                        max = u;
                    }
                }
                System.out.println("Id tài khoản: " + max.getId());
                System.out.println("Tên tài khoản: " + max.getUsername());
                System.out.println("Tên khách hàng: " + max.getName());
                System.out.println("Tổng số tiền đã tiêu là: " + highestUserPaid);
                break;
            }
        }
    }

    private void updateUserChoiceHandle(int index, int updateUserChoice) {
        switch (updateUserChoice) {
            case 1:{
                String password =  getPassword();
                userManagement.getUserList().get(index).setPassword(password);
                System.out.println("Đã thay đổi mật khẩu!");
                break;
            }
            case 2:{
                String name =  getNameUser();
                userManagement.getUserList().get(index).setName(name);
                System.out.println("Đã thay đổi tên người sử dụng!");
                break;
            }
            case 3:{
                String sex =  getUserSex();
                userManagement.getUserList().get(index).setSex(sex);
                System.out.println("Đã thay đổi giới tính!");
                break;
            }
            case 4:{
                String birthday =  getUserBirthDay();
                userManagement.getUserList().get(index).setBirthday(birthday);
                System.out.println("Đã thay đổi ngày sinh!");
                break;
            }
            case 5:{
                String email =  getUserEmail();
                userManagement.getUserList().get(index).setEmail(email);
                System.out.println("Đã thay đổi email!");
                break;
            }
            case 6: {
                String role = getRoleUser();
                userManagement.getUserList().get(index).setRole(role);
                System.out.println("Đã thay đổi phân quyền!");
                break;
            }
        }
    }

    private void findByIdUserMenu() {
        System.out.println("Nhập id tài khoản muốn tìm: ");
        String id = sc.nextLine();
        int index = userManagement.findById(id);
        if(index!=-1) {
            System.out.println(userManagement.getUserList().get(index));
        }else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }
    private void findByUserNameUserMenu() {
        System.out.println("Nhập username tài khoản muốn tìm: ");
        String username = sc.nextLine();
        int index = userManagement.findByUserName(username);
        if(index!=-1) {
            System.out.println(userManagement.getUserList().get(index));
        }else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    private void displayMenu() {
        System.out.println("1. Tạo tài khoản mới.");
        System.out.println("2. Xoá tài khoản.");
        System.out.println("3. Sửa tài khoản.");
        System.out.println("4. Tìm kiếm tài khoản.");
        System.out.println("5. Xem tất cả tài khoản.");
        System.out.println("6. Xem tài khoản đã lập trong tháng.");
        System.out.println("7. Xem khách hàng đã tiêu nhiều nhất.");
        System.out.println("0. Đăng xuất.");
        System.out.println("Nhập lựa chọn: ");
    }

    public User getNewUser(String id) {
        int index;
        String username = getUserName();
        Matcher matcher;
        String password = getPassword();
        String role = getRoleUser();
        String name = getNameUser();
        String sex = getUserSex();
        String birthday = getUserBirthDay();
        String email = getUserEmail();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        User user = new User(id,username,password,role,name,sex,birthday,email,date);
        return user;
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

    private String getRoleUser() {
        String role;
        do{
            System.out.println("Nhập quyền sử dụng: ");
            role = sc.nextLine();
            if(!role.equals("admin") && !role.equals("customer")) {
                System.err.println("Bạn  phải nhập là admin hoặc customer!");
            }
        }while(!role.equals("admin") && !role.equals("customer"));
        return role;
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

    private String getUserName() {
        int index;
        String username;
        do {
            Matcher matcher;
            do{
                System.out.println("Nhập tên tài khoản: ");
                username = sc.nextLine();
                Pattern pattern = Pattern.compile("^\\w+$");
                 matcher = pattern.matcher(username);
                if(!matcher.matches()){
                    System.err.println("Tên tài khoản không hợp lệ!(không chứa ký tự đặc biệt, không chứa dấu cách)");
                }
            }while(!matcher.matches());

            index = userManagement.findByUserName(username);
            if(index>=0) {
                System.err.println("Tên tài khoản đã tồn tại!");
            }
        }while(index>=0);
        return username;
    }

    private List<User> getUserCreateInMonth(int month) {
        List<User> userInMonth = new ArrayList<>();
        for(User u : userList) {
            String m = u.getDateCreate().substring(3,5);
            int mi = Integer.parseInt(m);
            if(mi==month){
                userInMonth.add(u);
            }
        }
        return userInMonth;
    }
}
