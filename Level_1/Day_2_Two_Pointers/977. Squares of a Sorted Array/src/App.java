public class App {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(nums[0] >= 0){
            //only include positive numbers
            for(int i= 0; i<n; i++){
                result[i] = nums[i]*nums[i];
            }
            return result;
        }else if(nums[n-1] <= 0){
            //only include negative numbers
            for(int i = 0; i<n;i++){
                result[i] = nums[n-1-i] * nums[n-1-i];
            }
            return result;
        }


        int negative = findZero(nums);
        int positive = negative + 1;

        return result;
    }

    public int findZero(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0 && nums[mid + 1] > 0) {
                return mid;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
