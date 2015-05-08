import java.util.Arrays;


public class Ch7ProblemsArrays {
	
	/* Arrays are reference types, their range starts with 0, you can use length to find the 
	amount of items in the array list. 
	
	 To create an array use...
	 type[] name = new type[number of items];
	 
	 For example...
	 int[] data = new int[10]; This is an integer array (list) with 10 spots for data.
	 
	Until something is assigned to these locations, if it's a numerical array, the locations
	are filled with 0's.
	 */
	public static final int CAP = 100;
	public static void main(String[] args) {
		
		int [] data = new int[CAP];
		int [] count = new int[6];
		
		//System.out.println(data); // Won't print array this way.**
		
		System.out.println(Arrays.toString(data)); // This will print the whole list.
		
		//System.out.println(data[99]); // This will print specific location in array.
		
		for(int i=0;i<CAP;i++){
			data[i] = (int)(Math.random()*6+1);
		}
		System.out.println(Arrays.toString(data));
		
		for(int j = 0; j<CAP;j++){
			for(int k = 0; k <=6;k++){
				if(data[j]==k){
					count[k-1]=count[k-1]+1;
				}
				else{
					
				}
			}
		}
		System.out.println("The amount of each number rolled is: "+Arrays.toString(count));
		
//		System.out.println(data[99]);
//		System.out.println(Arrays.toString(data));

	}

}
