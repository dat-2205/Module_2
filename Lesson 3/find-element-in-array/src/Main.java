import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a name’s student:");
        String name = sc.nextLine();
        do{
            boolean isExist = false;
            for(int i=0;i<students.length;i++){
                if(students[i].equals(name)){
                    System.out.print("Student "+ name + "is in class, position is: " + (i+1) +"\n");
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                System.out.print("Student" + name +  "is not in class!\n");
            }
            System.out.print("Enter a name’s student:");
            name = sc.nextLine();
        }while(!name.equals("0"));
    }
}
