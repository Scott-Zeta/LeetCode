public class App {

    public boolean searchMatrix(int[][] matrix, int target) {
        // turn matrix into linear form
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = matrix[mid / column][mid % column];
            if (element == target) {
                return true;
            }
            if (element < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
