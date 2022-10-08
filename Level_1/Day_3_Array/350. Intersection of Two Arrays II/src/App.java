import java.util.HashMap;

public class App {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = {};
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        for(int i = 0; i< nums2.length; i++){
            
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
