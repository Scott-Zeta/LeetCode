import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

// what should I do?
// link all nodes together which lie on the same level
// level traversal
// basic idea, add one level in a queue, pop first, link to the next,
// then add children to the queue, until the end, the queue will be empty
// noticed, once the node number equal to the size - 1, the next should be null
public class App {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node current = q.poll();

                if (i < size - 1) {
                    current.next = q.peek();
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
