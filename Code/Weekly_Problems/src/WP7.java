import java.util.ArrayList;

/**
 * @author Chayse Summers
 * @CSC143 - Gandham
 * @date 4/28/15
 * @category Weekly Problems # 7
 * 
 * This class file executes a method for cleaning up an ArrayList in which it is considered "bad" data if
 * the first number in a pair is smaller than the other number in the pair.
 * 
 * This is a very useful tool, being able to shrink and organize lists like this will come in very handy I can
 * already tell! Took me around an hour to complete.
 */
public class WP7 {

	public static void main(String[] args) {
		
		ArrayList <Integer> list = new ArrayList<Integer>(); //Example integer array list.
		ArrayList <Integer> emptyList = new ArrayList<Integer>();// Empty integer array list.
		int[] c = {3, 7, 5, 5, 8, 5, 6, 3, 4, 7, 9};
		int[] d = {7, 4, 3, 6, 5, 8, 5, 5, 7, 3, 10};
		for(int number:c){
			list.add(number);
		}
		
		System.out.println(list);
		cleanCorruptData(list);
		System.out.println(list);
		
		System.out.println(emptyList);
		cleanCorruptData(emptyList);
		System.out.println(emptyList);
		
	}

	/**
	 * This method cleans up the array list, checking first to see if there is an odd number of values in the 
	 * array list. If there is, the last value is removed. Then checks list[0]<list[1], if true the values are
	 * removed, else it moves forward to the next two values i.e. list[2]<list[3].
	 * @param list
	 * @return cleaned up array list.
	 */
	private static ArrayList<Integer> cleanCorruptData(ArrayList<Integer> list) {
		int i = 0;
		if(list.size()%2!=0){
			list.remove(list.size()-1);
		}
		while(i<list.size()){
			if(list.get(i)<list.get(i+1)){
				list.remove(i);
				list.remove(i);
			}
			else{
				i=i+2;
			}
			
		}
		
		return(list);
		
	}

}
