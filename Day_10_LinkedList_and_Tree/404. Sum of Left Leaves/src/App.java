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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        return result(root, false);
    }

    public int result(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        int total = 0;
        if (root.left != null) {
            total += result(root.left, true);
        }
        if (root.right != null) {
            total += result(root.right, false);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
