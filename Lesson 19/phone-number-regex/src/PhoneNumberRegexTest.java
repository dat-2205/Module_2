import java.util.Scanner;

public class PhoneNumberRegexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValidate = false;
        do{
            System.out.println("Nhap so dien thoai: ");
            String phoneNumber = sc.nextLine();
            isValidate = PhoneNumberRegex.isValidate(phoneNumber.trim());
            System.out.println(phoneNumber + " is " + isValidate);
        }while (!isValidate);
    }
}
