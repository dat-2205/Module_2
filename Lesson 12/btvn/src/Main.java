import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        City c = new City();
        int choice;
        do{
            System.out.println("1. Them ho dan.");
            System.out.println("2. Sua thong tin ho dan.");
            System.out.println("3. Xoa ho dan.");
            System.out.println("4. Tim ho dan co nguoi mung tho.");
            System.out.println("0. Exit");
            System.out.println("Enter a choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            choiceHandle(sc, c, choice);
        }while(choice!=0);
    }

    private static void choiceHandle(Scanner sc, City c, int choice) {
        switch(choice) {
            case 1:
                {
                    c.addHouseHold(sc);
                    break;
                }
            case 2:
                {
                     c.refactor(sc);
                     break;
                }
            case 3:
                {
                    System.out.println("Nhap vi tri muon xoa: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= c.size()) System.out.println("Vi tri khong hop le!");
                    else c.delete(index);
                    break;
                }
            case 4:
                {
                    c.findElderly();
                    break;
                }
            case 0:
                System.exit(0);
        }
    }
}
