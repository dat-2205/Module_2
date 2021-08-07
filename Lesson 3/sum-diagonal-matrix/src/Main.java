import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doAgain;
        do{
            double [][] array;
            int size = getSize();
            array = initArray(size);
            showArray(array,"Array");
            System.out.println("Sum diagonal:  " + sumDiagonal(array));
            System.out.println("Try again? Quit enter 'n'.");
            doAgain = sc.next();
        }while(!doAgain.equals("n"));
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
    public static double[][] initArray(int size) {
        Scanner scanner = new Scanner(System.in);
        double[][] array;
        array = new double[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
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
    public static double sumDiagonal(double[][] arr) {
        double sum = 0.0;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}
