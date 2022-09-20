import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        Queue<Character> input = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            input.add(c1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            if (c1 == input.peek()) {
                input.poll();
            }
            if (input.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(isSubsequence("", ""));
    }
}
