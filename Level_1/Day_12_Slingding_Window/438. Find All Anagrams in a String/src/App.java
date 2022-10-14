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

    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
