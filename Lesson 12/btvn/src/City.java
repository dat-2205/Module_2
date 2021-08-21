import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class City {
    private List<HouseHold> city;

    public City() {
        city = new ArrayList<HouseHold>();
    }
    public void addHouseHold(Scanner sc) {
        HouseHold houseHold = getHouseHoldInfor(sc);
        city.add(houseHold);
    }

    private HouseHold getHouseHoldInfor(Scanner sc) {
        List<Person> persons = new ArrayList<>();
        System.out.println("Nhap so thanh vien trong nha: ");
        int number = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<number;i++) {
            getPersonInfor(sc, persons, i);
        }
        System.out.println("Nhap dia chi cua ho dan: ");
        String address = sc.nextLine();
        HouseHold houseHold = new HouseHold(number,address,persons);
        return houseHold;
    }
    public int size() {
        return city.size();
    }

    private void getPersonInfor(Scanner sc, List<Person> persons, int i) {
        System.out.println("Nhap ten nguoi thu " + (i +1) + ": ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi nguoi thu " + (i +1) + ": ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap nghe nghiep  nguoi thu " + (i +1) + ": ");
        String job = sc.nextLine();
        Person person = new Person(name,age,job);
        persons.add(person);
    }

    public void refactor(Scanner sc) {
        System.out.println("Nhap dia chi nha can tim: ");
        String address = sc.nextLine();
        boolean isExist = false;
        for(int i=0;i<city.size();i++) {
            if(city.get(i).getAddress().equals(address)) {
                HouseHold newHouseHold = getHouseHoldInfor(sc);
                city.set(i,newHouseHold);
                System.out.println("Sua thanh cong!");
                isExist = true;
                break;
            }
        }
        if(!isExist) {
            System.out.println("Khong co dia chi nay!!!");
        }
    }
    public void delete(int index) {
        city.remove(index);
        System.out.println("Xoa thanh cong!");
    }
    public void findElderly() {
        for(HouseHold i:city) {
            for(int j=0;j<i.getPersonNumber();j++) {
                if(i.getPersons().get(j).getAge()>=80) {
                    System.out.println(i);
                }
            }
        }
    }
    public void show() {
        for (HouseHold i: city) {
//            System.out.println("person number: " + i.getPersonNumber() + ", address: " + i.getAddress() + ", person infor:  " + i.getPersons());
            System.out.println(i);
        }
    }
}
