import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class Solution{


	public String[] byshow;

	public int size;
	// public String[] showtime;
	// public String[] Seats;
	// public String[] user;
	// public int[] mobilenum;
	// public String[] booking;
	//
	public Solution()
	{
	byshow = new String[100];
	size = 0;
	}


	public void add(final String addmovie) {
		byshow[size] = addmovie;
		size++;
	}


	public String getmovie(final String moviename, final String showtime) {
		for(int i = 0; i < size; i++) {
			// System.out.println(byshow[i]);
			// System.out.println(moviename);
			if(byshow[i].contains(moviename) && byshow[i].contains(showtime)) {
				return moviename + "," + showtime ;
			}
		}
		return "No show";
	}


    public String printbooking(final String moviename, final String showbooked, final String usercontact ) {
       		for(int i = 0; i < byshow.length; i++) {
			if(byshow[i].contains(moviename) && byshow[i].contains(usercontact)) {
				return usercontact + " " + moviename + " " + showbooked;
			}
		}
		return "No Booking";
    }

	public static void main(String[] args) {
	   	Solution addmovieobj = new Solution();
	    // Solution bookobj = new Solution();
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		while (input.hasNext()){


			String readinput = input.nextLine();
			String[] bysinput = readinput.split(","); //to take case add/book
			String[] bysmovie = bysinput[0].split(" ");
			String[] bysinput2 = readinput.split(" "); // to operate booking and adding

			switch (bysmovie[0]) {

	     		case "add":
					String moviename = bysmovie[1];
					String bysseats = bysinput2[4].substring(6);
					String movie;
					movie = moviename+"-"+bysinput[1]+"-"+bysseats;
					// System.out.println(movie);
					addmovieobj.add(movie);
					break;

				case "book":
					String moviename2 = bysmovie[1];
				    String userbooking;
				    String userseats = bysinput2[4].substring(24); // works for case1, because username is 6 chars
				    userbooking = moviename2+"-"+bysinput[1]+"-"+bysinput[2]+"-"+bysinput[3]+"-"+userseats;
                    // moviename - TimeStamp - username - usercontact

                     // bookobj.add(userbooking);
                    // System.out.println(userbooking);
                    addmovieobj.add(userbooking);
                    break;

                case "get":
                	String moviename3 = bysmovie[1];
                	String showtime = bysinput[1];
                    System.out.println(addmovieobj.getmovie(moviename3, showtime));
                    break;

                case "print":
                	String moviename4 = bysmovie[1];
                    String showbooked = bysinput[1];
                    String usercontact = bysinput[2];
                    // System.out.println(moviename + "-" + showtime + "-" + usercontact);
                    System.out.println(addmovieobj.printbooking(moviename4, showbooked, usercontact));
                    break;

                // case "show movies":
                //     System.out.println(addmovieobj.showmovies());
                //     break;

                default:
                	break;
			}
		}
	}

}