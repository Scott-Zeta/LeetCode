import java.util.HashMap;
import java.util.HashSet;

public class App {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
                // map.get(arr[i] * 2) != i
                // prevent it is zero itself at same position
                return true;
            }
        }
        return false;
    }

    public boolean HashSetcheckIfExist(int[] arr) {
        //faster since set.contains O(logn)
        //Hashmap.contains O(n)
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            if (set.contains(n * 2) || (n % 2 == 0 && set.contains(n / 2))) {
                //contains its double, or its half when it is even number
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
