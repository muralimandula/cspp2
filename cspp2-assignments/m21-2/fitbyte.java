import java.util.ArrayList;

class foodlog {

	private String date, name, time, quantity;

	foodlog(final String[] arg) {

		name = arg[0];
		quantity = arg[1];
		date = arg[2];
		time = arg[3];
	}

	public String getdate() {
		return date;
	}


	public String toString() {
		return "Date:" + date + "\n" + "Time:" + time + "\n"
		       + "Name:" + name + "\n" + "Quantity:" + quantity;
	}

}

class waterlog {

	private String quantity, date, time;

	waterlog(final String[] arg) {

		date = arg[0];
		time = arg[1];
		quantity = arg[2];
	}

	public String getdate() {
		return date;
	}

	public String toString() {
		return "Date:" + date + "\n" + "Quantity:"
		       + quantity + "ml";
	}

}

class activitylog {

	private String date, name, startTime, endTime, notes;

	activitylog(final String[] arg) {

		date = arg[2];
		name = arg[0];
		startTime = arg[3];
		endTime = arg[4];
		notes = arg[1];
	}

	public String getdate() {
		return date;
	}

	public String toString() {
		return "Name:" + name + "\n" + "Notes:" + notes + "\n"
		       + "Date:" + date + "\n" + "Starttime:" + startTime + "\n"
		       + "Endtime:" + endTime;
	}

}

class sleeplog {
	private String date, startTime, endTime;

	sleeplog(final String[] arg) {
		date = arg[0];
		startTime = arg[1];
		endTime = arg[2];
	}

	public String getdate() {
		return date;
	}

	public String toString() {
		return "Date:" + date + "\n"
		       + "Starttime:" + startTime + "\n" + "Endtime:" + endTime;
	}
}

class weightlog {
	private String date, time, weight, fatPer;

	weightlog(final String[] arg) {
		date = arg[0];
		time = arg[1];
		weight = arg[2];
		fatPer = arg[3];
	}

	public String getdate() {
		return date;
	}

	public String toString() {
		return "Date:" + date + "\n" + "Time:" + time + "\n"
		       + "Weight:" + weight + "\n" + "Fat:" + fatPer;
	}
}

public class fitbyte {
	private ArrayList<foodlog> food;
	private ArrayList<waterlog> water;
	private ArrayList<activitylog> activity;
	private ArrayList<sleeplog> sleep;
	private ArrayList<weightlog> weight;

	fitbyte() {
		food = new ArrayList<>();
		water = new ArrayList<>();
		activity = new ArrayList<>();
		sleep = new ArrayList<>();
		weight = new ArrayList<>();
	}

	public void addFood(final foodlog item) {
		food.add(item);
	}

	public void addWater(final waterlog item) {
		water.add(item);
	}

	public void addActivity(final activitylog item) {
		activity.add(item);
	}

	public void addSleep(final sleeplog item) {
		sleep.add(item);
	}

	public void addWeight(final weightlog item) {
		weight.add(item);
	}

	public void foodSumm() {
		for (foodlog entry : food) {
			System.out.println(entry);
		}
	}

	public void waterSumm() {
		for (waterlog entry : water) {
			System.out.println(entry);
		}
	}

	public void activitySumm() {
		if (activity.isEmpty()) {
			System.out.println("None");
			return;
		}
		for (activitylog entry : activity) {
			System.out.println(entry);
		}
	}

	public void sleepSumm() {
		for (sleeplog entry : sleep) {
			System.out.println(entry);
		}
	}

	public void weightSumm() {
		for (weightlog entry : weight) {
			System.out.println(entry);
		}
	}

	public void summary() {
		System.out.println("Food");
		for (foodlog entry : food) {
			System.out.println(entry);
		}
		System.out.println("Water");
		for (waterlog entry : water) {
			System.out.println(entry);
		}
		System.out.println("PhysicalActivity");
		if (activity.isEmpty()) {
			System.out.println("None");
		} else {
			for (activitylog entry : activity) {
				System.out.println(entry);
			}
		}
		System.out.println("Weight");
		for (weightlog entry : weight) {
			System.out.println(entry);
		}
		System.out.println("Sleep");
		for (sleeplog entry : sleep) {
			System.out.println(entry);
		}

	}

	public void summary(final String day) {
		System.out.println("Food");
		for (foodlog entry : food) {
			if (entry.getdate().equals(day)) {
				System.out.println(entry);
			}
		}
		System.out.println("Water");
		for (waterlog entry : water) {
			if (entry.getdate().equals(day)) {
				System.out.println(entry);
			}
		}
		System.out.println("PhysicalActivity");
		for (activitylog entry : activity) {
			if (entry.getdate().equals(day)) {
				System.out.println(entry);
			}
		}
		System.out.println("Weight");
		for (weightlog entry : weight) {
			if (entry.getdate().equals(day)) {
				System.out.println(entry);
			}
		}
		System.out.println("Sleep");
		for (sleeplog entry : sleep) {
			if (entry.getdate().equals(day)) {
				System.out.println(entry);
			}
		}

	}


}
