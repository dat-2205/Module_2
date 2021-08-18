import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        for (Integer i: stack) {
            System.out.println(i);
        }
        System.out.println("===================================");

        Stack<Integer> newStack = new Stack<>();
        int size = stack.size();
        for(int i = 0 ; i < size; i++) {
            newStack.push(stack.pop());
        }
        for (Integer i: newStack) {
            System.out.println(i);
        }

        System.out.println("================================");
        String codegym = "Codegym";
        Stack<Character> wStack = new Stack<>();
        for(int i=0;i<codegym.length();i++) {
            wStack.push(codegym.charAt(i));
        }
        Stack<Character> mWord = new Stack<>();
        int size2 = wStack.size();
        for(int i=0;i<size2;i++) {
            mWord.push(wStack.pop());
        }
        String newString = "";
        for(Character i:mWord) {
            newString += i;
        }
        System.out.println(newString);
    }
}
