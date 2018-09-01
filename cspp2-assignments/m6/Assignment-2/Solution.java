import java.util.Scanner;
// import java.lang.Math;
/**
 * Write a java program to round the.
 * elements of a matrix to the nearest 100.
 *
 * @author : Muralidhar, 20186065.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {

    // write ypur code here

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    a[i][j] = rounding(a[i][j]);
                }
        }
        return a;
    }


    /**
     * rounding the value.
     * @param      n     { parameter_description }.
     * @return     { description_of_the_return_value }.
     */
    public static int rounding(final int n) {
        final int hun = 100;
        final int fif = 50;
        double a = Math.floor(n / hun);
        int aa = (int) a;
        int b;

        if ((n % hun) > fif) {
            b = 1;
        } else {
            b = 0;
        }
        return ((aa + b) * hun);
   }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
