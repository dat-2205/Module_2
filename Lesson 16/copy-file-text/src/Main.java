import java.util.List;

public class Main {
    public static void main(String[] args) {
        copyFile1ToFile2("mytext.txt","mycopytext.txt");
    }

    private static void copyFile1ToFile2(String path1,  String path2) {
        CopyFileText readAndWriteFile = new CopyFileText();
        List<String> text = readAndWriteFile.readFile(path1);
        readAndWriteFile.writeFile(path2, text);
        int numberOfCharacter =  countCharacter(text);
        System.out.println(numberOfCharacter);
    }

    public static int countCharacter(List<String> text) {
        int count = 0;
        for(int i=0;i<text.size();i++) {
            for(int k=0;k< text.get(i).length();k++) {
                count ++;
            }
        }
        return count;
    }
}
