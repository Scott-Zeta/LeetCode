import java.util.*;

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

public class App {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        preOrder(root.left, leftList);
        preOrder(root.right, rightList);

        return leftList.equals(rightList);
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            preOrder(node.left, list);
            /// do something
            list.add(node.val);
            preOrder(node.right, list);
        }
    }

    public void mirrorpreOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            mirrorpreOrder(node.right, list);
            // do something
            list.add(node.val);
            mirrorpreOrder(node.left, list);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
