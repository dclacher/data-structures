package slidingwindow;

public class MaximumSumSubArray {

    /**
     * Given an array of integers of size 'n', calculate the maximum sum of 'sub' CONSECUTIVE elements in the array.
     * Time complexity is O(k*n) because of the nested loops, where 'n' is the size of the array and 'k' is the size
     * of the sub-array.
     *
     * @param array the array to be analyzed
     * @param sub   the size of the sub-array
     * @return the maximum sum
     */
    private static int maximumSumSubArray(int[] array, int sub) {
        if (sub > array.length) {
            throw new IllegalArgumentException("The size of the sub-array can't be greater than the size of the array");
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum;
        // This loop goes from the first element until the last "viable" element, i.e. the last element that can be the
        // first one of the sub-array. E.g. if the size of 'sub' is 3 and the size of the array is 5, the only possible
        // sub-arrays are the ones starting at indexes 0, 1 and 2. At index 3, the sub-array would have size = 2, not 3.
        // That's why the loop only goes from 0 to 2 in this example (array.length - sub --> 5 - 3 = 2).
        for (int i = 0; i <= array.length - sub; i++) {
            currentSum = 0;
            // The inner loop runs 'sub' times to sum all the elements from the sub-array that starts at 'i'.
            for (int j = 0; j < sub; j++) {
                currentSum = currentSum + array[i + j];
            }
            // Test to check whether the new sum is greater than the maximum sum.
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    /**
     * Same idea of the previous method, but using the "sliding window" concept, reducing time complexity to O(n)
     *
     * @param array the array to be analyzed
     * @param sub   the size of the sub-array
     * @return the maximum sum
     */
    private static int maximumSumSubArraySlidingWindow(int[] array, int sub) {
        if (sub > array.length) {
            throw new IllegalArgumentException("The size of the sub-array can't be greater than the size of the array");
        }
        int maxSum;
        int windowSum = 0;
        // The first loop simply gets the sum of the first sub-array, the one that starts at i = 0.
        for (int i = 0; i < sub; i++) {
            windowSum = windowSum + array[i];
        }
        maxSum = windowSum;
        // The second loop does the "slide". It goes from the next element (i = 1) until the last "viable" element (see
        // explanation in the method above). In each execution, it just gets the sum for the current "window", subtracts
        // the value from the index that is now out of the window and sums the value from the index that was just
        // included into the window.
        for (int i = 1; i <= array.length - sub; i++) {
            windowSum = windowSum - array[i - 1] + array[i + sub - 1];
            //
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }

    /**
     * Same idea of the previous method, but using the "sliding window" concept, reducing time complexity to O(n).
     * Let's try with only one loop.
     *
     * @param array the array to be analyzed
     * @param sub   the size of the sub-array
     * @return the maximum sum
     */
    private static int maximumSumSubArraySlidingWindowOneLoop(int[] array, int sub) {
        if (sub > array.length) {
            throw new IllegalArgumentException("The size of the sub-array can't be greater than the size of the array");
        }
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int left = 0;
        // The right side of the window controls the loop. Once the right side reaches the end of the array, it's over.
        for (int right = 0; right < array.length; right++) {
            // (right - left) controls the size of the window, since it's a fixed size. If (right - left) is equal to
            // "sub", it means it's getting more elements than it should.
            if (right - left == sub) {
                // slide left to the next index
                left++;
                // bring right back to the same position of left (-1 because the loop will increment it in the next
                // execution, after "continue").
                right = left - 1;
                // reset window sum
                windowSum = 0;
                // use continue to avoid executing the last part, without breaking the loop.
                continue;
            }
            windowSum = windowSum + array[right];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }

    /**
     * For this one, we don't have a fixed size for the sub-array. Hence, we are going to use the Kadane's algorithm,
     * reducing time complexity to O(n). Kadane's algorithm is all about COMPARING the accumulated sum (from the
     * elements that have been visited so far) with the value of the single element in the current index.
     *   - If the first one is greater, we keep accumulating (current sum will reflect that);
     *   - Else, we discard everything we had so far and start a new sum (current sum will also reflect that) - it's
     *   like "emptying" the sub-array we were building until this point.
     *
     *   Note: if all elements are negative integers, the max will the value of one single element (the greatest among
     *   them all). If all elements are positive integers, the max is actually the sum of the whole array.
     *
     * @param array the array to be analyzed
     * @return the maximum sum
     */
    private static int maximumSumSubArrayKadane(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0, accumulatedSum, nonAccumulatedSum;
        for (int j : array) {
            nonAccumulatedSum = j;
            accumulatedSum = currentSum + nonAccumulatedSum;
            currentSum = Math.max(nonAccumulatedSum, accumulatedSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maximumSumSubArray(arr1, 4));
        System.out.println(maximumSumSubArraySlidingWindow(arr1, 4));
        System.out.println(maximumSumSubArraySlidingWindowOneLoop(arr1, 4));
        int[] arr2 = {100, 200, 300, 400};
        System.out.println(maximumSumSubArray(arr2, 2));
        System.out.println(maximumSumSubArraySlidingWindow(arr2, 2));
        System.out.println(maximumSumSubArraySlidingWindowOneLoop(arr2, 2));
        int[] array3 = {-2, 2, 5, -11, 8, -1, 2};
        System.out.println(maximumSumSubArrayKadane(array3));
    }
}
