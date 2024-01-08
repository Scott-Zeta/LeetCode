public class App {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // sr and sc is the start position of new color
        // what we should do is by using DFS find every conected point from start point
        // then use new color replace them
        // new color can be the identity of the node has been visited or not.
        // like the vist boolean array in DFS
        int preColor = image[sr][sc];

        if (preColor != color) {
            // if the color is different, begin. Or it is the end without
            // single validated node
            dfs(image, sr, sc, color, preColor);
        }
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int preColor) {
        // there is no edge list or matrix here.
        // the color will expand it self freely by four direction
        // but only paint our target old color
        if (image[sr][sc] == preColor) {
            image[sr][sc] = color; // paint
            // four direction expand, range: 0 ~ length - 1
            if (sr > 0) {
                dfs(image, sr - 1, sc, color, preColor); // up expand
            }
            if (sc > 0) {
                dfs(image, sr, sc - 1, color, preColor);// left expand
            }
            if (sr < image.length - 1) {
                dfs(image, sr + 1, sc, color, preColor);// down expand
            }
            if (sc < image[0].length - 1) {
                dfs(image, sr, sc + 1, color, preColor);// right expand
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
