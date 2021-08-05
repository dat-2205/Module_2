import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money;
        int month;
        double interestRate ;

        System.out.println("Enter money: ");
        money = sc.nextDouble();

        System.out.println("Enter month: ");
        month = sc.nextInt();

        System.out.println("Enter interest rate: ");
        interestRate = sc.nextDouble();

        double totalInterest = 0;
        for( int i=0;i<month;i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
