
public class WP12 {

	/**
	 * Recursive exercises, rather confusing but somehow I got them to work.
	 * @author Chayse Summers
	 * @date 5/15/15
	 */
	public static void main(String[] args) {
		System.out.println("The sum of the numbers is: "+recSum(5));
		int[] test = {3,1,3,4,5,4,2};
		System.out.println("The smallest number is: "+recMin(test, test.length));
		System.out.println("The sum of numbers in this list is: "+recASum(test, test.length));

	}

	

	//1. Write a recursive function that computes the sum of all numbers from 1 to n, where n is given as parameter.
	private static int recSum(int n) {
		int total = 0;
		if(n==0){
			return total;
		}
		return total= total + n+  recSum(n-1);
	}
	
	//2. Write a recursive function that finds and returns the minimum element in an array, where the array and its 
	//size are given as parameters.
	private static int recMin(int[] test, int length) {
		int i = test[length-1];
		for(int element:test){
			if(i>element){
				return recMin(test,length-1);
			}
		}
		return i;
	}
	
//	3. Write a recursive function that computes and returns the sum of all elements in an array, where the array and its
//	size are given as parameters.
	private static int recASum(int[] test, int length){
		int total = 0;
		if(length==0){
			return total;
		}
		return total= total +test[length-1]+ recASum(test,length-1);
	}
}
