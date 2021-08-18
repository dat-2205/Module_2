import java.util.ArrayList;
import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(2,13);

        for (Object i: list.getElements()) {
            System.out.println(i);
        }
        System.out.println("============================");
        MyList<String> name = new MyList<>();
        name.add("Huy");
        name.add("NA");
        name.add("Duc");
        name.add("Dat");
        for (Object i: name.getElements()) {
            System.out.println(i);
        }
        System.out.println("================");
        System.out.println(name.contains("Mia"));
    }
}
