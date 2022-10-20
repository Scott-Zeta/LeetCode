public class App {
    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guessWhat(mid, 428);
            if (result == 0) {
                return mid;
            } else if (result > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int guessWhat(int guess, int real) {
        if (guess > real) {
            return 1;
        } else if (guess < real) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(guessNumber(500));
        System.out.println("Hello, World!");
    }
}
