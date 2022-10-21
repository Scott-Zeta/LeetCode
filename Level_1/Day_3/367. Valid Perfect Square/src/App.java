public class App {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (right >= left) {
            long mid = left + (right - left) / 2;
            if (num == mid * mid) {
                return true;
            }
            if (num > mid * mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(left);
            System.out.println(right);
            System.out.println("-----------");
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
