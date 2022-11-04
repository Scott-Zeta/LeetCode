public class App {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[k];
            k++;
            if (k >= n) {
                k = 0;
            }
        }
        nums = result;
        for(int i = 0; i<n; i++){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] num = {0,1,2,3,4,5};
        rotate(num,2);
        System.out.println("Hello, World!");
    }
}
