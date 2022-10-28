public class App {
    public int specialArray(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }
            if (count > mid) {
                left = mid + 1;
            } else if (count < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
