import java.util.*;

public class App {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] letterSet = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            letterSet[index]++;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] compareSet = new int[26];
            for (int j = 0; j < p.length(); j++) {
                int index = s.charAt(i + j) - 'a';
                compareSet[index]++;
            }
            if (Arrays.equals(letterSet, compareSet)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> BetterfindAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np)
            return new ArrayList<>();

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        List<Integer> output = new ArrayList<>();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            sCount[s.charAt(i) - 'a']++;
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                sCount[s.charAt(i - np) - 'a']--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }

        // only keep one iteration in sliding window
        return output;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
