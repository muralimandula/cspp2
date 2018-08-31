/**
*20186065.
* To find the largest number in a given array.
*/

import java.util.Scanner;
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
   * main function.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner readInput = new Scanner(System.in);
    int n = readInput.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = readInput.nextInt();  // inserting into array
    }

    int max = arr[0];

    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    System.out.println(max);
  }
}


