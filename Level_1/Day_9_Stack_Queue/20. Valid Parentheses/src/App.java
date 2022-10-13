import java.util.*;

public class App {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (isLeft(c1)) {
                stack.add(c1);
            }
            if (!isLeft(c1)) {
                if (!stack.isEmpty()) {
                    char c2 = stack.peek();
                    if (matchUp(c2, c1)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isLeft(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean matchUp(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        return false;
    }

    public boolean BetterisValid(String s) {
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        //can use hash map as match up dictionary
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("{[}]"));
        System.out.println("Hello, World!");
    }
}
