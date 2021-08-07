import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array;
        int size = getSize();
        array = initStringArray(size);
        showArray(array);
        countElementFound(array);
    }
    public static int getSize(){
        Scanner sc = new Scanner(System.in);
        int size;
        do{System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 30){
                System.out.println("Size should not exceed 30");
            }
            if(size<1){
                System.out.println("Size should not less than 1!");
            }
        }while(size<1 || size>30);
        return size;
    }
    public static String[] initStringArray(int size) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[size];
        for(int i=0;i<size;i++) {
            System.out.print("Enter a element " + (i+1) + " :");
            arr[i] = sc.next();
        }
        return arr;
    }
    public static void showArray(String[] array) {
        System.out.println("Property list  : ");
        for (int i = 0; i< array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
    public static void countElementFound(String[] array) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        String element;
        System.out.print("Enter element you want to find: ");
        element = sc.next();
        for(String i : array){
            if(i.equals(element)){
                count++;
            }
        }
        if(count==0){
            System.out.print("No result found!");
        }else{
            System.out.print("Element appears "+ count + " times." );
        }
    }
}
