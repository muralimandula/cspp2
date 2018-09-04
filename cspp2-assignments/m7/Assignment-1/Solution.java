import java.util.Scanner;
/**
 * another class for input validation.
 */
final class InputValidator {


    /**
     * { var_description }.
     */
    private String input;

    /**
     * Constructs the object.
     *
     * @param      inp  The input
     */
    InputValidator(final String inp) {
        this.input = inp;
    }


    /**
     * { function_description }.
     * makes use of this."created_object" with in InputValidator class.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        final int val = 6;
        if (input.length() >= val) {
            return true;
        }
        return false;
    }
}


/**
 * Class for solution, Main.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused dummy constructor.
    }


    /**
     * { item_description }.
     * @param args of type string
     */
    public static void main(final String[] args) {
        Scanner readInput = new Scanner(System.in);
        String input = readInput.nextLine();
        InputValidator obj = new InputValidator(input);
        //Object created in InputValidator class.
        // Object "object" with attribute "input"
        System.out.println(obj.validateData());
    }
}

