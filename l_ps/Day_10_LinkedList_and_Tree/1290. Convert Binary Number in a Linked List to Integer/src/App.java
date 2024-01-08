import java.util.Stack;

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
    public int getDecimalValue(ListNode head) {
        Stack<Integer> buffer = new Stack<>();
        int result = 0;
        while (head != null) {
            buffer.push(head.val);
            head = head.next;
        }
        int n = buffer.size();
        for (int i = 0; i < n; i++) {
            System.out.println(buffer.peek());
            result += powerOf(buffer.pop() * 2, i);
            System.out.println(result);
        }
        return result;
    }

    public int powerOf(int a, int n) {
        if (a == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else {
            for (int i = 0; i < n - 1; i++) {
                a *= 2;
            }
            return a;
        }
    }

    public int BettergetDecimalValue(ListNode head) {
        int sum = 0;
        while(head != null){
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
