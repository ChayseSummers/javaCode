import java.io.*;
import java.util.*; 

/*
 * /Users/jonathannguyen/Desktop/Assignment#3/dna.txt
 * 
 * 
 * Chayse Summers
 * CSC142 - Gandham
 * March 6th, 2015
 * 
 */

public class DNAFINAL {
	public static double minCodon = 5;
	public static double PercentMass = 30.0;  //Class constants, make for easy modification of the program.
	public static int UniNucleotides = 4;
	public static int NucPerCod = 3; 
	
	public static void main(String[] args) throws FileNotFoundException{
	Scanner console = new Scanner(System.in);
	File userFile = selectFile(console);
	PrintStream output = new PrintStream(outputFile(console));
	      
	Scanner lineScanner = new Scanner(userFile); 
	String line = lineScanner.nextLine();
	String nucleotideName = (" "); 
      
      while (lineScanner.hasNextLine()){ // Indefinite loop to read whole text file and use data to check for protiens.
         nucleotideName = line;
         String Nucleotides = lineScanner.nextLine().toUpperCase();
         int[] nucleotideCounts = Nucleotides(Nucleotides);
         int junk = calcjunk(Nucleotides.toLowerCase().toCharArray());
         double totalMass = Totalmass(nucleotideCounts, junk);
         double[] massPercentage = MassPercentage(totalMass,nucleotideCounts);
         String [] codons = Codons(Nucleotides.replace("-",""));
         boolean protein = Protein(codons, massPercentage);
         
         outputFile(nucleotideName, Nucleotides, nucleotideCounts, massPercentage, codons, 
            output, protein,totalMass);
         if (lineScanner.hasNextLine()){
            line = lineScanner.nextLine();
         }
      }  
   }
   
   

private static double Totalmass(int[] nucleotideCounts, int junk) { // Method to calculate the total mass of the nucleotides. Will be used to compute the masspercentage.
	   double[] baseMass = {135.128, 111.103, 151.128, 125.107};
	   double[] SingleMass = new double[UniNucleotides];
	   double massSum = 0;
	   double junktotal = junk*100.0;
	   for (int i = 0; i < UniNucleotides; i++){
	         SingleMass[i] = ((nucleotideCounts[i])*(baseMass[i]));
	         massSum = (SingleMass[i]+ massSum);
	         }
	   massSum = massSum+junktotal;
	   return massSum;
	}

public static File selectFile(Scanner console){
      System.out.print("Input file name: "); 
      File File = new File(console.nextLine());
      return  File;
   }
   // Collecting input and output file directory.
   public static File outputFile(Scanner console){
      System.out.print("Output file name: ");
      File outputFileName = new File (console.nextLine());
      return outputFileName;
   }
   
   public static int[] Nucleotides(String nucleotides){ // Adding up the number of each unique nucleotide.
      int[] nucleotideCounts = new int[UniNucleotides];
      for (int i = 0; i < nucleotides.length(); i++){
         int index = "ACGT".indexOf(nucleotides.charAt(i));
         if (index >= 0){
            nucleotideCounts[index]++;
         }
      }
      return nucleotideCounts;
   }

   public static double[] MassPercentage(double totalMass, int[] nucleotideCounts){//Calculates the Mass Percentage of each Nucleotide Returning an array
	double[] baseMass = {135.128, 111.103, 151.128, 125.107};
    double[] massPercentage = new double[UniNucleotides];
      for (int i = 0; i < UniNucleotides; i++){
         massPercentage[i] = Math.round(((nucleotideCounts[i]*baseMass[i])/totalMass)*1000.0)/10.0;
      } 
      return massPercentage;  
   }
   
   public static String[] Codons(String Nucleotides){//Creates an array of codons 
      String[] codons = new String [ (Nucleotides.length()/NucPerCod)];
      int indexStart = 0;
      for (int i = 0; i < codons.length; i++){
         codons[i] = Nucleotides.substring(indexStart,(indexStart + NucPerCod));
         indexStart = indexStart + NucPerCod;
      }
      return codons;
   }
   
   public static boolean Protein(String[] codons, double[] massPercentage){//If the DNA sequence is a protein
      if (!codons[0].equals("ATG")){
         return false;
      }
      if ((!codons[codons.length-1].equals("TAA")) && (!codons[codons.length-1].equals("TAG")) && 
            (!codons[codons.length-1].equals("TGA"))){
         return false;
      }  
      if (codons.length < minCodon){
         return false;
      }
      if ((massPercentage[1] + massPercentage[2]) < PercentMass){
         return false;
      }
      return true;
   }
   private static int calcjunk(char[] cs) {//Calculating the mass of the dashes
	   int junk=0;
		for(int i =0; i<cs.length; i++){
			if(cs[i]==('-')){
				junk=junk+1;
			}
		}
		return junk;
	}
     
   public static void outputFile (String nucleotideName, String Nucleotides, int[] nucleotideCounts, 
         double[] massPercentage,String[] codons, PrintStream output, boolean protein,double totalMass){//Prints the output to a specific file 
      output.println("Region Name: " + nucleotideName);
      output.println("Nucleotides: " + Nucleotides);
      output.println("Nuc. counts: " + Arrays.toString(nucleotideCounts));
      output.println("Total Mass %: " + Arrays.toString(massPercentage)+"of "+ Math.round(totalMass*10.0)/10.0);
      output.println("Codons List: " + Arrays.toString(codons));
      output.print("Is it a Protein: ");
      if (protein == true){
         output.println("YES");
      } 
      else{
         output.println("NO");
      }
      output.println("");
		   }
}


