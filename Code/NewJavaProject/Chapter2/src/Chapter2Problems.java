/*Chayse Summers
 * Ch2 notes, identities of data types.
 * Jan 13, 2015
 * CSC 142 - Gandham
 */

public class Chapter2Problems {
	
	public static void main(String[] args) {
		int age = 5*2+16;
		System.out.println("Age is: "+age);
		
		double gpa = 3.7;
		
		char ch = 'Q';
		
		boolean b = 100 > 00;
		
		// Also byte, short, long and float.
		
		System.out.println(gpa);
		System.out.println(ch);
		System.out.println(b);
		
		int x = 17;
		int y = 3;
		System.out.println("Integer result of 17 divided by 3: "+ x/y);

		double xx = 17;
		double yy = 3;
		System.out.println("Double result of 17/3 is: "+ xx/yy);
	
		System.out.println("Int/double is: "+ x/yy);
		System.out.println("Double/int is: "+ xx/y);
		
		System.out.println("Modulous result is: "+x%y);
		//The modulous shows what remainder is left.
		
		System.out.println("The remainder of 3/17 is: "+y%x);
		//Because 3 can be divided by 17 zero times, 3 is left alone.
	}

}
