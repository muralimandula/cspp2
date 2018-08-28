/**
  * 20186065.
  * Java: DecimalNumbers.
  */
import java.util.Scanner;
  /**
  * Java: main class.
  */
public final class DecimalNumbers {
  /**
  * 20186065.
  * Java: DecimalNumbers.
  */

   private DecimalNumbers() {
   }
  /**Function for conversion.
  @param args argument reader.
  */

  public static void main(final String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.print("Enter temperature in degrees : ");
  final  int degrees = input.nextInt();
  final int fahrenheit = (degrees + 32);
  System.out.println("Temperature in fahrenheit scale is :" + fahrenheit);
  }
}
