
public class Chapter5Problems {

	public static void main(String[] args) {
		//printNumbers(5);
		//fenceBuilding(8);
		printPrimes(50);
		System.out.println();
		System.out.printf("The number of factors is %d\n",countFactors(33331));
		perfectNumbers(100000);

	}

	private static void perfectNumbers(int max) {
		for(int i = 1; i<=max;i++){
			if (isPerfect(i) == true){
				System.out.println(i+" is a perfect number!");
			}
		}
	}

	private static boolean isPerfect(int num) {
		int sumOfFactors = 0;
		for(int i = 1; i<=num-1;i++){
			if (num%i == 0){
				sumOfFactors = sumOfFactors + i;
			}
		}
		return (num == sumOfFactors);
	}

	private static void printPrimes(int max) {
		System.out.printf("The prime numbers between 1 and %d are: 2", max);
		for(int i = 3; i<=max; i++){
			if(countFactors(i)==2){
				System.out.print(", "+i);
			}
		}
		
	}

	public static int countFactors(int factor) {
		int count = 0;
		for(int i = 1; i<=factor;i++){
			if (factor%i == 0){
				count = count + 1;
			}
		}
		return count;
		
	}

	public static void fenceBuilding(int posts) {
		System.out.print("||");//1*
		for(int i = 1; i<=posts; i ++){
			System.out.print("###"+"||");//1*
			//System.out.print("||"+"###");//2*
		}
		//System.out.print("||");//2*
		
		//Method 1 marked with 1*, method 2 marked with 2*.
		
	}

	public static void printNumbers(int number) {
		for (int i=1; i<number;i++){
			System.out.print(i+", ");
			
		}
		System.out.print(number);
		
		// Post-wire problem. Will come in handy
		//when doing processing of things. Needs to stop one before in order to not print
		//the comma at the end.
		
	}

}
