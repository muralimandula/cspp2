import java.util.Scanner;
import java.io.File;
/**
 * Class for string match.
 */
class StringMatch {

    /**
     * String 1.
     */
    private String string1 = "";
    /**
     * String 2.
     */
    private String string2 = "";
    /**
     * Result.
     */
    private double result;
    /**
     * Constructs the object.
     *
     * @param      file1  The file 1
     * @param      file2  The file 2
     */
    StringMatch(final File file1, final File file2) {
        try {
            Scanner scan = new Scanner(file1);
            while (scan.hasNext()) {
                string1 += scan.nextLine();
            }
            scan = new Scanner(file2);
            while (scan.hasNext()) {
                string2 += scan.nextLine();
            }
            String stringMatch = "";
            for (int i = 0; i < string2.length(); i++) {
                for (int j = i + 1; j <= string2.length(); j++) {
                    if (string1.contains(string2.substring(i, j))) {
                        if (string2.substring(i, j)
                            .length() > stringMatch.length()) {
                            stringMatch = string2.substring(i, j);
                        }
                    }
                }
            }
            if (file1.getName().equals(file2.getName())) {
                result = Math.pow((2 * 2 * 2) + 2, 2);
                System.out.format("%13.1f", result);
            } else {
                double numerator = (stringMatch.length() * 2)
                 * Math.pow(((2 * 2 * 2) + 2), 2);
                double denominator = string1.length() + string2.length();
                result = Math.round(numerator / denominator);
                System.out.format("%13.1f", result);
            }
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
    }
    /**
     * Gets the similarity.
     *
     * @return     The similarity.
     */
    public double getSimilarity() {
        return result;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Not Using the Constructor.
    }

    /**
     * Main FUnction.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String readFolder = scan.nextLine();
            File folder = new File(readFolder);
            File[] listOfFiles = folder.listFiles();
            double max = 0;
            String file1 = "";
            String file2 = "";
            System.out.print("             ");
            for (int i = 0; i < listOfFiles.length - 1; i++) {
                System.out.print(listOfFiles[i].getName() + "    ");
            }
            System.out.print(listOfFiles[listOfFiles.length - 1].
                getName() + " ");
            System.out.println();
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.print(listOfFiles[i].getName());
                for (int j = 0; j < listOfFiles.length; j++) {
                    StringMatch sm = new StringMatch(listOfFiles[i],
                        listOfFiles[j]);
                    double s = sm.getSimilarity();
                    if (s > max && !listOfFiles[i].getName().
                        equals(listOfFiles[j].getName())) {
                        max = s;
                        file1 = listOfFiles[i].getName();
                        file2 = listOfFiles[j].getName();
                    }
                }
                System.out.print(" ");
                System.out.println();
            }
            System.out.println("Maximum similarity is between " + file1
                + " and " + file2);
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
    }
}
