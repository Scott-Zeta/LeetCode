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
        preOrder(root.left);
        preOrder(root.right);
        
        return true;
    }

    public void preOrder(TreeNode node){
        if(node != null){
            preOrder(node.left);
            ///do something
            preOrder(node.right);
        }
    }

    public void mirrorpreOrder(TreeNode node){
        if(node != null){
            mirrorpreOrder(node.right);
            //do something
            mirrorpreOrder(node.left);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
