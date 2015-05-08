
public class Tea extends CaffeinatedDrinks {
	private String name = "Tea";
	private String flavor = "English Breakfast";
	

	public Tea(int size1, String flavor) {
		super(size1, "Tea");
		this.flavor =  flavor;
	}
	public Tea() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public String toString() {
		return "Tea [teaFlavor=" + flavor + "]"+super.toString();
	}
	
	public double getPrice() {
		return super.getPrice();
	}
	
	public String getFlavor(){
		return flavor;
	}
}
