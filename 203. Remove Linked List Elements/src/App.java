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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = head;
        ListNode prev = head;
        while (pointer != null) {
            if (pointer.val == val) {
                if (pointer == head) {
                    // remove first node
                    head = pointer.next;
                } else {
                    prev.next = pointer.next;
                }
            } else {
                prev = pointer;
            }
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
