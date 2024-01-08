import java.util.Arrays;

public class App {

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];

        for (int[] row : map) {
            Arrays.fill(row, 1);
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
