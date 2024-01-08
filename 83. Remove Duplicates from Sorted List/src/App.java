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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;

        while (pointer != null) {
            ListNode dup = pointer.next;

            while (dup != null && dup.val == pointer.val) {
                dup = dup.next;
            }
            pointer.next = dup;
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
