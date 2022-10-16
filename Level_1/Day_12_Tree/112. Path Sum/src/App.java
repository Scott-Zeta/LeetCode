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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // the core is minus every level it passed, and check if it is a leaf
        if (root == null) {
            return false;
        }

        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            // if reach the leaf, check the sum is zero or not
            return (targetSum == 0);
        }
        //else keep recursion, left or right both possible, so use OR || operator
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
