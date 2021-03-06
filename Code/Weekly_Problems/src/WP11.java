import java.util.*;
import java.io.*;
/**
 * This program allows the user to input files containing an RNA Table and RNA strand which will use the table to process the strand
 * outputting the protein strand that the RNA is encoded with. I chose to use filepathway's as the output from decoding the RNA was too
 * big for the console to output. This also allows for the user to input a different RNA Table as I noticed that the one for this problem
 * has no start codons, only stop codons are listed. This works fine for our example, but if we wanted to use this program in the future 
 * we now have the option to set the RNA Table. This problem took me around two hours to complete. It was good to refresh on how to 
 * output to a file as well as how HashMap key/value pairs work.
 * 
 * @author Chayse Summers
 * @class CSC143 - Gandham
 * @date May 12th, 2015
 */
public class WP11 {
	private static Map<String, String> RNATable = new HashMap<String, String>();
	private static String RNATablePathway; //E:/CSC142_143/DataFiles/RNATable.txt
	private static String RNAStrandPathway; //E:/CSC142_143/DataFiles/RNAString.txt
	private static String RNAOutPathway; //E:/CSC142_143/DataFiles/RNAOut.txt
	private static String strand = "";
	private static String result = "";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(System.in);
		System.out.println("This program will use a table of RNA codons to search through an RNA strand and decode the Protien within.");
		inputs(fileScanner);
		process(fileScanner);
		System.out.println("There should now be a file with the protien encoded within the RNA strand at: "+getRNAOutPathway());
	}

	// This method processes the files first creating a HashMap of the RNA table so as to have key/value pairs. Next it collects the
	//RNA strand from the file before pulling the first three characters from the strand and searching for them in our Hash Map RNA
	//table and then adding the value to our result. Result is then written to the new file at RNAOutPathway.
	private static void process(Scanner fileScanner) {
		PrintStream outFile;
		try {
			fileScanner = new Scanner(new File (RNATablePathway));
			outFile = new PrintStream(new File (RNAOutPathway));
			while(fileScanner.hasNext()){
				RNATable.put(fileScanner.next(),fileScanner.next()); //Loading table.
			}
			fileScanner = new Scanner(new File(RNAStrandPathway));
			strand = fileScanner.next(); //Loading RNA strand.
			fileScanner.close();
			System.out.print("Loading");
			for(int i = 0; i<strand.length(); i+=3){ //Searching table for RNA strand substrings.
				System.out.print(".");
				String section = strand.substring(i, i+3);
				if(section.equals("UGA")||section.equals("UAA")||section.equals("UAG")){ //Catching the stop marker so it doesn't end up as part of the output.
					System.out.println();
					System.out.println("complete.");
				}
				else{
					result = result + RNATable.get(section); //Adding the decrypted characters together to form output.
				}
			}
			outFile.println(result);//Writing to output file.

		} catch (FileNotFoundException e) {
			System.out.println("File not found! Please check pathway and try again.");
		}
		
	}

	//Method to gather in filepathway's.
	private static void inputs(Scanner fileScanner) {
		System.out.printf("You will now need to enter in the correct pathway to the files containing: \n\t1.) RNA table\n\t2.) RNA strand\n\t3.) Output Protien strand (this will create a new file)\n");
		System.out.println("Example pathway: C:/CSC142_143/DataFiles/RNATable.txt");
		System.out.print("Please enter file pathway for the RNA Table: ");
		setRNATablePathway(fileScanner.next());
		System.out.print("Please enter file pathway for the RNA Strand: ");
		setRNAStrandPathway(fileScanner.next());
		System.out.print("Please enter file pathway for the decoded protien: ");
		setRNAOutPathway(fileScanner.next());
		fileScanner.close();
		
	}

	public static String getRNAOutPathway() {
		return RNAOutPathway;
	}

	public static void setRNAOutPathway(String rNAOutPathway) {
		RNAOutPathway = rNAOutPathway;
	}

	public static String getRNATablePathway() {
		return RNATablePathway;
	}

	public static void setRNATablePathway(String rNATablePathway) {
		RNATablePathway = rNATablePathway;
	}

	public static String getRNAStrandPathway() {
		return RNAStrandPathway;
	}

	public static void setRNAStrandPathway(String rNAStrandPathway) {
		RNAStrandPathway = rNAStrandPathway;
	}
}
