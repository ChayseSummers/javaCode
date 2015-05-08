//This is a single line comment. Used for specific lines of code.

/*
 * This is a multiple line comment.
 * Can have as many lines as you want.
 */

/**
 * Java.comment Allows for the comments to be produced as 
 * documentation for your methods and programs.
 * More on this in back of text book (appendix b, pg. 110, Javadoc).
 * Used for class and method documentation.
 * @author csummers233
 * @version 1.23.4.434.0
 * @since 4/6/2015
 *
 * This comment would be for entire class.
 */


public class Test {
	int x = 4;
	byte x1 = -128;// 2^7 (byte is 8 bits and +/- symbol will take up a bit) can store between -128 and 127.
	//Using a byte is useful if the variable will be between -128 and 127, this will save memory making
	//the processing faster.
	short x2 = 12369;// 2^15 (short is 16 bits and +/- symbol will take up a bit) can store between 
	
	long x3 = 256;// 2^63 (long is 64 bits and +/- symbol will take up a bit) can store between
	
	/**
	 * This is the main method and
	 * this is where the execution begins.
	 * This method solves poverty in this world (we wish).
	 * @exception IllegalArgumentException
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Some String";//here 
	}
	
	/**
	 * Automatically generates the parameter and return documentation.
	 * @author csummers233
	 * @param val -- Insert description for parameter.
	 * @param str -- Insert description for parameter.
	 * @return -- Insert description of return value.
	 */
	public static double example(int val, String str){
		return 2.3;
	}

}
