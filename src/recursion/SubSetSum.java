package recursion;

import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

    /**
     * Find subsets of numbers in the array that add up to "n"
     *
     * @param total the sum that needs to be reached
     * @param array the array that contains the subsets
     * @return the number of subsets
     */
    private static int findSubSets(int[] array, int total) {
        Map<String, Integer> memo = new HashMap<>();
        return findSubSets(array, total, array.length - 1, memo);
    }

    private static int findSubSets(int[] array, int total, int index, Map<String, Integer> memo) {
        String key = total + ":" + index;
        int result;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (total == 0) return 1;
        if (total < 0) return 0;
        if (index < 0) return 0;
        if (array[index] > total) {
            result = findSubSets(array, total, index - 1, memo);
        } else {
            result = findSubSets(array, total - array[index], index - 1, memo) +
                     findSubSets(array, total, index - 1, memo);
        }
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 10};
        System.out.println(findSubSets(array, 16));
    }
}
