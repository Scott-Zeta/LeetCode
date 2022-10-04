import java.util.HashMap;

public class App {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = getMap(order);
        for (int i = 0; i < words.length; i++) {
            
        }
        return false;
    }

    public HashMap<Character, Integer> getMap(String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        return orderMap;
    }

    public boolean compareWords(String word1, String word2, HashMap<Character, Integer> orderMap) {
        int m = word1.length();
        int n = word2.length();
        int length = 0;
        if (m < n) {
            length = m;
        } else {
            length = n;
        }
        for (int i = 0; i < length; i++) {
            int c1 = orderMap.get(word1.charAt(i));
            int c2 = orderMap.get(word2.charAt(i));
            if (c1 > c2) {
                return false;
            }
        }
        if (m > n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
