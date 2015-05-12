import java.io.*;
import java.util.*;
public class dna {
	public static int minCodon = 5;
	public static double minC_G_Mass = 30.0;
	public static int uniNuc = 4;
	public static int nucPerCod = 3;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		String inFile = introduction(console,1);
		PrintStream outFile = new introduction(console,2);
		int[] nucCount = nucCounter(console, inFile);
		double total = totalFinder(nucCount);
		double[] nucPerCodon = massPercent(total, nucCount);
		String[] codons = codonFinder(console, inFile);
		
		console.close();
	}

	private static String[] codonFinder(Scanner console, String inFile) throws FileNotFoundException {
		String[] nameAndCodons = new String[5];
		File fileObject = new File(inFile);
		console = new Scanner(fileObject);
		String name = console.nextLine();
		String protien = console.nextLine();
		protien.replace
		for(int i=0;i<(protien.length()/3);i++){
			nameAndCodons[i] = protien.substring(i, i+3);
			System.out.println(nameAndCodons[i]);
		}
		System.out.println(Arrays.toString(nameAndCodons));
		console.close();
		return nameAndCodons;
	}

	private static double totalFinder(int[] nucCount) {
		double total = 0;
		double[] massPercent = new double[4];
		massPercent[0] = nucCount[0]*135.128;
		massPercent[1] = nucCount[1]*111.103;
		massPercent[2] = nucCount[2]*151.128 ;
		massPercent[3] = nucCount[3]*125.107;
		for(int i = 0; i<massPercent.length;i++){
			total = total + massPercent[i];
		}
		return total;
	}

	public static double[] massPercent(double total, int[] nucCount) {
		// Method to calculate the mass percentage of dna according to the count of 
		//the nucleotides.
		
		double[] massPercent = new double[4];
		
		massPercent[0] = nucCount[0]*135.128;
		massPercent[1] = nucCount[1]*111.103;
		massPercent[2] = nucCount[2]*151.128 ;
		massPercent[3] = nucCount[3]*125.107;
		
		
		for(int k = 0; k<massPercent.length;k++){
			massPercent[k]=((massPercent[k]/total)*100);
			massPercent[k] = Math.round(massPercent[k]*10.0)/10.0;
		}
		
//		//* This code is for the output method
//		String total1 = Arrays.toString(massPercent);
//		System.out.println("my data is "+ Arrays.toString(massPercent)+" of "+total);
//		//*
		
		return massPercent;
	}

	public static int[] nucCounter(Scanner lineReader, String file) throws FileNotFoundException{
		// Method to count the number of As, Cs, Gs and Ts. Returning an array containing the counts.
		
		File fileObject = new File(file);
		lineReader = new Scanner(fileObject);
		String name;
		String protien;
		int[] count = new int[4];
		
			name = lineReader.nextLine();
			protien = lineReader.nextLine();
			protien = protien.toLowerCase();
			// e:/csc142/datafiles/dna.txt
			
			for(int i=0;i<protien.length();i++){
				
				if(protien.charAt(i) == 'a'){
					count[0] = count[0] + 1;
				}
				else if(protien.charAt(i) == 'c'){
					count[1] = count[1] + 1;
				}
				else if(protien.charAt(i) == 'g'){
					count[2] = count[2] + 1;
				}
				else if(protien.charAt(i) == 't'){
					count[3] = count[3] + 1;
				}
				else{
				}
			}
			
		lineReader.close();
		return count;
	}

	public static String introduction(Scanner prompt,int num) {
		//Introduction to gather user input, i.e. dna files to process.
		if(num == 1){
			System.out.println("This program reports information about DNA nucleotide sequences that may encode proteins");
			System.out.print("Input file: ");
			String inPathway = prompt.nextLine();
			//System.out.println();
			return inPathway;
			
		}
		else{
			System.out.print("Output file: ");
			String outPathway = prompt.nextLine();
			return outPathway;
		}
		
	}
	//File fileObject = new File ("e:/csc142/datafiles/");
}
