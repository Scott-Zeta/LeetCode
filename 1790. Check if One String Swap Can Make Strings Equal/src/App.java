import java.util.HashMap;

public class App {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Character> table = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (table.isEmpty()) {
                    table.put(c1, c2);
                } else {
                    if (table.get(c2) != null && table.get(c2) == c1) {
                        table.remove(c2);
                        count++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return table.isEmpty() && count <= 1;
    }

    public boolean easierAreAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int swaps = 0;
        char swapS1 = '-', swapS2 = '-';

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if ((swaps > 0 && swapS1 != s2.charAt(i)) || (swaps > 0 && swapS2 != s1.charAt(i)))
                    return false;
                swapS1 = s1.charAt(i);
                swapS2 = s2.charAt(i);
                swaps++;
            }
            if (swaps > 2)
                return false;
        }
        if (swaps < 2)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }
}
