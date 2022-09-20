class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class App {
    public ListNode previous_reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode currentHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null; //avoid circle
        return tmp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
