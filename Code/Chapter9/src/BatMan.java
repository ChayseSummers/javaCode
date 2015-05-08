
public class BatMan extends Hero implements InvisibleCloak, UtilityBelt, Comparable<BatMan> {
	private int wealth;

	public BatMan(int respect, String name, int strength, int wealth) {
		super(respect, name, strength);
		this.wealth = wealth;
	}
	public void loseRespect(){
		System.out.println("Batman just lost some respect..oops!");
	}
	public String toString() {
		return "BatMan [wealth=" + wealth + ", toString()=" + super.toString()
				+ ", getRespect()=" + getRespect() + ", getStrength()="
				+ getStrength() + ", getName()=" + getName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	public void vanish() {
		System.out.println("Batman just vanished!");
	}
	public void shootStapleGun() {
		System.out.println("Batman just decimated with shooting staples!");
	}
	@Override
	public int compareTo(BatMan o) {
		int wealthDiff = this.wealth - o.wealth;
		return (wealthDiff);
	}
}
