import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float money;
        String kind1 = "";
        String kind2 = "";
        int VND = 1;
        int USD = 23000;
        int YEN = 1300;
        int NDT = 3400;
        float from = 0;
        float to = 0;

        System.out.println("Enter money: ");
        money  = sc.nextInt();

        System.out.print("Change from(VND,USD,YEN,NDT): ");
        kind1 = sc.next().toLowerCase(Locale.ROOT);
        switch(kind1){
            case "vnd":
                from = VND;
                break;
            case "usd":
                from = USD;
                break;
            case "yen":
                from = YEN;
                break;
            case "ndt":
                from = NDT;
                break;
            default:
                System.out.println("Chua doi duoc loai tien nay");
        }


        System.out.print("Change to(VND,USD,YEN,NDT): ");
        kind2 = sc.next().toLowerCase(Locale.ROOT);

        switch(kind2){
            case "vnd":
                to = VND;
                break;
            case "usd":
                to = USD;
                break;
            case "yen":
                to = YEN;
                break;
            case "ndt":
                to = NDT;
                break;
            default:
                System.out.println("Chua doi duoc loai tien nay");
        }
        double moneyChanged = (money*from)/to;
        System.out.printf("%.0f %s bằng %.2f %s",money,kind1,moneyChanged,kind2);
    }
}
