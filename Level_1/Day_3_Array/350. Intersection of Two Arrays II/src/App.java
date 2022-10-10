import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            int get = map.getOrDefault(n, 0);
            if (get > 0) {
                result.add(n);
                map.put(n, get - 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
