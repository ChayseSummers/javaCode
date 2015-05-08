import java.util.Scanner;


public class Chap4Problems2 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = console.nextInt();
		double sum1 = sum(n);
		double sum2 = sum2(n);
		console.close();
		System.out.println("Sum: "+sum1);
		System.out.println("Sum with odds: "+sum2);
		
//		String s1 = "Chayse", s2 = "chayse";
//		
//		int i = 437;
//		double d = 45.584548;
//		
//		System.out.println(s1.equalsIgnoreCase(s2));
//		// Use .equals when not comparing primitive value types such as strings.
//		
//		System.out.printf("Some %d value: %d %f %s", i, i*2, d, s1);
//		// Syntax goes that the first %d/%s/%f will be placed in same order as they are
//		//after the "," .
//		
//		String oneS = "Region 1", twoS = "Region 2", threeS = "Region 3";
//		double i = 13, j = 19, k = 23;
//		
//		System.out.printf("%12s %12s %12s%n", oneS,twoS,threeS);
//		// Creates header for columns, can be made into capitals by using %S.
//		
//		for (int x=1;x<=10;x++){
//			double rand = (Math.random()*123);
//			
//			// FOR INTS
//			//System.out.println(i*rand+" "+j*rand+" "+k*rand);
//			// Don't use this println statement as it's too bulky and not efficient.
//			//Instead use the printf statement below.
//			
//			//System.out.printf("%-6d %-6d %-6d%n",i*rand,j*rand,k*rand);
//			// In this print f statement, %n carries it down to the next line
//			//like a println statement would. The spaces between %6d aren't necessary
//			//but do make it easier to read. Without the 6 in the %6d, they would use
//			//the space between the %d's.
//			
//			// FOR FLOATS
//			System.out.printf("%12.4f %12.4f %12.4f%n",i*rand,j*rand,k*rand);
//			// You'll want to do floats on the right allignment.
//			
//		}
		
	}


	private static double sum2(int n) {
		double sum = 0.0;
		for(int i = 1; i<= n; i++){
			if (i%2 == 1){ // Makes i odd.
				sum = sum + (1.0/(i*i));
			}	
		}
		return sum;
	}
	

	private static double sum(int n) {
		double sum = 0.0;
		for(int i = 1; i<= n; i++){
			sum = sum + (1.0/(i*i));
		}
		return sum;	
	}


	
}
