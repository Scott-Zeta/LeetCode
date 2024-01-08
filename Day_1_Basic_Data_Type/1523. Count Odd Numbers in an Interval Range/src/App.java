public class App {
    public static int countOdds(int low, int high) {
        int count = 0;
        if (low == high) {
            if (low % 2 != 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (low % 2 == 0) {
            low++;
        }
        for (int i = low; i <= high; i = i + 2) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(countOdds(0, 1));
    }
}
