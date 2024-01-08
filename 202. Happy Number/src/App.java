public class App {
    public static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);

        while (fast != 1 && slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(isHappy(18));
    }
}
