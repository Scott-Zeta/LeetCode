public class App {

    public static void moveZeroes(int[] nums) {
        int zeroNum = 0;
        int zeropointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (zeropointer < nums.length) {
                while (zeropointer < (nums.length - 1) && nums[zeropointer] == 0) {
                    zeroNum++;
                    zeropointer++;
                }
                nums[i] = nums[i + zeroNum];
            } else {
                nums[i] = 0;
            }
            zeropointer++;
            System.out.print(nums[i] + ",");
        }
    }

    public void moveZeroesBetter(int[] nums) {
        // int[] nums = {0,1,0,3,12};
        int movezero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[movezero];
                nums[movezero] = nums[i];
                nums[i] = temp;
                movezero++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums = { 0 };// length 7
        moveZeroes(nums);
        System.out.println("Hello, World!");
    }
}
