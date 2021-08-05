import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            checkIsPrime(getNumber());
            checkAnother();

    }
    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        return num;
    }
    public static void checkIsPrime(int num) {
        boolean isPrime = false;
        if (num < 2){
            System.out.println(num + " is not a prime");
        }else{
            for(int i=2;i<num;i++){
                if(num%i==0){
                    isPrime = false;
                    break;
                }else{
                    isPrime = true;
                }
            }
            if(isPrime){
                System.out.printf("%d is a prime!",num);
            }else{
                System.out.printf("%d is not a prime!",num);
            }
        }

    }
    public static void checkAnother() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Read another number? Y/N?");
        char response = sc.next().charAt(0);
        switch (response) {
            case 'y':
                checkIsPrime(getNumber());
                checkAnother();
                break;
            case 'n':
                return;
            default:
                checkAnother();
        }
    }
}
