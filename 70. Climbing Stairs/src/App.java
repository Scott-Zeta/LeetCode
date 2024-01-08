public class App {
    public int climbStairs(int n) {
        int[] result = list(n);
        return result[n];
    }

    public int[] list(int n) {
        int[] list = new int[n + 1];
        if (n >= 1) {
            list[1] = 1;
        }
        if (n >= 2) {
            list[2] = 2;
        }
        if (n >= 3) {
            for (int i = 3; i < list.length; i++) {
                list[i] = list[i - 1] + list[i - 2];
            }
        }
        return list;
    }

    public int climbStairsWithoutArray(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
