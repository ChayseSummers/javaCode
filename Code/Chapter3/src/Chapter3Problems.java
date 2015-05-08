
public class Chapter3Problems {

	public static void main(String[] args) {
		
		double val = 4783.434;
		
		System.out.println(Math.sqrt(val));// This is how you square root.
		
		int x = 10;
		
		System.out.println("In main, before calling void method, x = "+x);
		
		testMethod(x);
		
		System.out.println("In main, after calling void method, x = "+x);
		
		System.out.println("In main, after calling type method, x = "+x);
		
		int type = typeMethod(x);
		
		System.out.println("In main, after calling type method, x = "+type);
		
		printXStars(10);
		
		printXStars(7);
		
		printXStars(6);
		
		printXStars(16);
		
		happyBirthday("Ravi");
		
		box(4,3);
		
		double paycheck = computePay(40,15.0);// In order to return the correct value,
		//when the function is called it must also be assigned to a variable. In this case
		//the variable paycheck.
		System.out.println("You made $"+paycheck);
	}
	


	private static double computePay(int hours, double rate) {
		double pay = hours * rate;
		
		return pay;// Return can only send back one value, because it will be assigned to one
		//variable. If method has more than one value to return, it may need to be split into
		//multiple methods.
	}

	public static void testMethod(int x){
		System.out.println("In void method, before change, x = "+x);
		
		x = 10000;
		
		System.out.println("In void method, after change, x = "+x);
		// Even though x is changed to 10000 here, it won't change x in the main method.
		//They are stored in different spaces in the memory. If we put a return x in the testMethod
		//method, would that change x in the main method? Looks like void methods cannot return
		//a value. Instead, use public static type name (parameters)
	}
	
	public static int typeMethod(int x){
		System.out.println("In type method, before change, x = "+x);
		
		x = 10000;
		
		System.out.println("In type method, after change, x = "+x);
		
		return x;
	}
	
	private static void printXStars(int numOfStars) {
		for (int i =1; i <= numOfStars; i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
	private static void happyBirthday(String name){
		System.out.println("Happy Birthday "+name+"!");
	}
	private static void box(int width, int height) {
		for (int i =1; i <=height; i++){
			for (int n =1; n <=width; n++){
			System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

}
