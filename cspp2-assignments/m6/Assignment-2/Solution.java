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
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

    // write ypur code here

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (a[i][j] < 51) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = rounding(a[i][j]);
                   }
            }
        }
        return a;
    }



    public static int rounding(final int n) {

        double a = Math.floor(n / 100);
        // Double d = new Double(1.23);
        // int i = d.intValue();
        // double myDb = 12.3;
        // int myInt = (int) myDb;
        // Ref : stack overflow
        int aa = (int) a;
        int b;

        if ( (n % 100) > 50) {
            b = 1;
        } else {
            b = 0;
        }
        return ((aa + b) * 100 );
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
