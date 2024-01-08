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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode oldLeft = invertTree(root.left);
        TreeNode oldright = invertTree(root.right);
        root.left = oldright;
        root.right = oldLeft;

        return root;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
