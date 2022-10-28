public class App {
    public int findKthPositive(int[] arr, int k) {
        // O(N) bruteforce
        if (k <= arr[0] - 1) {
            // if kth missing less then first number arr[0]
            return k;
        }
        // initial k when arr not start from 1
        k = k - (arr[0] - 1);

        for (int i = 0; i < arr.length - 1; i++) {
            // check how many number missing between each two elements
            int missingNum = arr[i + 1] - arr[i] - 1;

            if (k <= missingNum) {
                // k is between these missing number
                return arr[i] + k;
            }
            // if not, reduce k and push forwar
            k -= missingNum;
        }
        // if k is after rear of arry(like one billion or something)
        return arr[arr.length - 1] + k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
