package searching;

public class LinearSearch {

    /**
     * It returns the index where the target is located, or -1 if the target isn't found. O(n).
     *
     * @param array  the array of elements
     * @param target the target to be found
     * @return the index for the target
     */
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 9, 7};
        System.out.println(linearSearch(array, 7));
        System.out.println(linearSearch(array, 10));
    }
}
