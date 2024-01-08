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

    // sliding window with one map array
    // hardly understand this

    public boolean checkInclusionOneMap(String s1, String s2) {
        int[] map = new int[128];
        for (char c : s1.toCharArray()) {
            map[c]++;
        }
        int count = s1.length();
        char[] chars = s2.toCharArray();
        int left = 0, right = 0;
        while (right < chars.length) {
            if (map[chars[right++]]-- > 0)
                count--;
            while (count == 0) {
                if (right - left == s1.length())
                    return true;
                if (++map[chars[left++]] > 0)
                    count++;
            }
        }
        return false;
    }

    // no new array,sliding window counter map
    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(checkInclusion("ab", "eidbaoo"));
        System.out.println("Hello, World!");
    }
}
