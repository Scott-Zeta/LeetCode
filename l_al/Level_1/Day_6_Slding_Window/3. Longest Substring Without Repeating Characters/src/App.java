public class App {
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int left = 0;
        int right = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            int index = c;
            map[index]++;
            if (map[index] == 1) {
                int distance = right - left + 1;
                max = Math.max(distance, max);
                // System.out.println("max: " + max);
            }
            while (map[index] > 1) {
                int leftIndex = s.charAt(left);
                map[leftIndex]--;
                left++;
            }
            right++;
        }
        // System.out.println("left:" + left);
        // System.out.println("right:" + right);
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println("Hello, World!");
    }
}
