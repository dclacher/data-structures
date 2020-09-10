package recursion;

public class Euclidean {

    /**
     * Greatest Common Divisor (GCD): The GCD of two or more integers is the largest integer that divides each of the
     * integers such that their remainder is zero. E.g. GCD(4,2) = 2
     *
     * @param a the first integer
     * @param b the second integer
     * @return the GCD
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int gcdLoop(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(1220, 516));
        System.out.println(gcd(11, 8));
        System.out.println(gcd(0, 8));
        System.out.println(gcd(10, 0));

        System.out.println(gcdLoop(1220, 516));
        System.out.println(gcdLoop(11, 8));
        System.out.println(gcdLoop(0, 8));
        System.out.println(gcdLoop(10, 0));
    }
}
