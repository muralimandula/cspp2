/**
*Assignment -2.
* Quadratic Equations.
*/
import java.util.Scanner;
/**
*Main class - Solution Class
*/
public class Solution {
	/**
	*Do not modify this main function.
	@param args Format need
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	*Need to write the rootsOfQuadraticEquation function and print the output.
	@param a a
	@param b b
	@param c c
	*/
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		double root1 = (-b + (Math.sqrt((b * b)-(4 * a * c)))) / (2 * a);
		double root2 = (-b - (Math.sqrt((b * b)-(4 * a * c)))) / (2 * a);
		System.out.println(root1);
		System.out.println(root2);
	}
}
