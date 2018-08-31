/**
*20186065
*To print the number of 7's from 1 to n
*/

import java.util.Scanner;
  /*
  Do not modify this main function.
  */

  /**
   *Main class Solution.
   */
public final class Solution {


  /* Fill the main function to print the number of 7's between 1 to n*/


  /**
   * Constructs the object.
   */
  private Solution() {
    //unused
  }

  /**
  * Main method.
  *
  * @param args  The arguments
  */
  public static void main(final String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int count = 0;

    for (int i = 1; i <= n; i++) {
      String num = String.valueOf(i);
      // System.out.println(num);
      // System.out.println(num.getClass().getName());
      char[] numArr = num.toCharArray();
      // System.out.println(numArr);
      // System.out.println(numArr.getClass().getName());
      for (char c: numArr) {
        if (c == '7') {
          count = count + 1;
        }
      }
    }
    System.out.println(count);
  }
}

