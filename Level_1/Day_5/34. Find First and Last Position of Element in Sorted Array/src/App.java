public class App {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        return result;
    }

    public static int findLeft(int[] nums, int target) {
        int leftMost = -1;
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right -left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                //??????
                leftMost = mid;
            }
            System.out.println("left: " +left);
            System.out.println("right: " + right);
            System.out.println("mid:" + mid);
        }
        return leftMost;
    }

    public static int findRight(int[] nums, int target) {
        int rightMost = -1;
        return rightMost;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,3,4,6,6,6,7,8};
        int[] result = searchRange(nums, 6);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println("Hello, World!"); 
    }
}
