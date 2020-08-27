package recursion;

public class Fibonacci {

    /**
     * Find the Fibonacci number in the specified position
     *
     * @param pos the position where to find the number
     * @return the number at position "pos"
     */
    private static int fib(int pos) { // assuming that pos won't be < 0
        if (pos <= 1) {
            return pos;
        } else {
            // we know "pos" here is at least 2, so we can initialize those three variables as if "pos" = 2:
            int prevNumber1 = 0; // this is the value at "pos" = 0
            int prevNumber2 = 1; // this is the value at "pos" = 1
            int fibNumber = 1; // this is the current fib number at "pos" = 2: 0 + 1 = 1
            // start the loop from "pos" = 2, there's no point in starting at "pos"/"i" = 0 here
            for (int i = 2; i < pos; i++) {
                // the execution only enters the loop if "pos" is >= 3.
                // We have to update the previous numbers BEFORE updating the fib number per se
                prevNumber1 = prevNumber2; // "move" the value from prev2 to prev1
                prevNumber2 = fibNumber; // "move" the value from fib to prev2
                fibNumber = prevNumber1 + prevNumber2; // update the current fib number
            }
            return fibNumber;
        }
    }

    /**
     * The recursive solution, without memoization, has a runtime of O(2^N) -- exponential.
     *
     * @param pos the position of the Fibonacci number we want to find
     * @return the Fibonacci number at that position
     */
    private static int fibRec(int pos) { // assuming that pos won't be < 0
        if (pos <= 1) {
            return pos;
        }
        return fibRec(pos - 1) + fibRec(pos - 2);
    }

    private static int fibRecMemoization(int pos, int[] memo) { // assuming that pos won't be < 0
        // if "pos" is 0 or 1, just return "pos" (it could also use "memo", but this is easier)
        if (pos <= 1) {
            return pos;
        }
        // here, "pos" is >= 2; so, if memo[pos] = 0, it means the result for that "pos" hasn't been memoized yet
        if (memo[pos] == 0) {
            // so, instead of returning the recursive calls directly, like in the above method, here we store the result
            memo[pos] = fibRecMemoization(pos - 1, memo) + fibRecMemoization(pos - 2, memo);
        }
        return memo[pos];
    }

    private static int fibBottomUp(int pos) {
        if (pos <= 1) {
            return pos;
        } else {
            int[] bottomUp = new int[pos + 1];
            bottomUp[0] = 0;
            bottomUp[1] = 1;
            for (int i = 2; i <= pos; i++) {
                bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
            }
            return bottomUp[pos];
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(0)); // 0
        System.out.println(fib(1)); // 1
        System.out.println(fib(2)); // 1
        System.out.println(fib(3)); // 2
        System.out.println(fib(4)); // 3
        System.out.println(fib(10)); // 55
        System.out.println(fibRec(0)); // 0
        System.out.println(fibRec(1)); // 1
        System.out.println(fibRec(2)); // 1
        System.out.println(fibRec(3)); // 2
        System.out.println(fibRec(4)); // 3
        System.out.println(fibRec(10)); // 55
        System.out.println(fibRec(45)); // 1134903170
        int[] memory = new int[11]; // size must be n + 1 bec. we want the 10th fib number which is in index 10, not 9
        System.out.println(fibRecMemoization(10, memory));
        int[] memory2 = new int[46];
        System.out.println(fibRecMemoization(45, memory2));
        System.out.println(fibBottomUp(0)); // 0
        System.out.println(fibBottomUp(1)); // 1
        System.out.println(fibBottomUp(2)); // 1
        System.out.println(fibBottomUp(3)); // 2
        System.out.println(fibBottomUp(4)); // 3
        System.out.println(fibBottomUp(10)); // 55
        System.out.println(fibBottomUp(45)); // 1134903170
    }
}
