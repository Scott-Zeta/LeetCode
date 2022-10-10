import java.util.ArrayList;
import java.util.Arrays;
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
        int[] result = new int[nums2.length];
        int count = 0;
        for (int n : nums2) {
            int get = map.getOrDefault(n, 0);
            if (get > 0) {
                result[count++] = n;
                map.put(n, get - 1);
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
