import java.util.*;
public class Chapter4Problems3 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter three sides of triangle: ");
		int s1 = console.nextInt();
		int s2 = console.nextInt();
		int s3 = console.nextInt();
		if (isTriangle(s1,s2,s3) == true){
			String triangleType = triangle(s1,s2,s3);
			
			System.out.printf("Triangle is a %s triangle.", triangleType);
		}
		else{
			System.out.println("Error, this is not a triangle.");
		}
		console.close();
		
		

	}
	// Checks to see if the sides make up a triangle.
	public static boolean isTriangle(int side1, int side2, int side3){
		boolean done = false;
		if (side1 + side2 > side3 && side2+side3 > side1 && side1+side3>side2){
			done = true;
		}
		return done;
	}

	// Determines what kind of triangle it is, if the sides have come back as valid to make
	//a triangle.
	private static String triangle(int side1, int side2, int side3) {
		String type = "";
		if (side1 == side2 && side2 == side3){// You can use the && here to show all sides are equal.
			type = "Equalateral";
		}
		else if (side1 == side2 || side2 == side3 || side3 == side1){// || means or.
			type = "Isoceles";
		}
		else{
			type = "Scalene";
		}
		return type;
	}

}
