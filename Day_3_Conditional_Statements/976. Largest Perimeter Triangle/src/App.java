import java.util.Arrays;

public class App {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i + 2] < (nums[i] + nums[i + 1])) {
                return nums[i + 2] + nums[i] + nums[i + 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {2,1,1};
        System.out.println(largestPerimeter(nums));
    }
}
