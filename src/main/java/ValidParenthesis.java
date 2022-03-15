import java.util.Stack;

public class ValidParenthesis {


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (!stack.isEmpty() &&
                    ((current == ')' && stack.peek() == '(')
                            || (current == '}' && stack.peek() == '{')
                            || (current == ']' && stack.peek() == '['))) {
                stack.pop();
            }else{
                stack.push(current);
                break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
    }

}
