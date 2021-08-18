import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String text = "What is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        TreeMap<Character,Integer> countCharacter = new TreeMap<>();
        for(int i=0;i<text.length();i++) {
            checkCharacter(countCharacter,Character.toLowerCase(text.charAt(i)));
        }
        show(countCharacter);
    }
    public static void checkCharacter(TreeMap<Character, Integer> map,Character c) {
        if(!map.containsKey(c)) {
            map.put(c,1);
        }else {
            int count = map.get(c);
            map.put(c,count+1);
        }
    }
    public static void show(TreeMap<Character, Integer> map) {
        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
