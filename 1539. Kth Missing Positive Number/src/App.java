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

    public int binaryFind(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (arr[pivot] - pivot - 1 < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        // core
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
