import java.util.*;
import java.io.*;
public class ICE16 {

	//e:/csc142/datafiles/ice16.txt
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		File input = intro(console);
		int count = count(console, input);
		int[] list = reader(console, input, count);
		int sum = sums(list);
		int evenCount = evens(list);
		double evenPercentage = percent((double)count,(double)evenCount);
		output(count,sum,evenCount,evenPercentage);
		
		System.out.print("Please enter a phrase to count the vowels: ");
		String uInput = console.nextLine().toLowerCase();
		int[] vowels = vowelCounter(uInput);
		System.out.println("The number of vowels (a,e,i,o,u) are listed respectively: "+Arrays.toString(vowels));
		
		

	}


	private static int[] vowelCounter(String uInput) {
		int[] vowelCount = new int[5];
		for(int i=0;i<uInput.length();i++){
			if(uInput.charAt(i)=='a'){
				vowelCount[0]=vowelCount[0]+1;
			}
			else if(uInput.charAt(i)=='e'){
				vowelCount[1]=vowelCount[1]+1;
			}
			else if(uInput.charAt(i)=='i'){
				vowelCount[2]=vowelCount[2]+1;
			}
			else if(uInput.charAt(i)=='o'){
				vowelCount[3]=vowelCount[3]+1;
			}
			else if(uInput.charAt(i)=='u'){
				vowelCount[4]=vowelCount[4]+1;
			}
		}
		return vowelCount;
	}


	private static void output(int count, int sum, int evenCount,
			double evenPercentage){
		System.out.printf("%d numbers, sum = %d\n",count, sum);
		System.out.printf("%d evens (%.2f%s)\n",evenCount,evenPercentage,'%');
	}


	private static double percent(double count, double evenCount) {
		double percent = 0;
		percent = (((evenCount/count)*10.0)/10.0)*100;
		return percent;
	}


	private static int[] reader(Scanner console, File input, int count) throws FileNotFoundException {
		console = new Scanner(input);
		int[] list = new int[count];
		while(console.hasNextInt()){
			for(int i = 0; i<count;i++){
				list[i] = list[i]+console.nextInt();
			}
			
		}
		console.close();
		return list;
	}


	private static int evens(int[] list) {
		int evens = 0;
		for (int i = 0;i<list.length;i++){
			if(list[i]%2==0){
				evens = evens +1;
			}
		}
		return evens;
	}


	private static int sums(int[] list){
		int sum = 0;
		for (int i=0;i<list.length;i++)
			sum = sum + list[i];
		return sum;
	}

	private static int count(Scanner console, File input) throws FileNotFoundException {
		console = new Scanner(input);
		String[] list = console.nextLine().split(" ");
		int count=0;
		for(int i = 0; i<list.length;i++){
			count = count + 1;
		}
		console.close();
		return count;
	}

	private static File intro(Scanner console) {
		System.out.print("Please enter the filepathway: ");
		File fileObject = new File(console.nextLine());
		return fileObject;
	}

}
