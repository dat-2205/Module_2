import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Kiem tra nam nhuan: ");
        int year = sc.nextInt();

        boolean isLeapYear = false ;

        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    isLeapYear = true;
                }
            }
            else{
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d is a leap year", year);
        }else{
            System.out.printf("%d is not a leap year!",year);
        }
    }
}
