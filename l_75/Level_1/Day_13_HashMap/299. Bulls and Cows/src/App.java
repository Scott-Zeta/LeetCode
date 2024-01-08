import java.util.*;

public class App {
    public static String getHint(String secret, String guess) {
        HashMap<Integer, Integer> position = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int[] secretCount = new int[10];
        int bull = 0;
        int bullCowSum = 0;

        for (int i = 0; i < secret.length(); i++) {
            int c = secret.charAt(i) - '0';

            position.put(i, c);
            secretCount[c]++;
        }
        for (int i = 0; i < guess.length(); i++) {
            int c = guess.charAt(i) - '0';

            secretCount[c]--;
            if (secretCount[c] >= 0) {
                bullCowSum++;
            }

            if (c == position.get(i)) {
                bull++;
            }
        }
        result.append(bull + "A" + (bullCowSum - bull) + "B");
        result.append("A");
        result.append(bullCowSum - bull);
        result.append("B");
        return result.toString();
    }

    public String OnePassgetHint(String secret, String guess) {
        int[] h = new int[10];

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;
            } else {
                if (h[s - '0'] < 0)
                    cows++;
                if (h[g - '0'] > 0)
                    cows++;
                h[s - '0']++;
                h[g - '0']--;
                // well, the core is more like some kind of dynamic balance
                // similar to accounting
                // if we owe the secret, then when guess appear, we can ad a cow
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getHint("1123", "0111"));
        System.out.println("Hello, World!");
    }
}
