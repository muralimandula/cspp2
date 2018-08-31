/**
 * 20186065.
 * Reverse of a String.
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
        // unused
    }


    /**
     * Do not modify the main function.
     * Main Method.
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }

    /**
     * reversal function.
     * @param      s     { parameter_description }.
     * @return     { description_of_the_return_value }.
     */

    public static String reverseString(final String s) {
        String str = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            str += s.charAt((length - 1) - i);
        }
        return str;

    }

}
