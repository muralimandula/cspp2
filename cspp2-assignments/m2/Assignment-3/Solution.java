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
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result = power(base, exponent);
        System.out.println(result);
	}
	/**
	*Need to write the power function and print the output.
	@param a a
	@param b b
	@return value of a to power b.
	*/
	public static int power(final int a, final int b) {
		if (b == 0) {
			return 1;
		} else {
			return a * power(a, b - 1);
		}
	}
}

