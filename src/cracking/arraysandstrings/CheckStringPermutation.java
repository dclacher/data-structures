package cracking.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class CheckStringPermutation {

    /**
     * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
     *
     * @param a the first string
     * @param b the second string
     * @return true if one is a permutation of the other
     */
    private static boolean isStringPermutation(String a, String b) {
        // if strings have different lengths, return false immediately
        if (a.length() != b.length()) {
            return false;
        }
        // if both string are empty, return true
        if (a.isBlank() && b.isBlank()) {
            return true;
        }
        // populate a map of characters with the frequencies for one of the strings
        Map<Character, Integer> charMap = populateCharMap(a);
        // loop through the other string (not the one used to populate the map)
        for (int i = 0; i < b.length(); i++) {
            char currentChar = b.charAt(i);
            // if the character is found in the other string, decrement the frequency for that char by 1
            if (charMap.containsKey(currentChar)) {
                charMap.put(currentChar, charMap.get(currentChar) - 1);
            }
            // Then, if the frequency for that char reaches 0, delete the entry in the char map. Why check if the map
            // contains the key again? Because if the map doesn't contain that key, the "get" call would result in a NPE
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) <= 0) {
                charMap.remove(currentChar);
            }
            // finally, if the map is empty i.e. all characters were found, return true
            if (charMap.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> populateCharMap(String a) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char currentChar = a.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                map.put(currentChar, map.get(currentChar) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(isStringPermutation("a", "A"));
        System.out.println(isStringPermutation("a", "b"));
        System.out.println(isStringPermutation("a", "a")); // true
        System.out.println(isStringPermutation("ab", "b"));
        System.out.println(isStringPermutation("", "")); // true
        System.out.println(isStringPermutation("a", ""));
        System.out.println(isStringPermutation("", "b"));
        System.out.println(isStringPermutation("Daniel", "Daniel")); // true
        System.out.println(isStringPermutation("Daniel", "daniel"));
        System.out.println(isStringPermutation("bababa", "ababab")); // true
    }
}
