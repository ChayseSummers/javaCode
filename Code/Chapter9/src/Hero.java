public class Hero extends FictionalCharacter {
	private int respect;
	public Hero(int respect, String name, int strength) {
		super(name, strength);
		this.respect = respect;
	}
	public String toString() {
		return "Hero [respect=" + respect + "]" + super.toString();
	}
	public void spendStrength(int spent){
		super.spendStrength(spent);
		loseRespect();
	}
	public void loseRespect() {
		respect -= 1/2;
	}
	public int getRespect() {
		return respect;
	}
	public void setRespect(int respect) {
		this.respect = respect;
	}
	public int getStrength (){
		return super.getStrength()+2*this.respect;
	}
	
	
}
