public class App {
    public static boolean judgeSquareSum(int c) {
        long mid = (long) Math.sqrt(c / 2);
        long left = mid;
        long right = mid;

        while (left >= 0) {
            long sum = left * left + right * right;
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
        System.out.println(judgeSquareSum(85));
        System.out.println("Hello, World!");
    }
}
