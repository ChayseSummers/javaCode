import java.util.*;

public class Chapter4Problems {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		introduction();
		
		System.out.println("Enter 1st person's information:");
		double height1 = getHeight(console);
		double weight1 = getWeight(console);
		System.out.println("Enter next person's information:");
		double height2 = getHeight(console);
		double weight2 = getWeight(console);
	
		double bmi1 = computeBMI(height1, weight1);
		double bmi2 = computeBMI(height2, weight2);
		
		System.out.println("Person 1 BMI: "+bmi1);
		weightClass(bmi1);
		System.out.println("Person 2 BMI: "+bmi2);
		weightClass(bmi2);
	}

	public static void weightClass(double bmi) {
		
		if(bmi <= 18.5){
			System.out.println("Underweight");
		}
		else if (bmi <= 24.9){
			System.out.println("Target weight");
		}
		else if (bmi <= 29.9){
			System.out.println("Overweight");
		}
		else{
			System.out.println("Superweight!");
		}
	}

	public static double computeBMI(double height, double weight) {
		double bmi1 = weight/(height*height)*703.0;
		return bmi1;
	}

	private static double getHeight(Scanner console) {
		System.out.print("height (in inches)?");
		double height = console.nextDouble();
		return height;
	}

	private static double getWeight(Scanner console) {
		System.out.print("weight (in pounds)?");
		double weight = console.nextDouble();
		return weight;
	}

	private static void introduction() {
		System.out.println("This program reads data for two people ");
		System.out.println("and computes their body mass index (BMI).");
	}
		
	
	
}



