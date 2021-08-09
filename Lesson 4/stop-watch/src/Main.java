import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Watch w = new Watch();
        System.out.println("Enter '1' to start watch!");
        int start = sc.nextInt();
        if(start == 1){
            w.start();
            System.out.println("Now is: " + java.time.LocalTime.now());
        }
        System.out.println("Enter '0' to stop watch!");
        int stop = sc.nextInt();
        if(stop == 0) {
            w.stop();
            System.out.println("Now is: " + java.time.LocalTime.now());
            System.out.print(w.getElapsedTime());
        }

    }
}
