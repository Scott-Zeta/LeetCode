import java.util.HashMap;
import java.util.Map;

public class App {
    public static String toIndex(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!indexMap.containsKey(s.charAt(i))) {
                indexMap.put(s.charAt(i), i);
            }
            sb.append(indexMap.get(s.charAt(i)) + ",");
        }
        return sb.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        System.out.println(toIndex(s));
        System.out.println(toIndex(t));
        return toIndex(s).equals(toIndex(t));
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva",
                                        "abcdefghijklmnopqrstuvwxyzck"));
    }
}
