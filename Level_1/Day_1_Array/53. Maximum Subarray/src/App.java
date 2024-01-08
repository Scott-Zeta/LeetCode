public class App {
    public int maxSubArray(int[] nums) {
        // O(n) dynamic programing
        int currentSub = nums[0];
        int maxSub = nums[0];

        for (int i = 1; i < nums.length; i++) { // num[0] already recorded, start from 1
            int n = nums[i];
            currentSub = Math.max(n, currentSub + n); // test if n can make currentsub increase
            maxSub = Math.max(maxSub, currentSub); // compare with history
        }
        return maxSub;
    }

    public int bruteMaxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
