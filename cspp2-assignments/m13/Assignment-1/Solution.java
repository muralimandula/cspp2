import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
    //ThankYou

    /**
     * Size declaration for list.
     */
    private int size;

    /**
     * temporary size when to use intersection also.
     */
    private int tempsize;

    /**
     * our iterable int array.
     */
    private int[] list;

    /**
     * Initilising int capacity or size.
     */
    private final int listsize = 100;

    /**
     * Constructs the object.
     */
    Set() {
        list = new int[listsize];
        size = 0;
    }

    /**
     * returns size of out iterable list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    /**
     * returns boolean.
     *
     * @param      n     { parameter_description }
     *
     * @return    true/false.
     */
    public boolean contains(final int n) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == n) {
                c++;
            }
        }

        return c != 0;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            size = tempsize;
            return "{}";
        }
        String string = "{";
        for (int i = 0; i < size - 1; i++) {
            string = string + list[i] + ", ";
        }
        string = string + list[size - 1] + "}";
        size = tempsize;
        return string;
    }

    /**
     * add to the main list.
     *
     * @param      n  integer to add.
     */
    public void add(final int n) {
        list[size++] = n;
        // size += 1;
    }

    /**
    * hashcode.
    *
    * @return     this.hashCode().
    */
    // @Override
    // public int hashCode() {

    //  return this.hashCode();
    // }

    /**
     * inserting/adding list of integers.
     *
     * @param      addn  The addn
     */
    public void add(final int[] addn) {
        for (int i = 0; i < addn.length; i++) {
            if (!(contains(addn[i]))) {
                add(addn[i]);
            }
        }
    }


    /**
     * taking two integer arrays.
     *
     * @param      thisa  The thisa
     * @param      thatb  The thatb
     *
     * @return     { description_of_the_return_value }
     */
    public int[] intersection(final int[] thisa, final int[] thatb) {
        int[] newlist = new int[thatb.length];
        int newsize = 0;
        for (int i = 0; i < thatb.length; i++) {
            for (int j = 0; j < thisa.length; j++) {
                if (thisa[j] == thatb[i]) {
                    newlist[newsize] = thisa[j];
                    newsize += 1;
                }
            }
        }
        tempsize = size;
        size = newsize;
        return newlist;
    }

    /**
     * cartrsian of two int arrays.
     *
     * @param      thisa  The thisa
     * @param      thatb  The thatb
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final int[] thisa, final int[] thatb) {
        final int cpsize = thisa.length * thatb.length;
        int[][] cp = new int[cpsize][thisa.length];
        for (int i = 0; i < thisa.length; i++) {
            for (int j = 0; j < thatb.length; j++) {
                cp[i + j][0] = thisa[i];
                cp[i + j][1] = thatb[j];
            }
        }
        return cp;
    }

}


/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
// split the line using space
            String[] tokens = line.split(" ");
// based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                // Set t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                int[] a = intArray(tokens[1]);
                int[] b = intArray(tokens[2]);
                System.out.println(s.intersection(a, b));
                break;
            case "retainAll":
                s = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // System.out.println(s.intersection(intArray));
                int[] a1 = intArray(tokens[1]);
                int[] b1 = intArray(tokens[2]);
                System.out.println(s.intersection(a1, b1));
                break;
            case "cartesianProduct":
                s = new Set();
                // Set t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(Arrays.deepToString
                // (s.cartesianProduct(t)));
                int[] cp1 = intArray(tokens[1]);
                int[] cp2 = intArray(tokens[2]);
                System.out.println(s.cartesianProduct(cp1, cp2));
                break;
            default:
                break;
            }
        }
    }
}



