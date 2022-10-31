import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class App {
    public int[] LinearkWeakestRows(int[][] mat, int k) {
        // linear solution
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, List<Integer>> strengthMap = new HashMap<>();
        // strength as keyset,save line index in list
        for (int i = 0; i < m; i++) {
            int strength = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // civiliance detected, not need to iterate since sorted
                    break;
                }
                // count soilder strenth;
                strength++;
            }
            if (!strengthMap.containsKey(strength)) {
                strengthMap.put(strength, new ArrayList<>());
            }
            strengthMap.get(strength).add(i);
        }

        // sort the keyset
        List<Integer> sortedKeyset = new ArrayList<>(strengthMap.keySet());
        Collections.sort(sortedKeyset);

        // pull the request k samllest
        int[] result = new int[k];
        int i = 0;
        for (int key : sortedKeyset) {
            for (int index : strengthMap.get(key)) {
                result[i] = index;
                i++;
                if (i == k) {
                    break;
                }

            }
            if (i == k) {
                break;
            }
        }
        return result;
    }

    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        // binary and piroruity queue method
        int m = mat.length;
        int n = mat[0].length;

        // build pq with compartor first on strength then on index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            else
                return b[0] - a[0];
        });

        for (int i = 0; i < m; i++) {
            // use binary search to confirm the last 1 as strength
            int strength = binarySearch(mat[i]);
            // build a strength and index tupple for pq
            int[] entry = new int[] { strength, i };
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[1];
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
