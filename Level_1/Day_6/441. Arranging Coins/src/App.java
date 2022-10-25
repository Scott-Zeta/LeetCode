public class App {
    public static int arrangeCoins(int n) {
        int count = 1;
        while (n >= 0) {
            n = n - count;
            count++;
        }
        return count - 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(arrangeCoins(11));
        System.out.println("Hello, World!");
    }
}
