import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Country> readFile(String path) {
        List<Country> countries = new ArrayList<>();
        try{
            File file = new File(path);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = br.readLine()) != null) {
                String []country  = line.split(",");
                Country ct = new Country();
                ct.setId(country[0]);
                ct.setCode(country[1]);
                ct.setName(country[2]);
                countries.add(ct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
