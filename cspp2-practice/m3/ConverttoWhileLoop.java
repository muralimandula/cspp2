/**
 * { the only class }.
 */
public final class ConverttoWhileLoop {
  /**
   * Constructs the object.
   */

  private ConverttoWhileLoop() {
    //unused
  }

  /**
   * { main fucntion }.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    int i = 0;
    while (i < 10) {
      i = i + 2;
      System.out.println(i);
    }
    System.out.println("Goodbye!");
  }
}
