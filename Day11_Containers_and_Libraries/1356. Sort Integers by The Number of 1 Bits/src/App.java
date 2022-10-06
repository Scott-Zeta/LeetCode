import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int count = 0;
            while (n > 0) {
                if (n % 2 != 0) {
                    count++;
                }
                n /= 2;
            }
            System.out.println(count);
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());

            }
            map.get(count).add(arr[i]);
        }
        int[] result = new int[arr.length];
        int index = 0;
        for (List<Integer> temp : map.values()) {
            for (int i : temp) {
                result[index++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
