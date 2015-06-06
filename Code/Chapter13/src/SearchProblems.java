import java.util.Arrays;


public class SearchProblems {

	public static void main(String[] args) {
		int[] data = {0,1,2,3,4,5,6,7,8,9,10};
		int[] Test = new int[10];
		for(int i = 0;i<Test.length;i++){
			Test[i] = (int)(Math.random()*Test.length);
		}
		System.out.println(Arrays.toString(Test));
		selectionSort(Test);
		System.out.println(Arrays.toString(Test));
//		int[] bianaryTest = new int[1000000];
//		for(int i = 0;i<bianaryTest.length;i++){
//			bianaryTest[i] = i;
//		}
		
//		for(int i = 1;i<=10;i++){
//			System.out.println(bianarySearch(bianaryTest, (int)(Math.random()*bianaryTest.length)));
//		}
		//System.out.println(linearSearch(data,10));
		//System.out.println("Search value is located at index of: "+bianarySearch(data,1)); //data must be sorted.
		

	}

	private static void selectionSort(int[] test) {
		for(int i=0; i<test.length; i++){
			int minElemLoc = minElement(test,i);
			swap(test,i,minElemLoc);
		}
		
	}

	private static void swap(int[] test, int i, int minElemLoc) {
		int temp = test[i];
		test[i] = test[minElemLoc];
		test[minElemLoc]= temp;
		
	}

	private static int minElement(int[] test, int start) {
		int minLoc = start;
		int min = test[minLoc];
		for(int i = start+1;i<test.length;i++){
			if(test[i]<min){
				min = test[i];
				minLoc = i;
			}
		}
		return minLoc;
	}

	//Precondition - data must be sorted.
	private static int bianarySearch(int[] data, int searchVal) {
			return(bianarySearch(data, searchVal, 0, data.length-1));
	}

	private static int bianarySearch(int[] data, int searchVal, int startIndex, int endIndex) {
		if(startIndex<=endIndex){ //Normal recursive condition, working on logbase2. Much more efficient than linear search.
			int mid = (startIndex + endIndex)/2; //could also do startIndex + (endIndex-startIndex)/2;
			System.out.println("Now looking at index: "+mid);
			if(data[mid]==searchVal){
				return mid;
			}
			else if(data[mid]>searchVal){//Search again through first half.
				return bianarySearch(data,searchVal,startIndex,mid-1);
			}
			else{// Search again through second half.
				return bianarySearch(data,searchVal,mid+1,endIndex);
			}
		}
		return -1;
	}

	private static int linearSearch(int[] data, int searchVal) {
		for(int i = 0; i<data.length;i++){
			if(data[i]==searchVal){
				return(i);
			}	
		}
		return -1;
	}

}
