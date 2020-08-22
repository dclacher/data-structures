package cracking.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class AllUniqueCharacters {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     *
     * @param s the string to be evaluated
     * @return true if all the characters are unique; false otherwise
     */
    private static boolean areCharsUnique(String s) {
        // why a set? because there's no need to store a "value", just the key itself. Plus, set has the "contains"
        // method, which is useful here (something that a list doesn't have). Another solution would be to use a fixed
        // array (128 chars for ASCII, 256 for extended ASCII) and then get the char ASCII code as an integer, using it
        // as the index to store the char (or just a boolean value - switch from false to true). See next method.
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Implement an algorithm to determine if a string has all unique characters. Using here an array for ASCII chars
     * (128 positions).
     *
     * @param s the string to be evaluated
     * @return true if all the characters are unique; false otherwise
     */
    private static boolean areCharsUnique2(String s) {
        if (s.length() > 128) return false; // because there are only 128 characters in ASCII
        boolean[] charArray = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int code = s.charAt(i); // get the ASCII code
            if (charArray[code]) { // look for the position of the code in the array
                // if true, it means this character has been found already, so return false
                return false;
            }
            charArray[code] = true; // switch to true once that ASCII character was found in the string
        }
        return true;
    }

    /**
     * Same idea, but without using additional data structures. Is there another way, other than nested loops?
     *
     * @param s the string to be evaluated
     * @return true if all the characters are unique; false otherwise
     */
    private static boolean areCharsUniqueNoDS(String s) {
        // fix "i" in one of the characters (the first character on the first iteration)
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i); // get the char at position "i"
            // position "j" in the next char after "i" and start compare
            for (int j = i + 1; j < s.length(); j++) {
                // if it finds a match, there's a duplicate, so return false
                if (currentChar == s.charAt(j)) {
                    return false;
                }
            }
        }
        // if it reaches the end of the loop without finding duplicates, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areCharsUnique("pad mad"));
        System.out.println(areCharsUnique("Dad")); // true, because it's case sensitive
        System.out.println(areCharsUnique("Daniel"));
        System.out.println(areCharsUnique2("pad mad"));
        System.out.println(areCharsUnique2("Dad")); // true, because it's case sensitive
        System.out.println(areCharsUnique2("Daniel"));
        System.out.println(areCharsUniqueNoDS("pad mad"));
        System.out.println(areCharsUniqueNoDS("Dad")); // true, because it's case sensitive
        System.out.println(areCharsUniqueNoDS("Daniel"));
    }
}
