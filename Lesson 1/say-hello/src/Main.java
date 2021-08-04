import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;

        System.out.println("Your Name: ");
        name = sc.nextLine();

        System.out.println("Hello " + name);
    }
}
