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

    public static int findZero(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0 && nums[mid + 1] >= 0) {
                return mid;
            }else if(nums[mid] < 0 && nums[mid + 1] < 0){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int[] arr1 = {-9,-2,1,3,10};
        System.out.println(findZero(arr1));
        System.out.println("Hello, World!");
    }
}
