
public class RecursionProblems {

	public static void main(String[] args) {
		//testingRecursion(10);
		//System.out.println(power(5, 4));
		//Factorials n! = n*(n-1)! ex.) 5! = 5*4! = 5*4*3! = 5*4*3*2! = 5*4*3*2*1! = 5*4*3*2*1.
		System.out.println(fib(11));
	}

	/**
	 * Lousy recursive example. Not very efficient.
	 * @param n
	 * @return Fibionacci sequence of a number n.
	 */
	private static int fib(int n) {
		System.out.println("in fibonacci method: "+n);
		if(n==0){//Stopping condition.
			return 0;
		}
		else if (n==1){//Stoping condition.
			return 1;
		}
		else{//Recursive call.
			return fib(n-1)+fib(n-2);
		}
	
	}

	/**
	 * Recursive method example that raises one number to the power of the other, i.e. x to the power of y. x**y;
	 * @param x
	 * @param y
	 * @return x raised to the power of y.
	 */
	private static int power(int x, int y) {
		if(y==0){
			return 1;
		}
		else{
			return x*power(x,y-1);
		}
		
	}

	private static void testingRecursion(int num) {
		try{
			if(num>0){
				testingRecursion(num-1); //recursive call
				System.out.println(num+": Hello!");
				
			}
			else{
				System.out.println("Finished.");
			}
		
		}catch(StackOverflowError e){
			System.out.println("Error! Recursion never stops! "+e);
		}
	}

}
