public class App {
    public static void BruteRotate(int[] nums, int k) {
        // the question does not mean get the result
        // but recur the process of rotation
        // also need to consider if k > nums.length(rotated more than one cycle)
        k %= nums.length;

        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static void rotate(int[] nums, int k){
        
    }

    public static void main(String[] args) throws Exception {
        int[] num = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(num, 3);
        System.out.println("Hello, World!");
    }
}
