import java.util.LinkedList;

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


    public boolean iterationHasPathSum(TreeNode root, int sum) {
        if (root == null)
          return false;
    
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();

        //someone said: Stack for DFS, Queue for BFS
        
        node_stack.add(root);
        sum_stack.add(sum - root.val);
    
        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
          node = node_stack.pollLast();
          curr_sum = sum_stack.pollLast();
          if ((node.right == null) && (node.left == null) && (curr_sum == 0))
            return true;
    
          if (node.right != null) {
            node_stack.add(node.right);
            sum_stack.add(curr_sum - node.right.val);
          }
          if (node.left != null) {
            node_stack.add(node.left);
            sum_stack.add(curr_sum - node.left.val);
          }
        }
        return false;
      }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
