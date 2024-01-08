public class App {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                // since array is decending, if p1 > p2
                // only way to move p1 try smaller next one
                p1++;
            } else {
                ans = Math.max(ans, p2 - p1);
                p2++;
                // find if it is max distance, then next p2
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
