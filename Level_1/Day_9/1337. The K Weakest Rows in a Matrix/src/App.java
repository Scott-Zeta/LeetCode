import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class App {
    public int[] kWeakestRows(int[][] mat, int k) {
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

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
