
public class printF {

	public static void main(String[] args) {
		double x = 12.21235468;
		String a = "Twelve point two";
		int y = 8;
		System.out.printf("%d%n%.8f\n%100s%n",y,x,a);
		//%n works better across most platforms, although here \n works the same way.
		//By putting a number after the % you can align left or right (-) with the number == the amount of spacing.
		//making the s in %s capitalized will capitalize the string.
		String s = "Chayse";
		int l = 2*s.length();
		String formattedStr = "%-"+l+"s%-"+l+"s%n";
		for(int i = 0; i<10;i++){
			//System.out.printf(".  %-8s..  %-8s.%n",s,s);
			System.out.printf(formattedStr,s,s);
		}
		
	}

}
