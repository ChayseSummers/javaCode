import java.util.*;
public class Drinks {
	private String name;
	private double price_per_oz = .10; //10 cents per ounce.
	private int size; //in ounces.

	public Drinks(){
		this.name = "Basic Drink";
		this.price_per_oz = .10;
		this.size = 6;
	}
	
	public Drinks(int size, String name){
		this.name = name;
		if(size == 6||size == 12 || size == 16){
			this.size = size;
		}
		else{
			System.out.println("Sorry, we don't carry that size. 6oz is our default.");
			this.size = 6;
		}
	}
	
	public double getPrice() {
		return price_per_oz;
	}

	@Override
	public String toString() {
		
		return "Drinks [price=" + getPrice() + ", size=" + getSize() + "oz."+", cost= $" + (getPrice()*getSize())+ "]";
	}

	public void setPrice_per_oz(double price_per_oz) {
		this.price_per_oz = price_per_oz;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return this.price_per_oz*this.size;
	}

}
