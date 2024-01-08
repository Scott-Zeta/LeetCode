import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class App {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;

        // since sometimes need to skip the copy array, queue can not work in here

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        for (int p = 0; p < m + n; p++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }

    // three pointer method easier to understand from end to start, may also can use
    // stack?
    public void ThreePointermerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int length = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[length] = nums1[i--];
            } else {
                nums1[length] = nums2[j--];
            }
            length--;
        }

        while (j >= 0 && length >= 0) {
            nums1[length--] = nums2[j--];
        }
    }

    public void stackMerge(int[] nums1, int m, int[] nums2, int n) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            s.push(nums2[i]);
        }
        int pointer = m - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (!s.isEmpty()) {
                if (pointer >= 0 && nums1[pointer] > s.peek()) {
                    nums1[i] = nums1[pointer--];
                } else {
                    nums1[i] = s.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);

        System.out.println("Hello, World!");
    }
}
