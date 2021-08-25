import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
     public List<String> readFile(String path) {
         List<String> text = new ArrayList<>();
         try {
             File file = new File(path);
             if(!file.exists()) {
                 throw new FileNotFoundException();
             }
             BufferedReader br = new BufferedReader(new FileReader(file));
             String line = "";
             while ((line = br.readLine()) != null) {
                 text.add(line+"");
             }
             br.close();
         } catch (IOException e) {
             System.err.println("File không tồn tại or nội dung có lỗi!");
         }
         return text;
     }
    public void writeFile(String filePath, List<String> text) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(int i=0;i<text.size();i++) {
                bufferedWriter.write(text.get(i)+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
