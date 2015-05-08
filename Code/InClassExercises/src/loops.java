/*Chayse Summers
 * CSC142 - Gandham
 * January 15th, 2015
 * ICE4
 */
public class loops {
	// Here we use a loop to create a patern using star symbols.
	
	public static void main(String[] args) {
		String x = "**";
		
		for (int i = 1 ; i <= 6; i += 1){
			System.out.println(x);
			
			x = x + "***";
		}

	}

}
