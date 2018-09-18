import java.util.ArrayList;
import java.util.Scanner;




class Foodlog {

	private String foodname;
	private double quantity;
	private int date;
	private String time;
	private String dietstatus;

	Foodlog() {

	}

	Foodlog(final String food, final double quantityoffood,
			  final int dateconsunmed, final String timeofconsumption,
			 							 final String dietstatusinput) {
		this.foodname = food;
		this.quantity = quantityoffood;
		this.date = dateconsunmed;
		this.time = timeofconsumption;
		this.dietstatus = dietstatusinput;
	}

	public void setFoodname(final String foodname) {
		this.foodname = foodname;
	}

	public String getFoodname() {
		return foodname;
	}



	public void setQuantity(final double quantity) {
		this.quantity = quantity;
	}

	public double getQuantity() {
		return quantity;
	}



	public void setTIme(final String time) {
		this.time = time;
	}

	public String getTIme() {
		return time;
	}


	public void setDate(final int date) {
		this.date = date;
	}

	public int getDate() {
		return date;
	}


	public void setStatus(final String dietStatusToSet) {
		this.dietstatus = dietStatusToSet;
	}

	public String getStatus() {
		return dietstatus;
	}

}



class Waterlog {

	private double waterquantity;
	private int date;
	private String dietstatus;


	Waterlog() {

	}

	Waterlog(final double waterconsumed, final int dateconsumed, final String dietstatusinput) {
		this.waterquantity = waterconsumed;
		this.date = dateconsumed;
		this.dietstatus = dietstatusinput;
	}


	public void setWaterQuantity(final double water) {
		this.waterquantity = water;
	}

	public double getWaterQuantity() {
		return waterquantity;
	}


	public void setDateConsumed() {
		this.date = date;
	}

	public int getDateConsumed() {
		return date;
	}

	public void setStatus(final String dietStatusToSet) {
		this.dietstatus = dietStatusToSet;
	}

	public String getStatus() {
		return dietstatus;
	}

}



class Weight {

	private double weight;
	private double fat;
	private int date;

	Weight() {

	}

	Weight(double weightonday, double fatonweight, int dateChecked) {
		this.weight = weightonday;
		this.fat = fatonweight;
		this.date = dateChecked;
	}


	public void setWeight(final double weightonday) {
		this.weight = weightonday;
	}

	public double gatWeight() {
		return weight;
	}



	public void setFat(final double fatonweight) {
		this.fat = fatonweight;
	}

	public double getFate() {
		return fat;
	}



	public void setDate(final int dateChecked) {
		this.date = dateChecked;
	}

	public int getDate() {
		return date;
	}

}



class PhysicalActivity {

	private String activitytype;
	private String activityname;
	private int date;
	private String starttime;
	private String endtime;
	private String dietstatus;
	private String notesonactivity;


	PhysicalActivity(final String activitytypephy,
			 final String activitynamephy, final int datephy,
				final String starttimephy,	final String endtimephy,
				final String notesonactivityphy, final String dietstatusinput) {
		this.activitytype = activitytypephy;
		this.activityname = activitynamephy;
		this.date = datephy;
		this.starttime = starttimephy;
		this.endtime = endtimephy;
		this.notesonactivity = notesonactivityphy;
		this.dietstatus = dietstatusinput;
	}

	public void setActivityType(final String activitytypephy) {
		this.activityname = activitytypephy;
	}

	public void setActivityName(final String activitynamephy) {
		this.activityname = activitynamephy;
	}

	public void setDate(final int datephy) {
		this.date = datephy;

	}

	public void setStartTime(final String starttimephy) {
		this.starttime = starttimephy;

	}

	public void setEndTime(final String endtimephy) {
		this.endtime = endtimephy;
	}

	public void setNotesOnActivity(final String notesonactivityphy) {
		this.notesonactivity = notesonactivityphy;
	}

	public void setStatus(final String dietStatusToSet) {
		this.dietstatus = dietStatusToSet;
	}

