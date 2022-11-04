public class App {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if (nums[0] >= 0) {
            // only include positive numbers
            for (int i = 0; i < n; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        } else if (nums[n - 1] <= 0) {
            // only include negative numbers
            for (int i = 0; i < n; i++) {
                result[i] = nums[n - 1 - i] * nums[n - 1 - i];
            }
            return result;
        }

        int negative = findZero(nums);
        int positive = negative + 1;
        for (int i = 0; i < result.length; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if (negative >= 0) {
                left = -nums[negative];
            }
            if (positive < nums.length) {
                right = nums[positive];
            }
            if (left > right) {
                result[i] = right * right;
                positive++;
            } else {
                result[i] = left * left;
                negative--;
            }
        }
        return result;
    }

    public static int findZero(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0 && nums[mid + 1] >= 0) {
                return mid;
            } else if (nums[mid] < 0 && nums[mid + 1] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    // No, actually you don't need to write those binary search bullshit.
    // just put two pointer at the head and rear instead of zero point.
    // also less array index overflow risk

    public int[] RearsortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (-nums[left] > nums[right]) {
                result[n - 1 - i] = nums[left] * nums[left];
                left++;
            } else {
                result[n - 1 - i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] arr1 = { -9, -2, 1, 3, 10 };
        System.out.println(findZero(arr1));
        System.out.println("Hello, World!");
    }
}
