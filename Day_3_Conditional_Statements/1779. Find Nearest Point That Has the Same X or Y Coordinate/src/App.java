public class App {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int shortestDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[][] points = { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } };
        System.out.println(nearestValidPoint(3, 4, points));
    }
}
