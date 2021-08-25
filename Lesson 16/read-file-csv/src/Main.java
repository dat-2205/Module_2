import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile rd = new ReadAndWriteFile();
        List<Country> countries = rd.readFile("country.txt");
        for(Country i : countries) {
            System.out.println(i);
        }
    }
}
