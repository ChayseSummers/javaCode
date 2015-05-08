import java.util.*;


public class ICE18 {
public static int[] collapsed;
public static int a = 0;
public static int b = 1;
	public static void main(String[] args) {
		int[] arrayTest = {1,2,3,4,5,6,7};
		int[] newArray = collapsed(arrayTest);
		System.out.println(Arrays.toString(newArray));// Prints [3, 7, 11, 7]

	}

	private static int[] collapsed(int[] array) {
		if(array.length%2==0){
			int[] collapsed = new int[array.length/2];
			for(int i=0;i<collapsed.length;i++){
				collapsed [i] = array[a] + array[b];
				a=a+2;
				b=b+2;
			}
			return collapsed;
			
		}
		else{
			int[] collapsed = new int[(array.length/2)+1];
			for(int i =0;i<collapsed.length-1;i++){
				collapsed[i] = array[a]+array[b];
				a=a+2;
				b=b+2;
			}
			collapsed[collapsed.length-1]=array[array.length-1];
			return collapsed;
		}
		
	}

}
