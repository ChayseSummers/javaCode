
public class CaffeinatedDrinks extends Drinks {
private String name;
private double price_per_oz;


	public CaffeinatedDrinks(int size1, String name) {
		super(size1, name);
		this.price_per_oz = super.getPrice() * 3;
		this.name = name;
	}
	
	public CaffeinatedDrinks() {
		super();
		this.price_per_oz = super.getPrice() * 3;
		this.name = "Caffeinated Drink";
	}

	public double getPrice() {
		return price_per_oz;
	}

	@Override
	public String toString() {
		return "CaffeinatedDrinks [name=" + name + ", price_per_oz="
				+ price_per_oz + "]"+ super.toString();
	}
	public double getCost(){
		return super.getCost()*3;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice_per_oz() {
		return price_per_oz;
	}
	
	public void setPrice_per_oz(double price_per_oz) {
		this.price_per_oz = price_per_oz;
	}

}
