/**
 *20186065.
 *Binary to decimal.
 */
import java.util.Scanner;

/**
 * Main Class.
 */
public final class Solution {
  
  /**
   * Constructs the object.
   */
  private Solution() {
    //unused
  }
  /*
  Do not modify this main function.
  */
  /**
   * { main method }.
   *
   * @param      args  The arguments
   */

  public static void main(String[] args) {
    Scanner readInput = new Scanner(System.in);
    // int n = readInput.nextInt();
    int n = Integer.parseInt(readInput.nextLine());
    for(int i = 0; i < n; i++) {
        String s = readInput.nextLine();
        String res = binaryToDecimal(s);//Write binaryToDecimal function
        System.out.println(res);        
      }
    }

  /**
   * { function_description }
   *
   * @param      binary  The binary
   *
   * @return     { description_of_the_return_value }
   */

  public static String binaryToDecimal(String binary) {
    int length = binary.length();
    double sum = 0;
    for (int i = 0; i < length ; i++) {
      if (binary.charAt(i) == '1') {
        sum += Math.pow(2, ((length - i) - 1));
      }      
    }
    
    String result = Double.toString(sum);
    return (result.substring(0, (result.length() - 2)));
  }
}
