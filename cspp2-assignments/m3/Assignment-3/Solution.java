/**
*20186065.
*To find the GCD of given 2 numbers.
*/

import java.util.Scanner;
  /*
  Do not modify this main function.
  */

  /**
   * Class for solution.
   */

public final class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {
    //unused
  }


  /**
   * Main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    Scanner s = new Scanner(System.in);
    int num1 = s.nextInt();
    int num2 = s.nextInt();
    int gcd = gcd(num1, num2);
    System.out.println(gcd);
    }
  /**
   * Need to write the gcd function and print the output.   
   * The GCD of 2 numbers.
   *
   @param      x     First Number
   @param      y     Second Number
   *
   * @return     GCD, int
   */

    public static int gcd(final int x, final int y) {
    int minOfTwo = Math.min(x, y);
    for (int i = minOfTwo; i >= 1; i--) {
      if (x % i == 0 && y % i == 0) {
        return i;
      }
    }
    return 1;
  }

}

