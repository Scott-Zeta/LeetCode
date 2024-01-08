public class App {

    public static int signFunc(int x) {
        if (x > 0)
            return 1;
        if (x < 0)
            return -1;
        return 0;
    }

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int n : nums) {
            if (n == 0)
                return 0;
            sign *= signFunc(n);
        }
        return sign;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
