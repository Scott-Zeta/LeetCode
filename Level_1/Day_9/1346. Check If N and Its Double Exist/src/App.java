import java.util.HashMap;

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

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
