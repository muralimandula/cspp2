/**
  * 20186065.
  * Java: Swapping.
  */
public final class Swap {
  /**
  * Java: main class.
  */
   private Swap() {
    /**
    * Java: Empty constructor.
    */
   }

   /**
  * 20186065.
  * Java: Swapping.
  @param args argument reader
  */

  public static void main(final String[] args) {
    final int a = 10;
    int b = 2;
    int temp = 0;
    System.out.println("Before swapping a, b are: " + a + ", " + b);
    temp = a;
    a = b;
    b = temp;
    System.out.println("After swapping a, b are: " + a + ", " + b);
  }
}
