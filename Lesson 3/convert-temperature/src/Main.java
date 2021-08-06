import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice ;
        Scanner sc = new Scanner(System.in);
        do {System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit.");
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter a Fahrenheit: ");
                    double f = sc.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fToC(f));
                    break;
                case 2:
                    System.out.print("Enter a Celsius: ");
                    double c = sc.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + cToF(c));
                    break;
                case 0:
                    System.exit(0);
            }
        }while(choice!=0);

    }
    public static double cToF(double c) {
        double f = (9.0/5)*c + 32;
        return f;
    }
    public static double fToC(double f) {
        double c = (5.0 / 9) * (f - 32);
        return c;
    }
}
