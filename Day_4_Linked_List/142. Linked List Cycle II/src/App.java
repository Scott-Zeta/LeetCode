import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class App {
    public ListNode detectCycle(ListNode head) {
        ArrayList<ListNode> visited = new ArrayList<>();
        ListNode s = head;
        while (s != null && s.next != null) {
            if (visited.contains(s)) {
                return s;
            }
            visited.add(s);
            s = s.next;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
