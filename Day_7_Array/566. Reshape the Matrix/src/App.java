public class App {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int countR = 0;
        int countC = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[countR][countC] = mat[i][j];
                countC++;
                if (countC == c) {
                    countR++;
                    countC = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        matrixReshape(null, 0, 0);
        System.out.println("Hello, World!");
    }
}
