package stack;

import java.util.Stack;

public class ValidParenthesesExpression {

    /**
     * Given a string containing the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     * @param s the string
     * @return true if it's valid
     */
    private static boolean isValidExpression(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // if it's an opening bracket, push it to the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // deal with the closing brackets
            if (c == ')' || c == ']' || c == '}') {
                // if it's a closing bracket and the stack is empty, return false immediately bc. there's no opening one
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek() != '(' || c == ']' && stack.peek() != '[' || c == '}' && stack.peek() != '{') {
                    // if the closing bracket doesn't match the one on top of the stack, return false immediately
                    return false;
                } else {
                    // else, if they match, pop (pull) the opening bracket from the stack
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidExpression("(abc)"));
        System.out.println(isValidExpression("(abc}"));
        System.out.println(isValidExpression("(abc"));
        System.out.println(isValidExpression("abc")); // true, but should it be true or false?
        System.out.println(isValidExpression("(a[b)c]"));
        System.out.println(isValidExpression("(a[b]c)"));
    }
}
