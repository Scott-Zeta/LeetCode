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
        result.append(bull + "A" + (bullCowSum-bull) + "B");
        result.append("A");
        result.append(bullCowSum-bull);
        result.append("B");
        return result.toString();
    }


    public static void main(String[] args) throws Exception {
        System.out.println(getHint("1123", "0111"));
        System.out.println("Hello, World!");
    }
}
