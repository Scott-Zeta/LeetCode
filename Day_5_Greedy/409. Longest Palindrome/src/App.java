public class App {
    public static int longestPalindrome(String s) {
        int ans = 0;
        int[] countArr = new int[128]; // char table include all letters
        for (char c : s.toCharArray()) {
            countArr[c]++;
        }

        for (int v : countArr) {
            v = v / 2 * 2; // to even number, 1 to 0, 3 to 2
            ans += v;
        }
        if (ans < s.length()) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