	public String getStatus() {
		return dietstatus;
	}

	public String getActivityType() {
		return activityname;
	}

	public String getActivityName() {
		return activityname;
	}


	public int getDate() {
		return date;

	}


	public String getStartTime() {
		return starttime;

	}


	public String getEndTime() {
		return endtime;
	}


	public String getNotesOnActivity() {
		return notesonactivity;
	}
}

class SleepLog {

	private int startdate;
	private String startdatetime;
	private int enddate;
	private String enddatetime;
	private String dietstatus;


	SleepLog(final int startdateOFsleep, final String startdatetimeOFsleep,
	 			final int enddateOFsleep, final String enddatetimeOFsleep, final String dietstatusinput) {
		this.startdate = startdateOFsleep;
		this.startdatetime = startdatetimeOFsleep;
		this.enddate = enddateOFsleep;
		this.enddatetime = enddatetimeOFsleep;
		this.dietstatus = dietstatusinput;
	}

	public void setStatus(final String dietStatusToSet) {
		this.dietstatus = dietStatusToSet;
	}

	public String getStatus() {
		return dietstatus;
	}

}




class Fitness {

	public ArrayList<Foodlog> foodDiet;
	private ArrayList<Waterlog> waterOnDiet;
	private ArrayList<SleepLog> sleepOnDiet;
	private ArrayList<Weight> weightOnDiet;

	Fitness() {

		foodDiet = new ArrayList<>();
		waterOnDiet = new ArrayList<>();
		sleepOnDiet = new ArrayList<>();
		weightOnDiet = new ArrayList<>();
	}

	public void addFoodDiet(Foodlog foodDitepassed) {
		foodDiet.add(foodDitepassed);
	}

	public void addWaterOnDiet(Waterlog wateondietDitepassed) {
		waterOnDiet.add(wateondietDitepassed);
	}

	public void addSleepOnDiet(SleepLog sleeponDitepassed) {
		sleepOnDiet.add(sleeponDitepassed);
	}

	public void addWeightOnDiet(Weight weightondiet) {
		weightOnDiet.add(weightondiet);

	}

}


public class Fitbyte {


	public int fitbytehistory = 0;
	public int fitbytetodo = 0;

	Fitbyte() {

	}

	public static void main(String[] args) {

		Fitness fitbyte = new Fitness();
		Scanner readDiet = new Scanner(System.in);
		while (readDiet.hasNext()) {

			String dietnote = readDiet.nextLine();
			String[] fbinput = dietnote.split(" ");
			switch(fbinput[0]) {


				case "Food":

					fitbyte.addFoodDiet(new Foodlog(fbinput[1], Double.parseDouble(fbinput[2]),
														 Integer.parseInt(fbinput[3]), fbinput[4], fbinput[5]));

				break;
			    case "Water":

			     	fitbyte.addWaterOnDiet(new Waterlog(Double.parseDouble(fbinput[1]),
			     													 Integer.parseInt(fbinput[2]), fbinput[3]));
			     	break;
			    case "Sleep":

			    	fitbyte.addSleepOnDiet(new SleepLog(Integer.parseInt(fbinput[1]), fbinput[2],
			    										 Integer.parseInt(fbinput[3]), fbinput[4], fbinput[5]));
			    	break;

			    case "DisplayFoodLog":
			    	displayFoodlog(fitbyte);

			    case "Display ToDo":


			    case "Disply History":

			}
		}
	}


	public static void displayFoodlog(Fitness fitbyte) {

		System.out.println("Food Name" + "\t" + "Quantity(kg)" + "\t" + "Date" + "\t" + "Time" + "\t" + "Status");
		System.out.println("--------------------------------------------------------");
		for(Foodlog e : fitbyte.foodDiet)  {
			System.out.println(e.getFoodname() + "\t\t" + e.getQuantity()+" kg" +
									 "\t\t" + e.getDate() + "\t" + e.getTIme() + "\t" + e.getStatus());
		}

	}





}


