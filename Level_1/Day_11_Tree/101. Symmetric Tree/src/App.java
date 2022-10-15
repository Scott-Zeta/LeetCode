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
    public boolean NotCorrectIsSymmetric(TreeNode root) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        preOrder(root.left, leftList);
        mirrorpreOrder(root.right, rightList);
        System.out.println(leftList.toString());
        System.out.println(rightList.toString());
        return leftList.equals(rightList);
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            preOrder(node.left, list);
            list.add(node.val);
            preOrder(node.right, list);
        }
    }

    public void mirrorpreOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            mirrorpreOrder(node.right, list);
            list.add(node.val);
            mirrorpreOrder(node.left, list);
        }
    }
    // It's better to do recursion at the same time with two sub node

    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }

    public boolean mirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.val == node2.val) && mirror(node1.left, node2.right)
                && mirror(node1.right, node2.left);
    }
    //chain the boolean

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
