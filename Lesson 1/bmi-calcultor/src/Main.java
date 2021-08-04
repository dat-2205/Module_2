import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;

        System.out.println("Nhap can nang: ");
        weight = sc.nextDouble();

        System.out.println("Nhap nhieu cao: ");
        height = sc.nextDouble();

        bmi = weight/Math.pow(height,2);

        if(bmi<18.5){
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        }
        else if(bmi<25.0){
            System.out.printf("%-20.2f%s", bmi, "Normal");
        }
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
