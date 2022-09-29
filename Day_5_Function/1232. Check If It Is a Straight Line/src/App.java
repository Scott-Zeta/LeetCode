public class App {
    public boolean checkStraightLine(int[][] coordinates) {
        int y1 = (coordinates[1][1] - coordinates[0][1]);
        int x1 = (coordinates[1][0] - coordinates[0][0]);
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (y1 * (coordinates[i + 1][0] - coordinates[i][0]) != x1 * (coordinates[i + 1][1] - coordinates[i][1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
