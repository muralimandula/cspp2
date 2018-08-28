/**
*Going good, factorial now.
*20186065.
*/
import java.util.Scanner;

    /**
    *Main class.
    */
public final class Factorial {

    /**
    *some dummy constructor.
    */
    private Factorial() {
    }

    /**
    *Main method.
    @param args to get started
    */
    public static void main(final String[] args) {

        Scanner readInput = new Scanner(System.in);
        int number = readInput.nextInt();
        System.out.println(factNum(number));
    }

    /**
    *Main method.
    @param n to get number
    @return factorial of number
    */
    public static int factNum(final int n) {
        if ((n == 0) || (n == 1)) {
            return 1;
        } else {
            return n * factNum(n - 1);
        }
    }
}
