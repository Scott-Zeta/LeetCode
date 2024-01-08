public class App {
    public static int pivotIndex(int[] nums) {
        int pivot = -1;

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int l = 0; l < i; l++) {
                left += nums[l];
            }
            for (int r = i + 1; r < nums.length; r++) {
                right += nums[r];
            }
            if (left == right) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    public static int pivotIndex_advance(int[] nums) {
        int sum = 0;
        int leftsum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i])
                return i;
            leftsum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] nums = { -1, -1, 0, 1, 1, 0 };
        System.out.println(pivotIndex_advance(nums));
    }
}
