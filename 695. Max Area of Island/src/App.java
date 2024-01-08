class Solution {
    public int maxAreaOfIsland(int[][] grid) {
   int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {

        //more effcient if statment to check if it is in the grid
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        //paint it to 0 as the instead of the visit table
        grid[i][j] = 0;
        int area = 1;

        area +=
        dfs(grid, i + 1, j) + 
        dfs(grid, i - 1, j) +
        dfs(grid, i, j + 1) +
        dfs(grid, i, j - 1);

        return area;
    }
}

public class App {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int height = grid.length;
        int length = grid[0].length;
        boolean[][] vist = new boolean[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1 && vist[i][j] == false) {
                    int count = 0;
                    count = dfs(grid, vist, count, i, j);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, boolean[][] vist, int count, int i, int j) {
        if (grid[i][j] == 1 && vist[i][j] == false) {
            count++;
            vist[i][j] = true;
            if (i > 0) {
                count = dfs(grid, vist, count, i - 1, j);
            }
            if (j > 0) {
                count = dfs(grid, vist, count, i, j - 1);
            }
            if (i < grid.length - 1) {
                count = dfs(grid, vist, count, i + 1, j);
            }
            if (j < grid[0].length - 1) {
                count = dfs(grid, vist, count, i, j + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
