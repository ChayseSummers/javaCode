/**
 * 
 * @author Chayse Summers
 * @class CSC143 - Gandham
 * @date 4/17/15
 *
 * GeoLocationClient used to create and then compare different locations. 
 */
public class GeoLocationClient {

	/**
	 * Main method where new GeoLocation objects are created and output is presented.
	 * @param args
	 */
	public static void main(String[] args) {
		GeoLocation stash = new GeoLocation(34.988889,-106.614444);
		
		GeoLocation ABQ = new GeoLocation(34.989978,-106.614357);
		
		GeoLocation FBI = new GeoLocation(35.131281,-106.61263);
		
		System.out.println("The stash is at "+printInfo(stash));
		System.out.println("ABQ studio is at "+printInfo(ABQ));
		System.out.println("FBI Building is at "+printInfo(FBI));
		System.out.println("Distance in miles between:");
		System.out.println("\tstash/ABQ = "+stash.distanceFrom(ABQ));
		System.out.println("\tstash/FBI = "+stash.distanceFrom(FBI));
		
	}

	/**
	 * printInfo method to allow for faster coding of output.
	 * 
	 * @param object meaning the GeoLocation object being looked at.
	 * @return objects info.
	 */
	private static String printInfo(GeoLocation object) {
		return(object.toString());
	}

}
