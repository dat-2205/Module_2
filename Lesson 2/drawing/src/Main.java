import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(choice!=4){
            System.out.println("1. Print rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Chieu rong: " );
                    int height = sc.nextInt();
                    System.out.print("Chieu dai: ");
                    int width = sc.nextInt();

                    for(int i=0;i<height;i++){
                        for(int j=0;j<width;j++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.print("top-left, top-right, botton-left, botton-right?: ");
                    String squareTriangle = sc.next();
                    System.out.print("Nhap canh tam giac vuong: ");
                    int side = sc.nextInt();

                    switch(squareTriangle){
                        case "tl":
                            for(int i=0;i<side;i++){
                                for(int j=side;j>i;j--){
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case "tr":
                            for(int i=0;i<side;i++){
                                for(int k=0;k<i;k++){
                                    System.out.print("  ");
                                }
                                for(int j=side;j>i;j--){
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case "bl":
                            for(int i=1;i<=side;i++){
                                for(int j=0;j<i;j++){
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case "br":
                            for(int i=0;i<side;i++){
                                for(int k=(side-1);k>i;k--){
                                    System.out.print("  ");
                                }
                                for(int j=0;j<=i;j++){
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Nhap canh tam giac can: ");
                    int side1 = sc.nextInt();

                    for(int i=0;i<side1;i++){
                        for(int j=(side1-i);j>0;j--){
                            System.out.print(" ");
                        }
                        for(int k=0;k<=i;k++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4 :
                    System.exit(0);
                default:
                    System.out.println("No choice!");

            }
        }

    }
}
