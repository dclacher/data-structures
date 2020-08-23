package slidingwindow;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] array = new int[8];
        array[0] = 2;
        array[1] = -3;
        array[2] = 4;
        array[3] = 0;
        array[4] = 1;
        array[5] = -2;
        array[6] = 3;
        array[7] = 4;
        System.out.println(MaximumProductSubArray.maxProduct(array));
        System.out.println(MaximumProductSubArray.maxProductSlidingWindow(array));

        int[] array2 = new int[3];
        array2[0] = 3;
        array2[1] = 3;
        array2[2] = -1;
        System.out.println(MaximumProductSubArray.maxProduct(array2));
        System.out.println(MaximumProductSubArray.maxProductSlidingWindow(array2));
    }

    /**
     * Given an integer array nums, find the CONTIGUOUS sub-array within an array (containing at least one number)
     * which has the largest product. (SLIDING WINDOW approach)
     *
     * @param nums the array of numbers to be processed
     * @return the largest product
     */
    public static int maxProductSlidingWindow(int[] nums) {
        // if there's less than one element, don't even bother processing
        if (nums.length < 1) {
            throw new IllegalArgumentException("The array should have at least one element.");
        }
        int maxProduct = Integer.MIN_VALUE;
        // if there's only one element, just return the product; else go process the array
        if (nums.length == 1) {
            return nums[0];
        } else {
            // left and right are pointers to control the edges of the window
            int currentProduct = 1, left = 0, right = 0, tempProduct;
            // the loop ends when the right pointer reaches the end of the array
            while (right < nums.length) {
                tempProduct = currentProduct;
                currentProduct = currentProduct * nums[right];
                if (tempProduct > currentProduct) {
                    left++;
                    right = left;
                    currentProduct = 1;
                    continue;
                }
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
                right++;
            }
        }
        return maxProduct;
    }

    /**
     * Given an integer array nums, find the contiguous sub-array within an array (containing at least one number)
     * which has the largest product. (BRUTE FORCE approach)
     *
     * @param nums the array of numbers to be processed
     * @return the largest product
     */
    public static int maxProduct(int[] nums) {
        // if there's less than one element, don't even bother processing
        if (nums.length < 1) {
            throw new IllegalArgumentException("The array should have at least one element.");
        }
        int maxProduct = Integer.MIN_VALUE;
        // if there's only one element, just return the product; else go process the array
        if (nums.length == 1) {
            return maxProduct;
        } else {
            int currentProduct = 1; // "Neutral" integer for multiplication? It seems to work
            int tempProduct;
            for (int i = 0; i < nums.length; i++) {
                // inner loop will start one position to the right at every new iteration
                for (int j = i; j < nums.length; j++) {
                    // set tempProduct BEFORE updating it again
                    tempProduct = currentProduct;
                    currentProduct = currentProduct * nums[j];
                    // tempProduct is used to break the inner loop when the current result is less than the previous one
                    // (because it means that the largest product has been reached in that sequence).
                    if (tempProduct > currentProduct) break;
                    if (currentProduct > maxProduct) maxProduct = currentProduct;
                }
                // reset current product to 1 before new inner loop
                currentProduct = 1;
            }
        }
        return maxProduct;
    }
}
