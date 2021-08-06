import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array;
        int size = getSize();
        array = new int[size];
        array = initArray(size);
        showArray(array);
        System.out.println("Student pass: " + checkPassStudent(array));
    }
    public static int getSize(){
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
        return size;
    }
    public static int[] initArray(int size){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            do{
                System.out.print("Enter " + (i+1)+ " element: ");
                arr[i] = sc.nextInt();
            }while(!checkScore(arr[i]));
            System.out.print("\n");
        }
        return arr;
    }
    public static void showArray(int[] arr) {
        System.out.println("Student score list: ");
        for(int element:arr){
            System.out.print(element +  " ");
        }
        System.out.print("\n");
    }
    public static int checkPassStudent(int[] arr) {
        int count=0;
        for(int element : arr){
            if(element>=5 && element<=10){
                count++;
            }
        }
        return count;
    }
    public static boolean checkScore(int x) {
        boolean isInvalid = false;
        if(x<0 || x>10){
            System.out.print("Score is illegal, Enter again.\n");
            isInvalid = false;
        }else{
            isInvalid = true;
        }
        return isInvalid;
    }
}
