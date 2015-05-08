
public class Chap2Problems {
	
	public static final int WIDTH = 21;// Called a class constant. For this program
	//will only print odd numbered lines. Create this outside of all methods, so all methods
	//can have access to them.

	public static void main(String[] args) {
		
		for (int i = 1; i<=WIDTH; i = i + 2){
			
			for (int n = 1; n<=(WIDTH-i)/2; n = n + 1){
				System.out.print(" ");
				//System.out.print("*");
			}

			for (int n = 1; n<=i; n = n +1){
				//System.out.print();
				System.out.print("*");
			}
			
			for (int n = 1; n<=(WIDTH-i)/2; n = n + 1){
				System.out.print(" ");
				//System.out.print("*");
			}
			
			System.out.println();
		}

	}

}
