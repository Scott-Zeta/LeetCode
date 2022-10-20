public class App {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
        // if (target > nums[mid]) {
        //     return mid + 1;
        // }
        // return mid;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
