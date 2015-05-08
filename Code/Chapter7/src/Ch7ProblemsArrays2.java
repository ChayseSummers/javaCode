import java.util.*;
public class Ch7ProblemsArrays2 {
	
	public static final int CAP = 10;
	public static void main(String[] args) {
		int[] array = new int[CAP];
		for(int i = 0;i<CAP;i++){
			array[i]=i;
		}
		System.out.println("Before process: "+Arrays.toString(array));
		array_Method(array);
		System.out.println("After process: "+Arrays.toString(array));// Showing that an array is changed
		//in the main method even if it was modified in a separate method.
		
		int[] array2 = array_Doubler(array);
		System.out.println(Arrays.toString(array2));

	}

	private static int[] array_Doubler(int[] array) {
		int j= 0;
		int[] doubler = new int[array.length*2];
		for(int i = 0;i<array.length;i++){
			doubler[i]=array[i];
		}
		int k = array.length;
		while(j<k){
			swapDoubler(doubler,j++);
		}
		
		return doubler;
	}

	private static int[] swapDoubler(int[] doubler, int j) {
		int temp = doubler[j+1];
		int temp2 = doubler[j+2];
		doubler[j+1]=doubler[j];
		doubler[j+3]=temp;
		doubler[j+4]=temp2;
		return null;
	}

	private static void array_Method(int[] array) {
		int i = 0;
		int j = array.length-1; 
		while(i< j){
			swap(array,i++,j--);
		}
		
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
