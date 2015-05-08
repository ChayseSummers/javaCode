
public class NonCaffeinatedDrinks extends Drinks {
private String name;
private double price_per_oz;


	public NonCaffeinatedDrinks(int size, String name) {
		super(size, name);
		this.price_per_oz = super.getPrice() * 2;
		this.name = name;
	}
	
	public NonCaffeinatedDrinks(){
		super();
		this.price_per_oz = super.getPrice() * 2;
		System.out.println(price_per_oz);
		this.name = "Non-caffeinated Drink";
	}
	
	public double getPrice() {
		return price_per_oz;
	}
	@Override
	public String toString() {
		return "NonCaffeinatedDrinks [name=" + name + ", price_per_oz="
				+ price_per_oz + "]"+super.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice_per_oz(double price_per_oz) {
		this.price_per_oz = price_per_oz;
	}
	
	public double getCost(){
		return super.getCost()*2;
	}
}
