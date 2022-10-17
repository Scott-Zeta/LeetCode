import java.util.*;

public class App {
    public String decodeString(String s) {
        //one stack method, push out decoding then push back
        //to deal with nested brackets
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                // close brackets detected, start decoding
                List<Character> decodingString = new ArrayList<>();
                while (stack.peek() != '[') {
                    // keep add letters
                    decodingString.add(stack.pop());
                }
                // pop out the '['
                stack.pop();
                // repeat k times
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    // k might be two or more digit!
                    k += ((stack.pop() - '0') * base);
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = decodingString.size() - 1; j >= 0; j--) {
                        // for nested brackets, push all back to stack
                        stack.push(decodingString.get(j));
                    }
                    k--;
                }
            } else {
                // regular case, push into stack
                stack.push(s.charAt(i));
            }
        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
