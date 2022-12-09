import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    private int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //use queue to store data visited
        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // rotten orange
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    // fresh orange
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int min = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int k = 0; k < 4; k++) {
                    // four direction expand
                    int nextX = current[0] + dir[k][0];
                    int nextY = current[1] + dir[k][1];
                    if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && grid[nextX][nextY] == 1) {
                        // become rotten
                        grid[nextX][nextY] = 2;
                        // add the new rotten in the queue, waiting for next iterate expand
                        queue.add(new int[] { nextX, nextY });
                        freshCount--;
                    }
                }
            }
            // rotten time++
            min++;
        }
        return freshCount == 0 ? min - 1 : -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
