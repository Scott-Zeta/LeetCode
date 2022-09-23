import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class App {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        preTraverse(root, result);
        return result;
    }

    public void preTraverse(Node root, List list){
        if(root == null){
            return;
        }
        list.add(root.val);
        for(Node c: root.children){
            preTraverse(c, list);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
