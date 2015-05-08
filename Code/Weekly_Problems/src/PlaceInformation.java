/**
 * 
 * @author Chayse Summers
 * @class CSC143
 * @date 4/17/15
 * 
 * PlaceInformation class used to construct PlaceInformation objects.
 *
 * I thought this was an interesting assignment, very cool to see how these classes can work together to
 * achieve the desired results. Object oreiented programing rocks!
 * 
 * This assignment took me an hour or so to complete all together over a couple of coding sessions.
 */
public class PlaceInformation {
	/**
	 * Class variables
	 */
	private String n; //name
	private String a; //address
	private String t; //tags
	private GeoLocation p; //longitude and latitude
	
	/**
	 * Method to construct PlaceInformation objects.
	 * 
	 * @param name
	 * @param address
	 * @param tag
	 * @param latitude
	 * @param longitude
	 */
	public PlaceInformation(String name, String address, String tag, double latitude, double longitude){
		n = name; a = address; t = tag; p = new GeoLocation(latitude,longitude);
	}
	
	/**
	 * get methods return various articles of information about the object, i.e. objects name, address, tags or 
	 * location.
	 * @return
	 */
	public String getName(){
		return(n);
	}
	public String getAddress(){
		return(a);
	}
	public String getTag(){
		return(t);
	}
	
	/**
	 * toString method allows for the objects info to be output to the console.
	 */
	public String toString(){
		return(n+" ("+p.getLatitude()+","+p.getLongitude()+")");
	}
	public GeoLocation getLocation(){
		return(p);
	}
	
	/**
	 * distanceFrom method uses the GeoLocation class to compute the distance from current PlaceInformation object
	 *to a specified GeoLocation or "spot". 
	 * @param spot meaning the target GeoLocation object to compare with current PlaceInformation object.
	 * @return
	 */
	public double distanceFrom(GeoLocation spot){
		return (this.getLocation().distanceFrom(spot));
	}
}
