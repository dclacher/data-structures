package sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * At each pass:
     * 1. SELECT the smallest value from the unsorted array
     * 2. Swap the smallest value with the value at position "i"
     * <p>
     * --> Time complexity is O(n^2) on ALL cases (it has to go through the entire unsorted part to find the smallest value).
     * --> It is an IN-PLACE algorithm.
     *
     * @param array the array to be sorted
     */
    private static void selectionSort(int[] array) {
        // why array.length - 1? because "j" is always one position ahead (i + 1)
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // initial assumption: the smallest value is at "i"
            // why j = i? because it's a way to avoid processing the part that's already sorted
            for (int j = i + 1; j < array.length; j++) {
                // if the value at "j" is smaller, update the smallest value's index
                if (array[j] < array[minIndex]) minIndex = j;
            }
            // swap is only needed if the smallest value WASN'T at position "i" (the if above was never executed)
            if (i != minIndex) swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 2, 6, 1, 9, 0, 4};
        selectionSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
