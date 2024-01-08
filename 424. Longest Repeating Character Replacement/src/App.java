import java.util.HashMap;

public class App {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int freq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < s.length()) {
            int c = s.charAt(right) - 'A';

            map.put(c, map.getOrDefault(c, 0) + 1);
            freq = Math.max(freq, map.get(c));

            if (right - left + 1 - freq <= k) {
                // core: k operations are applicable if the current window size minus the
                // frequency of the most frequent character is less or equal to k
                // there are less or equal k letter can be replaced
                max = Math.max(max, right - left + 1);
            } else {
                // more than k number diff letter, left must be gived up.
                int leftLetter = s.charAt(left) - 'A';
                map.put(leftLetter, map.get(leftLetter) - 1);
                left++;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
