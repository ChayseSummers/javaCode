import java.io.*;
import java.util.*;

public class Chapter6Problems {

	public static void main(String[] args) throws FileNotFoundException {
		File fileObject = new File ("e:/csc142/datafiles/data.txt");
		Scanner fileScanner = new Scanner (fileObject);
		// or
		// Scanner fileScanner = new Scanner(new File("e:/csc142/datafiles/data.txt"));
		double val = 0;
		String name;
		double gpa = 0;
		double current;
		double max;
		double min;
		
//		for (int i = 1; i<=6;i++){
//			val = fileScanner.nextInt();// Reads first value.
//			System.out.println(val);	
//		}
		//There is a virtual marker keeping 
		//track of where it's at in the file.
		
		double counter = 0;
		
		while(fileScanner.hasNextLine()){// Runs as long as there is another value in file.
			name = fileScanner.next();
			val = fileScanner.nextDouble();
			current = val;
			gpa = gpa + val;
			System.out.println(name+"\t"+val);
			counter = counter + 1;
			if (val < current){
				min = val;
			}
			else if(val > current){
				max = val;
			}
			else if(val == current){
				min = current;
			}
		}
		double avg = gpa/counter;
		System.out.printf("The average gpa is: %.2f",avg);
		
		fileScanner.close();
	}

}
