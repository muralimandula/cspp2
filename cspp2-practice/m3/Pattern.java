/**
* 20186065
* pattern
* main class
*/
public final class Pattern {

  /**
  * Constructs the object.
  */
  private Pattern() {
    //unused
  }

  /**
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    final int numLines = 5;
    for (int i = 1; i <= numLines; i++) {
      String pattern = "";
      for (int j = 1; j <= i; j++) {
        pattern = pattern + j + " ";
      }
      System.out.println(pattern);
    }
  }
}
