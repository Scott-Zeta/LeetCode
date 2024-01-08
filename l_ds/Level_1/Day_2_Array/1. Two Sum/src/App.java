import java.util.HashMap;

public class App {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }//4-10ms

    public int[] WithoutHashMaptwoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] + nums[j - i]) == target) {
                    return new int[] { j, j - i };
                }
            }
        }
        return null;
    }//0-2ms
    //I don't understand why this similar brute force takes so short time

    public int[] BruteForcetwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }//114ms

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
