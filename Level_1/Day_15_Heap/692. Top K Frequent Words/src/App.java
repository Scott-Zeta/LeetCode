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

    public List<String> MinHeaptopKFrequent(String[] words, int k) {
        // the advantage of min heap is can still add new words,
        // only need to compare with top of min heap.
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        // minheap w2-w1, max heap w1-w2
        PriorityQueue<String> h = new PriorityQueue<>(
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2));

        for (String word : cnt.keySet()) {
            h.offer(word);
            if (h.size() > k) {
                // get the min words out if no enough space
                h.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!h.isEmpty()) {
            res.add(h.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
