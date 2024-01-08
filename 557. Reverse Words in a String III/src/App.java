import java.util.Stack;

public class App {

    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == ' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }else{
                stack.add(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println("Hello, World!");
    }
}
