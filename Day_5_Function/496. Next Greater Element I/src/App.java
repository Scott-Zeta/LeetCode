import java.util.HashMap;
import java.util.Stack;

public class App {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> cache = new Stack<>();
        HashMap<Integer, Integer> nextMax = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int c = nums2[i];
            if (cache.isEmpty() || cache.peek() > c) {
                cache.add(c);
            } else {
                while (!cache.isEmpty() && cache.peek() < c) {
                    nextMax.put(cache.pop(), c);
                }
                cache.add(c);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nextMax.get(nums1[i]) != null) {
                result[i] = nextMax.get(nums1[i]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] result = nextGreaterElement(nums1,nums2);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
