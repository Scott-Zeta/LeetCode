import java.util.*;

public class App {
    class Word implements Comparable<Word> {
        private String word;
        private int count;
    
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    
        // define conpareTo with dictionary order
        public int compareTo(Word other) {
            if (this.count == other.count) {
                return this.word.compareTo(other.word);
            }
            return other.count - this.count;
        }
    }

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

    public List<String> MaxHeaptopKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<Word> candidates = new ArrayList<>();
        for (var entry : cnt.entrySet()) {
            candidates.add(new Word(entry.getKey(), entry.getValue()));
        }

        Queue<Word> h = new PriorityQueue<>(candidates);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(h.poll().word);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
