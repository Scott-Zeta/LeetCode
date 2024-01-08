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
    public static boolean isValidBST(TreeNode root) {
        return validation(root, null, null);
    }

    public static boolean validation(TreeNode root, Integer low, Integer high) {
        if(root == null){
            return true;
        }
        if((low != null && root.val<=low) || (high !=null && root.val>=high)){
            return false;
        }
        return validation(root.left, low, root.val) && validation(root.right, root.val, high);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
