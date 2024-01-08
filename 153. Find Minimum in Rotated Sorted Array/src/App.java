public class App {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        
        if(nums[left] < nums[right] || nums.length == 1){
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(nums[mid]);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
