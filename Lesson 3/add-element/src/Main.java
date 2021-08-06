import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.print("\n");
        System.out.print("Enter a element: ");
        int x = scanner.nextInt();
        System.out.print("Index: ");
        int index = scanner.nextInt();
        while(index<1 && index>array.length){
            System.out.println("Index illegal");
            System.out.print("index: ");
        }
        for(int j= array.length-1;j>=index;j--){
            array[j] = array[j-1];
        }
        array[index-1] = x;
        System.out.print("New property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}

