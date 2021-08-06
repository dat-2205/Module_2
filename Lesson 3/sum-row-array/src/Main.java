import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [][] array;
        int size1 = getSize();
        int size2 = getSize();
        array = initArray(size1,size2);
        showArray(array,"Array");
        System.out.print("Enter a Cols: ");
        int x = sc.nextInt();
        System.out.print("Sum cols: " + sumCol(array,x));
    }
    public static int getSize() {
        Scanner sc = new Scanner(System.in);
        int size;
        do{System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20){
                System.out.println("Size should not exceed 20");
            }
            if(size<1){
                System.out.println("Size can't less than 1!");
            }
        }while(size<1 || size>20);
        return size;
    }
    public static double[][] initArray(int size1,int size2) {
        Scanner scanner = new Scanner(System.in);
        double[][] array;
        array = new double[size1][size2];
        for(int i=0;i<size1;i++){
            for(int j=0;j<size2;j++){
                System.out.printf("Enter [%d][%d] position value: ",i,j);
                array[i][j] = scanner.nextDouble();
            }
            System.out.print("\n");
        }
        return array;
    }
    public static void showArray(double[][] array,String name) {
        System.out.print("Property list " + name + " : \n");
        for (int i = 0; i< array.length;i++) {
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static double sumCol(double[][] arr,  int x) {
        for(int i=0;i< arr.length;i++){
            if(x<0 || x> arr.length){
                System.out.print("Col is illegal");
                System.exit(0);
            }
        }
        double sum = 0.0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i][x];
        }
        return sum;
    }
}