public class FictionalCharacter {
	private String name;
	private int strength; //0:dead - 99:full
	public FictionalCharacter(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	public void spendStrength(int spent){
		this.strength -= spent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public String toString() {
		return "FictionalCharacter [name=" + name + ", strength=" + strength
				+ "]";
	}
}
