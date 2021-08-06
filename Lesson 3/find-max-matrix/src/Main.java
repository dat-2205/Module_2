import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double [][] array;
        int size1 = getSize();
        int size2 = getSize();
        array = initArray(size1,size2);
        showArray(array,"Array");
        double max = array[0][0];
        int indexX = 0;
        int indexY = 0;
        for (int i = 0; i< array.length;i++) {
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]>max){
                    max = array[i][j];
                    indexX = i;
                    indexY = j;
                }
            }
        }
        System.out.println("Max in matrix is: "+ max);
        System.out.printf("Index max is [%d][%d]",indexX,indexY);
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
}
