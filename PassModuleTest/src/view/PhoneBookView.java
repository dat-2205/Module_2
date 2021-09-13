package view;

import controller.ContactManagement;
import model.Contact;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookView {
    private ContactManagement phoneBook = new ContactManagement();
    public static Scanner sc = new Scanner (System.in);

    public void run() {
        int choice;
        do{
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            choiceHandle(choice);
        }while(choice!=8);
    }

    private void displayMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void choiceHandle(int choice) {
        switch(choice) {
            case 1: {
                phoneBook.showAll();
                System.out.println("1. Sửa");
                System.out.println("2. Xoá");
                System.out.println("3. Thêm liên hệ mới.");
                System.out.println("0. Thoát");
                int showChoice = sc.nextInt();
                sc.nextLine();
                showChoiceHandle(showChoice);
                break;
            }
            case 2: {
                if (getNewContact()) break;
                System.out.println("Đã thêm liên hệ!");
                break;
            }
            case 3: {
                updateContact();
                break;
            }
            case 4: {
                deleteContact();
                break;
            }
            case 5: {
                System.out.println("Nhập số điện thoại: ");
                String phoneNumber = sc.nextLine();
                phoneBook.findByPhoneNumberContain(phoneNumber);
                break;
            }
            case 6: {
                phoneBook.setPhoneList(phoneBook.readFromFile("contact.txt"));
                System.out.println("Đã đọc từ file!");
                break;
            }
            case 7: {
                phoneBook.writeToFile("contact.txt");
                System.out.println("Đã ghi ra file!");
                break;
            }
            case 8: {
                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void showChoiceHandle(int showChoice) {
        switch (showChoice) {
            case 1: {
                System.out.println("Nhập 1 số: ");
                int updateChoice = sc.nextInt();
                updateChoice = updateChoice - 1;
                sc.nextLine();
                if(updateChoice>-1 && updateChoice <phoneBook.getPhoneList().size()) {
                    uodateContactHandle(updateChoice);
                }
                else {
                    System.out.println("Số bạn nhập không nằm trong danh sách!");
                }
                break;
            }
            case 2: {
                System.out.println("Nhập 1 số: ");
                int deleteChoice = sc.nextInt();
                deleteChoice = deleteChoice - 1;
                sc.nextLine();
                if(deleteChoice>-1 && deleteChoice <phoneBook.getPhoneList().size()) {
                    phoneBook.delete(deleteChoice);
                }
                else {
                    System.out.println("Số bạn nhập không nằm trong danh sách!");
                }
                break;
            }
            case 3: {
                if(getNewContact()) break;
                System.out.println("Đã thêm liên hệ!");
                break;
            }
            case 0: {
                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void deleteContact() {
        String phoneNumber = getPhoneNumber();
        int index = phoneBook.findByPhoneNumber(phoneNumber);
        if(index<0) {
            System.out.println("Không tìm thấy liên hệ!");
        }else {
            phoneBook.delete(index);
            System.out.println("Đã xoá!");
        }
    }

    private void updateContact() {
        String phoneNumber = getPhoneNumber();
        int index = phoneBook.findByPhoneNumber(phoneNumber);
        if(index<0) {
            System.out.println("Không tìm thấy liên hệ!");
        }else {
            uodateContactHandle(index);
        }
    }

    private void uodateContactHandle(int index) {
        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa số điện thoại");
        System.out.println("3. Sửa email");
        System.out.println("4. Sửa facebook");
        System.out.println("5. Sửa giới tính");
        System.out.println("6. Sửa ngày sinh");
        System.out.println("7. Sửa mối quan hệ");
        System.out.println("0. Thoát");
        int updateChoice = sc.nextInt();
        sc.nextLine();
        updateChoiceHandle(index, updateChoice);
    }

    private boolean getNewContact() {
        String name = getName();
        String phoneNumber = getPhoneNumber();
        if(phoneBook.findByPhoneNumber(phoneNumber)!=-1) {
            System.out.println("Số điện thoại đã tồn tại!");
            return true;
        }
        String email = getEmail();
        String facebook = getFacebook();
        String gender = getGender();
        String birthday = getBirthday();
        String relationship = getRelationship();
        Contact contact = new Contact(name,phoneNumber,email,facebook,gender,birthday,relationship);
        phoneBook.add(contact);
        return false;
    }

    private void updateChoiceHandle(int index, int updateChoice) {
        switch (updateChoice) {
            case 1: {
                String name = getName();
                phoneBook.getPhoneList().get(index).setName(name);
                break;
            }
            case 2: {
                String newPhoneNumber = getPhoneNumber();
                phoneBook.getPhoneList().get(index).setPhoneNumber(newPhoneNumber);
                break;
            }
            case 3: {
                String email = getEmail();
                phoneBook.getPhoneList().get(index).setEmail(email);
                break;
            }
            case 4: {
                String facebook = getFacebook();
                phoneBook.getPhoneList().get(index).setFacebook(facebook);
                break;
            }
            case 5: {
                String gender = getGender();
                phoneBook.getPhoneList().get(index).setGender(gender);
                break;
            }
            case 6: {
                String birthday = getBirthday();
                phoneBook.getPhoneList().get(index).setName(birthday);
                break;
            }
            case 7: {
                String relationship = getRelationship();
                phoneBook.getPhoneList().get(index).setRelationship(relationship);
                break;
            }
            case 0: {
                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private String getRelationship() {
        System.out.println("Nhập mối quan hệ: ");
        System.out.println("1. Gia đình");
        System.out.println("2. Bạn bè");
        System.out.println("3. Công ty");
        int relationshipChoice = sc.nextInt();
        sc.nextLine();
        String relationship = "";
        switch(relationshipChoice) {
            case 1: {
                relationship = "family";
                break;
            }
            case 2: {
                relationship = "friend";
                break;
            }
            case 3: {
                relationship = "company";
                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        return relationship;
    }

    private String getBirthday() {
        String birthday = "";
        Matcher matcher;
        do{
            System.out.println("Nhập ngày sinh: ");
            birthday = sc.nextLine();
            Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
            matcher = pattern.matcher(birthday);
            if(!matcher.matches()) {
                System.out.println("Ngày sinh không hợp lệ!");
            }
        }while(!matcher.matches());
        return birthday;
    }

    private String getGender() {
        String gender = "";
        System.out.println("Nhập giới tính: ");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other...");
        int choice  = sc.nextInt();
        sc.nextLine();
        switch(choice) {
            case 1: {
                gender = "Male";
                break;
            }
            case 2: {
                gender = "Female";
                break;
            }
            case 3: {
                gender = "Other";
                break;
            }
            default: {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        return gender;
    }

    private String getFacebook() {
        String facebook = "";
        Matcher matcher;
        do{
            System.out.println("Nhập facebook: ");
            facebook = sc.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9. ]+$");
            matcher = pattern.matcher(facebook);
            if(!matcher.matches()) {
                System.out.println("Facebook không hợp lệ!");
            }
        }while(!matcher.matches());
        return facebook;
    }

    private String getEmail() {
        String email = "";
        Matcher matcher;
        do{
            System.out.println("Nhập email(VD: dat@gmail.com): ");
            email = sc.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9.]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
            matcher = pattern.matcher(email);
            if(!matcher.matches()) {
                System.out.println("Email không hợp lệ!");
            }
        }while(!matcher.matches());
        return email;
    }

    private String getPhoneNumber() {
        String phoneNumber = "";
        Matcher matcher;
        do{
            System.out.println("Nhập số điện thoại(VD: 035.12345678): ");
            phoneNumber = sc.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{3}\\.[0-9]{8}$");
            matcher = pattern.matcher(phoneNumber);
            if(!matcher.matches()) {
                System.out.println("SĐT không hợp lệ!");
            }

        }while(!matcher.matches());
        return phoneNumber;
    }

    private String getName() {
        String name = "";
        Matcher matcher;
        do{
            System.out.println("Nhập tên liên hệ mới: ");
            name = sc.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9 .]+$");
            matcher = pattern.matcher(name);
            if(!matcher.matches()) {
                System.out.println("Tên không hợp lệ!");
            }
        }while(!matcher.matches());
        return name;
    }
}
