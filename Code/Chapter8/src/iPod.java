import java.util.Arrays;

// Order in class has no meaning. Data usually goes first however.

public class iPod {
	//data
	private double battery; //1.0 is fully charged
	private int space;
	private String color;
	private String songs;
	private static String[] colors = {"White", "Red", "Black", "Yellow"};
	
	//default constructor (no arguments)
	public iPod(){
		color = "white";
		space = 100;
		battery = 0.5;
		songs = "Celebrate";
	}
	
	//non-default constructor
	public iPod(String c, int sp){
		for(String cc:colors){
			if(cc.equalsIgnoreCase(c)){
				color = c;
			}
		}
		if(color==null){
			color = "White";
		}
		if(sp>=100 && sp<=1000){
			space = sp;
		}
		else{
			space = 100;
		}
	}
	
	//actions
	
	public boolean equals(iPod otherIpod){
		return(this.color.equals(otherIpod.color) && this.space==otherIpod.space);
	}
	
	public String toString(){ //showDetails(){ by changing this from showDetails to toString()
		//it allows you to call this method without putting the .toString on the end.
		return("This "+color+" iPod has these song(s): "+songs+", battery: "+battery+" and space: "+space);
	}
	
	public void loadSongs(String[] s){
		if(s.length<=space){
			songs += Arrays.toString(s);
			System.out.print("Loading songs.");
			for(int i=0;i<s.length;i++){
				System.out.print(".");
			}
			space = space - s.length;
		}
		else{
			System.out.println("Sorry... not enough space.");
		}
	}
	
	public void charge(){
		System.out.println("Charging");
		for(int i=1;i<=100;i++){
			System.out.print("-");
		}
		battery = 1.0;
		System.out.println("Charge Complete");
	}
	
	public void playSongs(){
		if(battery>0 && songs!=null){
			System.out.println("Now Playing..."+songs);
			battery -= .1;
		}
		else{
			System.out.println("Sorry... battery is out or no songs.");
		}
	}
}
