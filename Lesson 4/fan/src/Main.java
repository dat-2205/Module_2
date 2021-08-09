import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        createFan(fan1,"Fan1");
        Fan fan2 = new Fan();
        createFan(fan2,"Fan2");
    }
    public static void createFan(Fan fan,String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is "+ name + " on? ");
        boolean status = sc.nextBoolean();
        fan.setStatus(status);
        System.out.println("Enter "+ name + " color: ");
        String color = sc.next();
        fan.setColor(color);
        int speed;
        do {
            System.out.println("Enter " + name + " speed: ");
            speed = sc.nextInt();
            fan.setSpeed(speed);
        }while(speed<1 || speed>3);
        System.out.println("Enter "+ name + " radius: ");
        double radius = sc.nextDouble();
        fan.setRadius(radius);
        System.out.println(fan.toString());
    }
}
