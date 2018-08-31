/**
* 20186065.
* Addition of teo matrices
*/

// import java.util.Arrays;
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

  /* Fill the main function to print
   * resultant of addition of matrices*/

  /**
   * main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    Scanner readInput = new Scanner(System.in);

    int r1 = readInput.nextInt();
    int c1 = readInput.nextInt();

    int[][] matrix1 = new int[r1][c1];

    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        matrix1[i][j] = readInput.nextInt();
      }
    }

    int r2 = readInput.nextInt();
    int c2 = readInput.nextInt();

    int[][] matrix2 = new int[r2][c2];

    for (int i = 0; i < r2; i++) {
      for (int j = 0; j < c2; j++) {
        matrix2[i][j] = readInput.nextInt();
      }
    }
    if (r1 == r2 && c1 == c2) { 
    int[][] matAdd = new int[r1][c1];  

    for (int i = 0; i < r1; i++) {
      String o = "";
      for (int j = 0; j < c1; j++) {
        matAdd[i][j] = matrix1[i][j] + matrix2[i][j];
        o += matAdd[i][j];
        o += " ";
      }
      System.out.println(o.substring(0, o.length() - 1));
    }
    } else {
      System.out.println("not possible");
    }
  }
}


