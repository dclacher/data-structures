package sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * At each pass:
     * 1. Compare the adjacent values (pairs of elements)
     * 2. Swap the values if the left one is greater than the right one
     * 3. By the end of the pass, the greatest value will be at the right side ("BUBBLES UP" to the end of the array)
     * <p>
     * --> Time complexity is O(n^2) on average/worst cases and O(n) on the best case (already sorted array).
     * --> Bubble sort is STABLE and IN-PLACE.
     *
     * @param array the array to be sorted
     */
    private static void bubbleSort(int[] array) {
        // The outer loop is just to control how many times the inner loop will run
        for (int i = 0; i < array.length - 1; i++) {
            boolean doSwap = false;
            // inner loop does the swaps (the "- i" in the condition is to avoid going to the already sorted part)
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    doSwap = true;
                }
            }
            // if no swap is done in a pass, then the array is sorted and we can break out of the outer loop
            if (!doSwap) break;
        }
    }

    private static void bubbleSortWithWhile(int[] array) {
        boolean isSorted = false;
        int unsortedLength = array.length - 1;
        while (!isSorted) {
            isSorted = true; // assuming the array is sorted
            for (int i = 0; i < unsortedLength; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i);
                    isSorted = false; // assumption was wrong in this pass
                }
            }
            // after each pass of the inner loop, the unsorted part is smaller
            unsortedLength--;
        }
    }

    private static void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 8, 3, 0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        bubbleSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {5, 4, 4, 3, 2, 2, 0};
        bubbleSortWithWhile(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {1, 2, 3, 4, 5, 6};
        bubbleSort(array4);
        System.out.println(Arrays.toString(array4));
    }
}
