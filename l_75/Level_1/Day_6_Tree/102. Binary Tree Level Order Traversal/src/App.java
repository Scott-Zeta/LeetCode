import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        BFS(root, 0);
        return result;
    }

    public void BFS(TreeNode root, int lvIndex) {
        if (result.size() == lvIndex) {
            result.add(new ArrayList<Integer>());
        }
        result.get(lvIndex).add(root.val);

        if (root.left != null) {
            BFS(root.left, lvIndex + 1);
        }
        if (root.right != null) {
            BFS(root.right, lvIndex + 1);
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
