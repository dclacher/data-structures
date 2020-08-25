package sorting;

public class QuickSort {

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int smaller = left - 1;
        for (int bigger = left; bigger < right; bigger++) {
            if (array[bigger] < pivot) {
                smaller++;
                // swap
                int temp = array[smaller];
                array[smaller] = array[bigger];
                array[bigger] = temp;
            }
        }
        array[right] = array[smaller + 1];
        array[smaller + 1] = pivot;
        return smaller + 1; // return the position/index of the pivot
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 8, 3, 0};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
