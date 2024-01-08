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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, set, k);
    }

    public boolean find(TreeNode node, Set<Integer> set, int k) {
        if (node == null) {
            // means this branch to leaf doesnot hash what looking for
            return false;
        } else {
            if (set.contains(node.val)) {
                return true;
            }
            set.add(k - node.val);
        }
        // use logic operator chain them up
        return find(node.left, set, k) || find(node.right, set, k);
    }

    public boolean ListfindTarget(TreeNode root, int k) {
        // since binary tree is inorder, can use list two pointer approach
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
