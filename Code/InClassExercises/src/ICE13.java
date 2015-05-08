
public class ICE13 {

	public static void main(String[] args) {
		System.out.println("The number of unique integers is: "+uniqueNums(18, 3, 4));
		System.out.println("The number of unique integers is: "+uniqueNums(6, 7, 6));
		System.out.println("The number of unique integers is: "+uniqueNums(1, 1, 1));

	}

	private static int uniqueNums(int i, int j, int k) {
		int counter;
		if(i==j&&j==k){
			counter = 1;
		}
		else if(i==j&&j!=k||i!=j&&j==k||i==k&&k!=j){
			counter = 2;
		}
		else {
			counter = 3;
		}
		return counter;
		
	}

}
