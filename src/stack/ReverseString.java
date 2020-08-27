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

    /**
     * This is a similar solution, but using a for loop that iterates only to the middle of the char array. The aux.
     * variable goes from the final of the array to the middle, traversing to the left, while i goes to the right.
     *
     * @param s the string
     * @return the reverted string
     */
    private static String reverseStringOneAuxVar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            int rightIndex = chars.length - 1 - i;
            swap(chars, i, rightIndex);
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
        System.out.println(reverseStringOneAuxVar("Daniel"));
        System.out.println(reverseStringOneAuxVar("mad dog"));
        System.out.println(reverseStringOneAuxVar(""));
        System.out.println(reverseStringOneAuxVar("m"));
        System.out.println(reverseStringOneAuxVar("md"));
        System.out.println(reverseStringOneAuxVar("mad"));
    }
}
