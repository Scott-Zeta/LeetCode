class Solution {
    // One-pass binary search
    // The idea is that we add some additional condition checks in the normal binary
    // search
    // in order to better narrow down the scope of the search.

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // first, normal binary search
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[start]) {
                // if mid is in left part array
                if (target >= nums[start] && target < nums[mid]) {
                    // if target also in left part array and less than mid
                    end = mid - 1;
                } else {
                    // will do a normal binary seach
                    start = mid + 1;
                }
            } else {
                // if mid drop in right part of array
                if (target <= nums[end] && target > nums[mid]) {
                    // also target in right part array
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
