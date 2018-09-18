import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		fitbyte person = new fitbyte();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] inputs = line.split(" ");
			switch (inputs[0]) {
			case "Food":
				person.addFood(new foodlog(inputs[1].split(",")));
				break;
			case "Water":
				person.addWater(new waterlog(inputs[1].split(",")));
				break;
			case "PhysicalActivity":
				person.addActivity(new activitylog(inputs[1].split(",")));
				break;
			case "Weight":
				person.addWeight(new weightlog(inputs[1].split(",")));
				break;
			case "Sleep":
				person.addSleep(new sleeplog(inputs[1].split(",")));
				break;
			case "Foodlog":
				System.out.println("Food");
				person.foodSumm();
				System.out.print("\n");
				break;
			case "Waterlog":
				System.out.println("Water");
				person.waterSumm();
				System.out.print("\n");
				break;
			case "PhysicalActivitylog":
				System.out.println("PhysicalActivity");
				person.activitySumm();
				System.out.print("\n");
				break;
			case "Weightlog":
				System.out.println("Weight");
				person.weightSumm();
				System.out.print("\n");
				break;
			case "Sleeplog":
				System.out.println("Sleep");
				person.sleepSumm();
				System.out.print("\n");
				break;
			case "Summary":
				if (inputs.length == 1) {
					person.summary();
				} else {
					person.summary(inputs[1]);
				}
				break;
			default:
				break;
			}

		}
	}
}


