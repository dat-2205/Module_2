import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        Scanner sc = new Scanner(System.in);

        System.out.println("a: ");
        double a = sc.nextDouble();

        System.out.println("b: ");
        double b = sc.nextDouble();

        System.out.println("c: ");
        double c = sc.nextDouble();

        if(a!=0) {
            double answer = (c-b)/a;
            System.out.println("PT co nghiem la: " + answer);
        }else {
            if(b==c) {
                System.out.println("PT co vo so nghiem");
            }else {
                System.out.println("Vo nghiem");
            }
        }
    }
}
