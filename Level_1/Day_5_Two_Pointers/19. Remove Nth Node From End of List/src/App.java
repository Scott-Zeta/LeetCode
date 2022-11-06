class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class App {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode rear = head;
        ListNode headPointer = head;
        for (int i = 0; i < n; i++) {
            rear = rear.next;
        }
        if (rear.next == null) {
            head = head.next;
            return head;
        }
        while (rear.next != null) {
            headPointer = headPointer.next;
            rear = rear.next;
        }
        headPointer.next = headPointer.next.next;

        return head;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
