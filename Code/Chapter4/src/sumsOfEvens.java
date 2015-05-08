import java.util.*;


public class sumsOfEvens {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the number of terms: ");
		int n = console.nextInt();
		//computeEvenSum(n,console);
		smallestValue(n,console);

	}

	private static void smallestValue(int n, Scanner console) {
		System.out.print("Please enter number 1 value: ");
		int valInital = console.nextInt();
		for (int i=2; i<=n; i++){
			System.out.printf("Please enter number %d value: %n",i);
			int val = console.nextInt();
			if (val<=valInital){
				valInital = val;
			}

		}
		System.out.printf("The smallest number given is: %d",valInital);
	}

	private static void computeEvenSum(int n,Scanner console) {
		int sum = 0;
		for (int i=1; i<=n; i++){
			System.out.printf("Please enter number %d value: %n",i);
			int val = console.nextInt();
			if (val%2 == 0){
				sum = sum + val;
			}
		}
		System.out.printf("Sum of even values: %d",sum);
	}

}
