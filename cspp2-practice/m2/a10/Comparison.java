/**
*Trying Something again.
*/
import java.util.Scanner;

/**
*main clas for Comparing two numbers.
*/
public final class Comparison {
    /**
    *juat a private constructor private.
    */
    private Comparison() {
    //abstraction
    }
    /**
    *writing aarea of circle.
    @param args string on construction
    */
    public static void main(final String[] args) {
        Scanner numberInput = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int varA = numberInput.nextInt();
        System.out.print("Enter second number : ");
        int varB = numberInput.nextInt();
        compare(varA, varB);
    }

    /**
    *writing aarea of circle.
    @param a a getting a,b
    @param b b getting a,b
    */
    public static void compare(final int a, final int b) {
        if (a > b) {
            System.out.println("Bigger");
        } else if (a == b) {
            System.out.println("Equal");
        } else {
            System.out.println("Smaller");
        }
    }
}
