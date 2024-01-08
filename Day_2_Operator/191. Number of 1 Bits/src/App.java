public class App {

    public static int hammingWeight(int n) {
        int count = count(n, 0);
        return count;
    }

    public static int count(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        if (n % 10 != 0) {
            sum++;
        }
        return count(n / 10, sum);
    }

    public int hammingWeightAnwser(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1; //shift bits
        }
        return bits;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(hammingWeight(00000000000000000000001011));
    }
}
