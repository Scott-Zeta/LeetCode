import java.util.Stack;

public class App {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();
            } else {
                sStack.push(c);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            } else {
                tStack.push(c);
            }
        }

        return sStack.equals(tStack);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
