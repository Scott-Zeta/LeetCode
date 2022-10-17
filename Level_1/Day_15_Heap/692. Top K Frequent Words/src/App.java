import java.util.*;

public class App {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        List<String> keyStrings = new ArrayList<>(map.keySet());

        Collections.sort(keyStrings,
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        // if w1 equal to w2
        // return in dictionary order
        return keyStrings.subList(0, k);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
