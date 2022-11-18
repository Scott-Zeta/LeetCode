import java.util.Arrays;

public class App {

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            s1Map[index]++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                System.out.print(s2.charAt(i + j));
                int index = s2.charAt(i + j) - 'a';
                s2Map[index]++;
            }
            System.out.println();
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(checkInclusion("ab", "eidbaoo"));
        System.out.println("Hello, World!");
    }
}
