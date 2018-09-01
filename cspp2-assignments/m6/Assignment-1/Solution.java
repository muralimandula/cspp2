import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers.
 * between 2 and n where n is given as an input.
 *
 * @author :Muralidhar, 20186065.
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }


    /**
     * Is prime checking.
     * @param      n
     * @return is prime value.
     */

    public static int isprime(final int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
              count += 1;
            }
              }
        if (count == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    public static void oddComposites(final int n) {
    // write your code here
        final int start = 3;
        for (int i = start; i < n; i++) {
            int iprime = isprime(i);
            if ((i % 2 != 0) && (iprime == 0)) {
                System.out.println(i);
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
