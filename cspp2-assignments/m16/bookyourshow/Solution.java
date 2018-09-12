import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {

    /**
     * { var_description }.
     */
    private String[] byshow;


    /**
     * { var_description }.
     */
    private int size;

    /**
     * { var_description }.
     */
    private final int byssize = 100;

    /**
     * Constructs the object..
     */
    public Solution() {
        byshow = new String[byssize];
        size = 0;
    }

    /**
     * { function_description }.
     *
     * @param      addmovie  The addmovie
     */
    public void addmovie(final String addmovie) {
        byshow[size] = addmovie;
        size++;
    }

    /**
     * { function_description }.
     *
     * @param      addmovie      The addmovie
     * @param      moviename2    The moviename 2
     * @param      bookshowtime  The bookshowtime
     */
    public void addbooking(final String addmovie,
     final String moviename2, final String bookshowtime) {
            int bookingcount = 0;
            for (int i = 0; i < size; i++) {
                if (byshow[i].contains(moviename2)
                    && byshow[i].contains(bookshowtime)) {
                    byshow[size] = addmovie;
                    size++;
                    bookingcount++;
                }
            }
            if (bookingcount == 0) {
                System.out.println("No show");
            }
        }


    /**
     * { function_description }.
     *
     * @param      moviename  The moviename
     * @param      showtime   The showtime
     *
     * @return     { description_of_the_return_value }
     */
    public String getmovie(final String moviename, final String showtime) {
        for (int i = 0; i < size; i++) {
            if (byshow[i].contains(moviename)
             && byshow[i].contains(showtime)) {
                return moviename + "," + showtime;
            }
        }
        return "No show";
    }

    /**
     * { function_description }.
     *
     * @param      moviename    The moviename
     * @param      showbooked   The showbooked
     * @param      usercontact  The usercontact
     *
     * @return     { description_of_the_return_value }
     */
    public String printbooking(final String moviename,
     final String showbooked, final String usercontact) {
        for (int i = 0; i < size; i++) {
            if ((byshow[i].contains(moviename)
             && byshow[i].contains(usercontact)) && byshow[i].contains(showbooked)) {
                return usercontact + " " + moviename + " " + showbooked;
            }
        }
        return "Invalid";
    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int a = 3, b = 4, c = 6, d = 24;
        Solution addmovieobj = new Solution();
        // Solution bookobj = new Solution();
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while (input.hasNext()) {


            String readinput = input.nextLine();
            String[] bysinput = readinput.split(",");
             //to take case add/book
            String[] bysmovie = bysinput[0].split(" ");
            String[] bysinput2 = readinput.split(" ");
             // to operate booking and adding

            switch (bysmovie[0]) {

            case "add":
                String moviename = bysmovie[1];
                String bysseats = bysinput2[b].substring(c);
                String movie;
                movie = moviename + "-" + bysinput[1] + "-" + bysseats;
                // System.out.println(movie);
                addmovieobj.addmovie(movie);
                break;

            case "book":
                String userbooking;
                String moviename2 = bysmovie[1];
                String bookshowtime = bysinput[1];
                String username = bysinput[2];
                String bookusercontact = bysinput[a];
                String userseats = bysinput2[b].substring(d);
                 // works for case1, because username is 6 chars
                userbooking = moviename2 + "-" + bookshowtime
                 + "-" + username + "-" + bookusercontact + "-" + userseats;

                addmovieobj.addbooking(userbooking, moviename2, bookshowtime);
                break;

            case "get":
                String moviename3 = bysmovie[1];
                String showtime = bysinput[1];
                System.out.println(
                addmovieobj.getmovie(moviename3, showtime));
                break;

            case "print":
                String moviename4 = bysmovie[1];
                String showbooked = bysinput[1];
                String usercontact = bysinput[2];
                // System.out.println(moviename + "-" +
                 // showtime + "-" + usercontact);
                System.out.println(addmovieobj.printbooking(moviename4,
                 showbooked, usercontact));
                break;

            default:
                break;
            }
        }
    }

}
