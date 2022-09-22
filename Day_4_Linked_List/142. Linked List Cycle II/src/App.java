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

    public ListNode chasing_detectCycle(ListNode head){
        if(head == null){
            return null;
        }

        ListNode intersect = find_intersect(head);

        if(intersect == null){
            return null;
        }

        ListNode tracker = head;
        while(!tracker.equals(intersect)){
            tracker = tracker.next;
            intersect = intersect.next;
        }

        return tracker;
    }

    public ListNode find_intersect(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow.equals(fast)){
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
