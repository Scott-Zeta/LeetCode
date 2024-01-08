public class App {
    // approach: find the rotated pivot, split array into two
    // parts, decide search which parts
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;

        if (n == 1)
            // special case the array only has one elements
            return this.nums[0] == target ? 0 : -1;
        // find the rotated pivot
        int rotate_index = find_rotate_index(0, n - 1);

        if(nums[rotate_index] == target)
            return rotate_index;
        //if array not rotated, seach as usual
        if(rotate_index ==0){
            return search(0, n-1);
        }
        if(target < nums[0]){
            //search right side
            return search(rotate_index, n-1);
        }else{
            return search(0, rotate_index);
        }
    }

    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right]) {
            // no rotate at all
            return 0;
        }

        while (left <= right) {
            // lock on pivot by binary seach
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                // pivot + 1 is start of original array
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        // common binary search
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
