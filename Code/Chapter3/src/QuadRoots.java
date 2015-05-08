
import java.util.*;
public class QuadRoots {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter a coefficient a: ");
		double a = console.nextDouble();
		
		System.out.print("Enter a coefficient b: ");
		double b = console.nextDouble();
		
		System.out.print("Enter a coefficient c: ");
		double c = console.nextDouble();
		//double a = 1.0, b=4.0, c=4.0;
		 
		
		double solution1 = root1(a,b,c);
		
		System.out.println("The quadratic roots of the variables, "+a+","+b+","+c+" are:");
		
		System.out.println("Root 1: "+solution1);
		
		double solution2 = root2(a,b,c);
		
		System.out.println("Root 2: "+solution2);
		
		console.close();


	}
	private static double root1(double a, double b, double c) {
		double root1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
		
		return root1;
	}
	
	private static double root2(double a, double b, double c) {
		double root2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
		
		return root2;
	}

}
