public class App {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left);

        while (left <= right) {
            mid = left + (right - left);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
