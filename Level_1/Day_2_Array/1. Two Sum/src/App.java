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
    }

    public int[] WithoutHashMaptwoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] + nums[j - i]) == target) {
                    return new int[] { j, j - i };
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
