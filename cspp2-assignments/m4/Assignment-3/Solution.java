
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
  Do not modify this main function.
  */
  /**
   * { main method }.
   *
   * @param      args  The arguments
   */

  public static void main(String[] args)
  {
    Scanner readInput = new Scanner(System.in);
    int n = readInput.nextInt();
    for(int i=0; i<=n; i++) {
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

  public static String binaryToDecimal(String binary)
  {
    int length = binary.length();
    double sum = 0;
    for (int i = 0; i < length ; i++ ) {
      if (binary.charAt(i) == '1') {
        sum += Math.pow(2, ((length-i)-1));
      }      
    }
    
    String result = Double.toString(sum);
    return (result.substring(0,(result.length()-2)));
   
  }
}
