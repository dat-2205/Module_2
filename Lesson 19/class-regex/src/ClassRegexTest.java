import java.util.Scanner;

public class ClassRegexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValidate = false;
        ClassRegex classRegex = new ClassRegex();
        do{
            System.out.println("Nhap ten lop: ");
            String className = sc.nextLine();
            isValidate = classRegex.validate(className);
            System.out.println(isValidate);
        }while(!isValidate);
    }
}
