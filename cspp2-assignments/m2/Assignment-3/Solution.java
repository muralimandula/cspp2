/**
*Assignment -3.
* Finding a to power of b.
*/

import java.util.Scanner;

/**
*Main class - Solution Class.
*/

public final class Solution {
    /**
    *dummy.
    */
    private Solution() {
    }
    /**
    *Do not modify this main function.
    @param args Format need
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        long base = s.nextLong();
        long exponent = s.nextLong();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    *Need to write the power function and print the output.
    @param a a
    @param b b
    @return value of a to power b.
    */
    public static long power(final long a, final long b) {
        final long zero = 0;
        final long one = 1;
        if (b == zero) {
            return one;
        } else {
            return a * power(a, (b - one));
        }
    }
}
