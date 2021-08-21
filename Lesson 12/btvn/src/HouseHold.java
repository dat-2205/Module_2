import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseHold {
    private int personNumber;
    private String address;
    private List<Person> persons;

    public HouseHold() {
        persons = new ArrayList<Person>();
    }

    public HouseHold( int personNumber,String address, List<Person> persons) {
        this.personNumber = personNumber;
        this.address = address;
        this.persons = persons;
    }

    public int getPersonNumber() {
        return persons.size();
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "personNumber: " + personNumber +
                ", address: " + address + '\'' +
                ", persons: " + persons +
                '}';
    }
}
