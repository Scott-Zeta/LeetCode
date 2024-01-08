import java.util.HashSet;

public class App {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        // why HashSet?
        // Hash set can not contains duplicate, ignore order consequence
        // use O(1) check if contians
        for (int r = 0; r < n; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        } // sub hash set for row group, columns group and box group

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                    // ignore the empty
                }

                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                int boxIndex = (r / 3) * 3 + c / 3; // !!!box group index
                if (boxes[boxIndex].contains(val)) {
                    return false;
                }
                boxes[boxIndex].add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
