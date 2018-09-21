import java.util.Scanner;
import java.util.*;


// // class Frequency {

//     public String word;
//     public ArrayList<Integer>

// // }


public final class Plagarism {

    public static ArrayList<String[]> filestrings;
    public static ArrayList<Integer> filestringslength;

    public static ArrayList<String> uniqueWords;
    public static ArrayList<Integer[]> frequency;
    public static int lcs = 0;


    Plagarism() {
        filestrings = new ArrayList<>();
        filestringslength = new ArrayList<>();
        uniqueWords = new ArrayList<>();
        frequency = new ArrayList<>();
    }

    public static void main(String[] args) {

        Plagarism tocheck = new Plagarism();
        Scanner s = new Scanner(System.in);
        int no_files = s.nextInt();
        // System.out.println("Give "+no_files+" filenames one after the other");
        Scanner b = new Scanner(System.in);
        //another scanner to avoid index as null.

        for(int i = 0; i < no_files; i++) {
            //to clean the document

            String readfile = b.nextLine().toLowerCase().replaceAll("[^a-z0-9 '-]"," ").replaceAll(" +"," ");

            tocheck.addFilesLength(readfile.length());

            tocheck.addFiles((readfile.split(" ")));
        }

        for(String[] eachfile : tocheck.filestrings) {

            for(String word : eachfile) {
                tocheck.addMainWord(word);
            }
        }


        tocheck.getUniqueList();
        // tocheck.calculateFrequency(no_files);
        tocheck.getLcs();
        tocheck.percentageMatch();
    }

    public void addFilesLength(final Integer filelength) {
        filestringslength.add(filelength);
    }

    public void addFiles(final String[] filearr) {
        filestrings.add(filearr);
    }

    public void addMainWord(final String addword) {
        uniqueWords.add(addword);
    }

    public void getUniqueList() {

        Set<String> uniqueSet = new HashSet<String>(uniqueWords);
        //Duplicates deleted, but jumbled in order.

        uniqueWords = new ArrayList(uniqueSet);
        //converting back to arraylist, re assigning, only unique Strings now.

        Collections.sort(uniqueWords);
        //Sorted into an order now.
    }

    public void calculateFrequency(final int no_files) {

        int count = 0;
        // int length = 0;

        System.out.println("\n Words\t\tFile1\tFIle2\tDotProduct" );

        for(String eachunique : uniqueWords) {
        // For each unique word

        Integer[] wordcount = new Integer[no_files + 1];
        //Getting frequency of the word in each file.

        int filenum = 0;

            for(String[] eachfile : filestrings) {
                // Each file in the input files.
                count = 0; // to get frequency

                for(String wordinfile : eachfile) {
                    //Word in the file, to get occurence.
                    if(eachunique.equals(wordinfile)) {
                        count++;
                    }
                }
                wordcount[filenum] = count;
                // creating int[] for frequency of the word
                filenum++;
            }
            wordcount[filenum] = wordcount[0] * wordcount[1];
            frequency.add(wordcount); //adding frequency int[] for each word
        }

        for(int i = 0; i < uniqueWords.size(); i++) {
            System.out.print("\n " + uniqueWords.get(i) + "\t");

                for(int j = 0; j < frequency.get(i).length; j++) {
                    System.out.print("\t" + frequency.get(i)[j]);
                }
        }


        // System.out.println(stringlcs + " " + lcs);


    }

    public void getLcs() {

        String stringlcs = "";
        int commonsequence = 1;

        for(int i = 0; i < filestrings.size()-1; i++) {
            //Taking each file
            for(int j = 0; j < filestrings.get(i).length; j++) {
            // for(String eachlcsword : filestrings.get(i)) {
                //Each word in selected file.
                for(int k = 0; k < filestrings.get(i+1).length; k++) {

                // if(Arrays.asList(filestrings.get(i+1)).contains(eachlcsword)) {

                    if(filestrings.get(i)[j].equals(filestrings.get(i+1)[k])) {

                        System.out.println(filestrings.get(i)[j] + " line 150");
                        //checking the word existence

                       if(filestrings.get(i)[j].length() > lcs) {
                            lcs = filestrings.get(i)[j].length();
                            stringlcs = filestrings.get(i)[j];
                        }

                        while ((j+1 <= filestrings.get(i).length) && (k+1 <= filestrings.get(i+1).length)) {

                            System.out.println("while check  line 160");

                           if (filestrings.get(i)[++j].equals(filestrings.get(i+1)[++k])) {

                                System.out.println("Checking next word");

                                commonsequence++;
                                lcs = lcs + filestrings.get(i)[j].length() + 1;
                                stringlcs = stringlcs + " " +filestrings.get(i)[j];

                                System.out.println("\n\nlongest substring is -------------> " + stringlcs);

                            }
                        }
                        j = j - commonsequence;
                        k = k - commonsequence;
                    }
                }
            }
        }

        System.out.println("\n\n Longest common substring is : " + stringlcs + " - " + lcs);
        // System.out.println(uniqueWords);
        // System.out.println(Arrays.toString(filestrings.get(0)));
        // System.out.println(Arrays.toString(filestrings.get(1)));
    }

    public void percentageMatch() {

         double totalLengthOfFiles = (double)filestringslength.get(0) + filestringslength.get(1);
         // double percanetageMatch = (( lcs * 2 ) / totalLengthOfFiles ) * 100;

         System.out.println("\n Percentage Match is : " + (int)Math.floor((( lcs * 2 ) / totalLengthOfFiles ) * 100) + "%");
         // System.out.println(Double.parseDouble((lcs * 2) / totalLengthOfFiles));

    }




}