
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
    Scanner sc=new Scanner(System.in);
    int n= sc.nextInt();
    for(int i=0;i<=n;i++) {
        String s=sc.nextLine();
        double res=binaryToDecimal(s);//Write binaryToDecimal function
        System.out.println(res);        

      }
    }

  public static double binaryToDecimal(String binary)
  {
    double sum = 0;
    int[] bin = new int[binary.length()];

    for (int i = 0; i < binary.length() ; i++) {
      bin[i] = binary.charAt(i) - '0';
      
    }

    for (int i=(binary.length()-1) ; i>=0 ; i--) {
      sum = sum + (bin[i]*(Math.pow(2, i)));
    }
    return sum;
  }
}
