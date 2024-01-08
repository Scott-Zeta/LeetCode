import java.util.Comparator;
import java.util.PriorityQueue;

public class App {

    public int lastStoneWeight(int[] stones) {
        // heap solution Nlogn
        //!!!! reverse order! or it will from small to large
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            // heap poll will return null if empty,
            // remove will throw exception if empty
            int stone1 = heap.poll();
            int stone2 = heap.poll();

            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
