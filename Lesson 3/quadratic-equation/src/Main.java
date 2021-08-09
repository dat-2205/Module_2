import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuadraticEquation math;
        double a;
        double b;
        double c;
        System.out.println("PT bac 2 dang: ax^2 + bx + c = 0");
        do{
            System.out.println("Enter a: ");
            a = sc.nextDouble();
            if(a==0){
                System.out.println("a is illegal");
            }
        }while(!checkArgument(a));
        System.out.println("Enter b: ");
        b = sc.nextDouble();
        System.out.println("Enter C: ");
        c = sc.nextDouble();
        math = new QuadraticEquation(a,b,c);
        System.out.println("Delta : "+math.getDiscriminant());
        math.displayRoots();
    }
    public static boolean checkArgument(double x) {
        boolean isInvalid = false;
        if(x!=0){
            isInvalid = true;
        }
        return isInvalid;
    }
}
