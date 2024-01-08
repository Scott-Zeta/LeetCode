public class App {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0;
        int right = r * c - 1;

        int index;
        int element;
        while (right >= left) {
            index = left + (right - left)/2; //prevent over flow compare with (left + right)/2
            element = matrix[index / c][index % c]; //!!! this is the core

            if (element == target) {
                return true;
            }

            if (element > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
