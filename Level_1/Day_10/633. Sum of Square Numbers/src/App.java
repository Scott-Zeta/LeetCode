public class App {
    public static boolean judgeSquareSum(int c) {
        int mid = (int) Math.sqrt(c / 2);
        int left = mid;
        int right = mid;

        while (left >= 0) {
            int sum = left * left + right * right;
            if (sum > c) {
                left--;
            } else if (sum < c) {
                right++;
            } else {
                System.out.println(left);
                System.out.println(right);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(judgeSquareSum(3));
        System.out.println("Hello, World!");
    }
}
