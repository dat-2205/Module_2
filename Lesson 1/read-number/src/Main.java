import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        String tram = "";
        String chuc = "";
        String donvi = "";

        System.out.println("Enter a number: ");
        num = sc.nextInt();
        if(num>0){
            if(num<10) {
                switch (num){
                    case 1:
                        System.out.printf("one");
                        break;
                    case 2:
                        System.out.printf("two");
                        break;
                    case 3:
                        System.out.printf("three");
                        break;
                    case 4:
                        System.out.printf("four");
                        break;
                    case 5:
                        System.out.printf("five");
                        break;
                    case 6:
                        System.out.printf("six");
                        break;
                    case 7:
                        System.out.printf("seven");
                        break;
                    case 8:
                        System.out.printf("eight");
                    case 9:
                        System.out.printf("nine");

                }
            }
            else if(num<20){
                switch (num%10){
                    case 0:
                        System.out.printf("ten");
                    case 1:
                        System.out.printf("elevent");
                        break;
                    case 2:
                        System.out.printf("twelve");
                        break;
                    case 3:
                        System.out.printf("thirteen");
                        break;
                    case 4:
                        System.out.printf("fourteen");
                        break;
                    case 5:
                        System.out.printf("fifteen");
                        break;
                    case 6:
                        System.out.printf("sixteen");
                        break;
                    case 7:
                        System.out.printf("seventeen");
                        break;
                    case 8:
                        System.out.printf("eightteen");
                    case 9:
                        System.out.printf("nineteen");
                }
            }
            else if(num<100){
                switch ((num%100)/10){
                    case 2:
                        chuc = "twenty";
                        break;
                    case 3:
                        tram ="thirty";
                        break;
                    case 4:
                        tram ="fourty";
                        break;
                    case 5:
                        tram ="fifty";
                        break;
                    case 6:
                        tram ="sixty";
                        break;
                    case 7:
                        tram ="seventy";
                        break;
                    case 8:
                        tram ="eighty";
                    case 9:
                        tram ="ninety";

                }
                switch ((num%100)%10){
                    case 0:
                        donvi = "";
                    case 1:
                        donvi = "one";
                        break;
                    case 2:
                        donvi = "two";
                        break;
                    case 3:
                        donvi = "three";
                        break;
                    case 4:
                        donvi = "four";
                        break;
                    case 5:
                        donvi = "five";
                        break;
                    case 6:
                        donvi = "six";
                        break;
                    case 7:
                        donvi = "seven";
                        break;
                    case 8:
                        donvi = "eight";
                    case 9:
                        donvi = "nine";
                }
                System.out.printf("Number is: %s %s" , chuc, donvi);
            }
            else if(num<1000){
                switch (num/100){
                    case 0:
                        tram ="";
                        break;
                    case 1:
                        tram ="one";
                        break;
                    case 2:
                        tram = "two";
                        break;
                    case 3:
                        tram ="three";
                        break;
                    case 4:
                        tram ="four";
                        break;
                    case 5:
                        tram ="five";
                        break;
                    case 6:
                        tram ="six";
                        break;
                    case 7:
                        tram ="seven";
                        break;
                    case 8:
                        tram ="eight";
                    case 9:
                        tram ="nine";

                }
                switch ((num%100)/10){
                    case 0:
                        chuc = "";
                        break;
                    case 1:
                        switch ((num%100)%10){
                            case 0:
                                chuc = "";
                            case 1:
                                chuc ="and elevent";
                                break;
                            case 2:
                                chuc ="and twelve";
                                break;
                            case 3:
                                chuc ="and thirteen";
                                break;
                            case 4:
                                chuc ="and fourteen";
                                break;
                            case 5:
                                chuc ="and fifteen";
                                break;
                            case 6:
                                chuc ="and sixteen";
                                break;
                            case 7:
                                chuc ="and seventeen";
                                break;
                            case 8:
                                chuc ="and eightteen";
                            case 9:
                                chuc ="and nineteen";
                        }
                        break;
                    case 2:
                        chuc ="and twenty";
                        break;
                    case 3:
                        chuc ="and thirty";
                        break;
                    case 4:
                        chuc ="and fourty";
                        break;
                    case 5:
                        chuc ="and fifty";
                        break;
                    case 6:
                        chuc ="and sixty";
                        break;
                    case 7:
                        chuc ="and seventy";
                        break;
                    case 8:
                        chuc ="and eighty";
                        break;
                    case 9:
                        chuc ="and ninety";
                        break;

                }
                switch ((num%100)%10){
                    case 0:
                        donvi = "";
                        break;
                    case 1:
                        donvi = "one";
                        break;
                    case 2:
                        donvi = "two";
                        break;
                    case 3:
                        donvi = "three";
                        break;
                    case 4:
                        donvi = "four";
                        break;
                    case 5:
                        donvi = "five";
                        break;
                    case 6:
                        donvi = "six";
                        break;
                    case 7:
                        donvi = "seven";
                        break;
                    case 8:
                        donvi = "eight";
                    case 9:
                        donvi = "nine";
                }
                System.out.printf("Number is: %s hundred  %s %s" , tram , chuc, donvi);
            }
        }

    }
}
