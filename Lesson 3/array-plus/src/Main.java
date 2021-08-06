import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] A;
        int size1 = getSize();
        A = initArray(size1);
        showArray(A,"A");
        int[] B;
        int size2 = getSize();
        B = initArray(size2);
        showArray(B,"B");
        int[] C = new int[size1+size2];
        for(int i=0;i<A.length;i++){
            C[i] = A[i];
        }
        for(int i= A.length;i<A.length+B.length;i++){
            C[i] = B[i-(A.length)];
        }
        showArray(C,"C");

    }
    public static int getSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size: ");
        int size = sc.nextInt();
        return size;
    }
    public static int[] initArray(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        if (size > 20){
            System.out.println("Size should not exceed 20");
        }
        if(size<1){
            System.out.println("Size can't less than 1!");
        }
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }
    public static void showArray(int[] array,String name) {
        System.out.print("Property list " + name + " : ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.print("\n");
    }
}
