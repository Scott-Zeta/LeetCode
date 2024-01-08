import java.util.*;

public class App {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = result.get(i - 1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);

            result.add(row);
        }
        return result;
    }

    //be honest, I wonder this is realy dynamic programing or not

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
