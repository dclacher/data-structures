package stack;

import java.util.Stack;

public class ReverseString {

    /**
     * Reversing a string. This solution uses a stack, which might not be the best solution because of the extra space.
     *
     * @param s the string to revert
     * @return the reverted string
     */
    private static String reverseString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * LeetCode: Do not allocate extra space for another array, you must do this by modifying the input array in-place
     * with O(1) extra memory. You may assume all the characters consist of printable ascii characters.
     *
     * @param s the string
     * @return the reverted string
     */
    private static String reverseStringWithoutStack(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Daniel"));
        System.out.println(reverseString("mad dog"));
        System.out.println(reverseStringWithoutStack("Daniel"));
        System.out.println(reverseStringWithoutStack("mad dog"));
        System.out.println(reverseStringWithoutStack(""));
        System.out.println(reverseStringWithoutStack("m"));
        System.out.println(reverseStringWithoutStack("md"));
        System.out.println(reverseStringWithoutStack("mad"));
    }
}
