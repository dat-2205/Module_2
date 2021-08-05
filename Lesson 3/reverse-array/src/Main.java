import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int []arr;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter arr size: ");
            size = sc.nextInt();
            if(size>20){
                System.out.print("Size must less than 20!!");
            }
        }while(size>20);
        arr = new int[size];
        for(int i=0;i<arr.length;i++){
            System.out.print("Phan tu thu " + (i+1) + " la: " );
            arr[i] = sc.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        for (int j = 0; j < arr.length / 2; j++) {
            int temp = arr[j];
            arr[j] = arr[size - 1 - j];
            arr[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}
