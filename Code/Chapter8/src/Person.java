
public class Person {
	//data members (typical classes will contain many data members)
	private String name;
	private int id;
	private double wealth;
	private int health = 10;
	
	public Person (String name, int id, double wealth){
		this.name = name;
		this.id = id;
		this.wealth = wealth;
	}
	
	public void doubleWealth(){
		this.wealth *= 2;
	}
	
	public String toString (){
		return (this.name+" with id: "+this.id+" has $"+this.wealth);
	}
	
	public void commonCold(){
		this.health = 8;
	}

}
