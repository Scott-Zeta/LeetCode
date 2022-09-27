class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class App {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;

        if (pValue < root.val && qValue < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (pValue > root.val && qValue > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
