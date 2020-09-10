package sorting;

import java.util.Arrays;

public class InsertionSort {

    /**
     * The array is "divided" into a sorted subset and an unsorted subset (initially, the first item is the sorted subset).
     * At each pass:
     * 1. Compare every item to the left of "current" with "current"
     * 2. If value at left > "current", SHIFT it to the right; repeat until there's nothing on the left (or nothing greater)
     * 3. INSERT "current" in its correct position in the sorted subset
     *
     * <p>
     * --> Time complexity is O(n^2) on average/worst cases and O(n) on the best case (already sorted array).
     * --> It's an IN-PLACE algorithm.
     *
     * @param array the unsorted array
     */
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int current = array[i];
            // "current" is used as the measure to shift elements to the right
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1]; // shifting element to the right
                j--;
            }
            array[j] = current; // INSERTING the current element in its correct position in the sorted subset
        }
    }

    /**
     * The array is "divided" into a sorted subset and an unsorted subset (initially, the first item is the sorted subset).
     * At each pass:
     * 1. Compare the current item with the item at its LEFT side (sorted subset)
     * 2. If value at left > value at right, SWAP them; repeat until there's nothing at the left side (or nothing greater)
     * (by doing this, the value at "i" is INSERTED into its correct position in the sorted subset)
     *
     * <p>
     * --> Time complexity is O(n^2) on average/worst cases and O(n) on the best case (already sorted array).
     * --> It's an IN-PLACE algorithm.
     *
     * @param array the unsorted array
     */
    private static void insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j - 1, j);
                j--;
            }
        }
    }

    /**
     * Same as the above method, but with two "for" loops
     *
     * @param array the unsorted array
     */
    private static void insertionSort3(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) swap(array, j - 1, j);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 1, 0, 9};
        insertionSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {6};
        insertionSort2(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {};
        insertionSort2(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {1, 2, 3};
        insertionSort2(array4);
        System.out.println(Arrays.toString(array4));

        int[] array5 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort3(array5);
        System.out.println(Arrays.toString(array5));
    }
}
