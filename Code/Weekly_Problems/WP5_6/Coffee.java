
public class Coffee extends CaffeinatedDrinks {
	private String name = "Drip";
	private double price_surcharge;
	private String type;
	
	public Coffee(int size1, String name) {
		super(size1,"Coffee");
		if(size1 == 12 || size1 == 16){
			if(size1==12){
				this.price_surcharge = .50;
			}
			else{
				this.price_surcharge = 1.00;
			}
		}
		else{
			this.price_surcharge = 0;
		}
		this.name = "Coffee";
		this.type = name;
	}
	public Coffee() {
		super();
		this.price_surcharge = 0;
	}
	public double getPrice_surcharge() {
		return price_surcharge;
	}
	public void setPrice_surcharge(double price_surcharge) {
		this.price_surcharge = price_surcharge;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Coffee [type=" + type + "]"+super.toString();
	}
	
	public double getPrice() {
		return super.getPrice()+price_surcharge;
	}
	
	public String getName(){
		return name;
	}
	
	public double getCost(){
		return super.getCost()+price_surcharge;
	}
	
	

}
