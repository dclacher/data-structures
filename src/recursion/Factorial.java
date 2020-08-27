package recursion;

public class Factorial {

    private static int factorial(int n) {
        if (n < 0) return -1;
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    private static int factorialRec(int m) {
        if (m < 0) return -1;
        if (m == 0) return 1; // base case
        return m * factorialRec(m - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(4));
        System.out.println(factorial(30));
        System.out.println(factorialRec(0));
        System.out.println(factorialRec(1));
        System.out.println(factorialRec(4));
        System.out.println(factorialRec(30));
    }
}
