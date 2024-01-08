import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int head;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.empty()){
            head = x;
        }
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return head;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
