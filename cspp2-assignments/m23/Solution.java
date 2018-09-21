import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.io.File;

class Document {

  /**
   * given input document.
   */
  private String[] doc;

  /**
   * frequency of words in the given document.
   */
  private HashMap <String, Integer> docFreq;

  /**
   * Constructs the object.
   *
   * @param      docx  The docx
   */
  Document(final String[] docx) {
    doc = docx;
    docFreq = new HashMap<>();
  }

  public String[] getDoc() {
    return doc;
  }

  /**
   * Gets the frequency.
   *
   * @return     The frequency.
   */
  public HashMap getFreq() {
    for (String word : doc) {
      if (word != " " && word != "") {
        if (!docFreq.containsKey(word)) {
          docFreq.put(word, 1);
        } else {
          docFreq.put(word, docFreq.get(word) + 1);
        }
      }
    }
    return docFreq;
  }

  /**
   * Gets the word frequency.
   *
   * @param      word2  The word 2
   *
   * @return     The word frequency.
   */
  public Integer getWordFreq(final String word) {
    return docFreq.get(word);
  }

  /**
   * Gets the key set.
   *
   * @return     The key set.
   */
  public Set getKeySet() {
    return docFreq.keySet();

  }

  /**
   * Gets the modulus.
   *
   * @return     The modulus.
   */
  public double getMod() {
    double mod = 0;
    for (String word : docFreq.keySet()) {
      mod = mod + Math.pow(this.getWordFreq(word), 2);
      // System.out.println(word + ": " + getWordFreq(word) + " " + mod);
    }
    // System.out.println("\n");
    return Math.sqrt(mod);
  }

  public int getDist(final Document doc) {

    Integer dotProd = 0;
    double docDist = 0.0;

    Set<String> f1 = new HashSet<>();
    Set<String> f2 = new HashSet<>();
    Set<String> fComb = new HashSet<>();

    f1 = this.getFreq().keySet();
    f2 = doc.getFreq().keySet();

    fComb.addAll(f1);
    fComb.addAll(f2);

    // System.out.println(f1);
    // System.out.println(f2);
    // System.out.println(fComb);

    for (String key : fComb) {
      if (f1.contains(key) && f2.contains(key)) {
        dotProd += this.getWordFreq(key) * doc.getWordFreq(key);
      }
    }

    docDist = dotProd / (this.getMod() * doc.getMod());

    return (int) Math.round(docDist * 100);
  }

}

public class Solution {

  public static int lcs(final String s1, final String s2) {
    int l1 = s1.length();
    int l2 = s2.length();

    int max = 0;
    double lcsPer = 0.0;

    int[][] lcString = new int[l1][l2];

    for (int i = 0; i < l1; i++) {
      for (int j = 0; j < l2; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          if (i == 0 || j == 0) {
            lcString[i][j] = 1;
          } else {
            lcString[i][j] = lcString[i - 1][j - 1] + 1;
          }
          if (max < lcString[i][j]) {
            max = lcString[i][j];
          }
        }
      }
    }
    // System.out.println(max);
    // System.out.println(l1);
    // System.out.println(l2);
    lcsPer = (2 * max * 100) / (l1 + l2);
    return (int) lcsPer;
  }

  public static void main(String[] args) {
    ArrayList<String> input = new ArrayList<String>();
    ArrayList<String> inputString = new ArrayList<String>();
    ArrayList<String> inputnames = new ArrayList<String>();

    Scanner sc = new Scanner(System.in);
    String string = sc.next();
    String heading = "\t\t\t";

    File file = new File(string);
    File[] listOfFiles = file.listFiles();

    for (File file1 : listOfFiles) {
      try {
        inputnames.add(file1.getName());
        heading = heading + file1.getName() + "\t";
        Scanner sc1 = new Scanner(file1);
        String s = "";
        while (sc1.hasNext()) {
          s += sc1.nextLine() + " ";
        }
        // System.out.println(s);
        input.add(s.replaceAll("[^a-zA-Z0-9 ]", " ").replaceAll(" +", " ").toLowerCase());
        inputString.add(s);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println(heading);
    for (int i = 0; i < input.size(); i++) {
      String sOut = inputnames.get(i) + "\t\t";
      Document docCheck = new Document(input.get(i).split(" "));
      for (int j = 0; j < input.size(); j++) {
        Document docCheckWith = new Document(input.get(j).split(" "));
        sOut += docCheck.getDist(docCheckWith);
        sOut += "\t\t";
        // System.out.println(docCheck.getDist(docCheckWith));
      }
      System.out.println(sOut);
    }

    System.out.println("\n");

    for (int i = 0; i < inputString.size(); i++) {
      for (int j = 0; j < inputString.size(); j++) {
        System.out.println(lcs(inputString.get(i), inputString.get(j)));
      }
    }

  }
}
