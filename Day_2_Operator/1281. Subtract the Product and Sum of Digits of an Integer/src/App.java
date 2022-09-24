public class App {

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            System.out.println(digit);
            sum += digit;
            product *= digit;
            System.out.println(sum);
            System.out.println(product);
        }
        return product - sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(subtractProductAndSum(4421));
    }
}
