public class App {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2;
        while (right - left >= 0) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));
    }
}
