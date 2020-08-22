package recursion;

public class Factorial {
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

    private static int factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    private static int factorialRec(int m) {
        // assumption: m >= 0
        if (m == 0) {
            // base case
            return 1;
        }
        return m * factorialRec(m - 1);
    }
}
