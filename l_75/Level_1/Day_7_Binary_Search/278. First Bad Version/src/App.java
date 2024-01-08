public class App {
    public static boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int check = left + (right - left) / 2;
            if (!isBadVersion(check)) {
                left = check + 1;
            } else {
                right = check;
            }
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
