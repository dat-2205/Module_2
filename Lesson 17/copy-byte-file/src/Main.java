import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            copyFileByte("inputfile.txt","outputfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void copyFileByte(String inputPath, String outputPath) throws FileNotFoundException {
        try{
            File file = new File(inputPath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            InputStream is = new FileInputStream(file);
            OutputStream os = new FileOutputStream(outputPath);
            int length;
            byte[] bytes = new byte[1024];
            int count = 0;
            while((length = is.read(bytes))>0) {
                os.write(bytes,0,length);
                System.out.println(length);
            }
        }catch (Exception e) {
            System.err.println("Xay ra loi");
        }
    }
}
