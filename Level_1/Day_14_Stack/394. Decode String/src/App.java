import java.util.*;

public class App {
    public String SingleStackDecodeString(String s) {
        // one stack method, push out decoding then push back
        // to deal with nested brackets
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

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> content = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // record k repeat number
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // push k into count
                count.push(k);
                k = 0;
                // give a stringbuilder as place holder? until reach the ']', then start
                // building content?
                // push previous string builder? but with an empty one when first or only one
                // no, the current stringbuilder won't dissappear
                //don't think thi is correct
            } else if (c == ']') {
                // start building string
                StringBuilder decode = sb;
                for (int popk = count.pop(); popk > 0; popk--) {
                    decode.append(sb);
                }
                sb = decode;
            } else {
                // recording content
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
