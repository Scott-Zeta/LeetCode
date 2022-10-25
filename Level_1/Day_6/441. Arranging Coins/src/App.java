public class App {
    public static int arrangeCoins(int n) {
        int count = 1;
        while (n >= 0) {
            n = n - count;
            count++;
        }
        return count - 2;
    }

    public int binaryArrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;
        while (left <= right) {
          k = left + (right - left) / 2;
          curr = k * (k + 1) / 2;
    
          if (curr == n) return (int)k;
    
          if (n < curr) {
            right = k - 1;
          } else {
            left = k + 1;
          }
        }
        return (int)right;
      }

      public int MathArrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
      }

    public static void main(String[] args) throws Exception {
        System.out.println(arrangeCoins(11));
        System.out.println("Hello, World!");
    }
}
