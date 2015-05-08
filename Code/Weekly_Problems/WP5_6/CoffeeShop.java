import java.util.*;

/**
 * This is Client class for the Drinks.java super class which allows the user to create different types of 
 * drinks and be given back the drink order and total cost.
 * 
 * @author Chayse Summers
 * @CSC143 - Gandham
 * @Weekly Problem 5 & 6
 *
 * This was quite the assignment. I learned a valuable lesson in concentrating on coding rather than intermittently
 * coding overtime. At one point I had this program working and just about ready to turn in, I decided to 
 * come back to it over the weekend to finish up and add my comments. What actually happened is that I got 
 * distracted while coding and kept setting it down and coming back. Each time starting to fix something and 
 * then setting it down again. By the end of the night my code was hacked and no longer in working order. After
 * spending some solid time (a little over an hour) fixing it up, I can now say this program is running. It's
 * interesting how the inheritance feature works, seems like it could prove to be very useful.
 */
public class CoffeeShop {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Drinks a = new Drinks();
		Drinks b = new Drinks(12,"Iced Soda");
		Drinks c = new Drinks(16,"Massive Iced Soda");
		Drinks d = new Drinks(8,"WrongSizeTest Drinks");
		
		Drinks[] order1 = {a,b,c,d};
		orderOut(order1);
		
		
		CaffeinatedDrinks e = new CaffeinatedDrinks();
		CaffeinatedDrinks f = new CaffeinatedDrinks(12, "Energy Drink");
		CaffeinatedDrinks g = new CaffeinatedDrinks(16, "Massive Energy Drink");
		CaffeinatedDrinks h = new CaffeinatedDrinks(8, "WrongSizeTest Caff.Drinks");
		
		CaffeinatedDrinks[] order2 = {e,f,g,h};
		orderOut(order2);
		
		
		Coffee i = new Coffee();
		Coffee j = new Coffee(12, "Mocha");
		Coffee k = new Coffee(16,"Godzilla");
		Coffee l = new Coffee(8, "WrongSizeTest Coffee");
		
		Coffee[] order3 = {i,j,k,l};
		orderOut(order3);
		
		
		NonCaffeinatedDrinks m = new NonCaffeinatedDrinks();
		NonCaffeinatedDrinks n = new NonCaffeinatedDrinks(12, "Juice");
		NonCaffeinatedDrinks o = new NonCaffeinatedDrinks(16, "Massive Juice");
		NonCaffeinatedDrinks p = new NonCaffeinatedDrinks(8, "WrongSizeTest NonCaff.Drinks");
		
		NonCaffeinatedDrinks[] order4 = {m,n,o,p};
		orderOut(order4);
		
		
		Tea q = new Tea();
		Tea r = new Tea(12, "Peach");
		Tea s = new Tea(16, "Rooibos");
		Tea t = new Tea(8, "WrongSizeTest Tea");
		
		Tea[] order5 = {q,r,s,t};
		orderOut(order5);
		
		console.close();
		
	}

	private static void orderOut(Drinks[] order2) {
		String cup;
		double total = 0;
		System.out.println("Your order consists of...");
		for(Drinks order:order2){
			if(order.getSize() == 6){
				cup = "Small";
			}
			else if (order.getSize() == 12){
				cup = "Medium";
			}
			else if(order.getSize() == 16){
				cup = "Large";
			}
			else{
				System.out.println("Sorry I don't have that size, here's a six ounce.");
				cup = "Small";
				}
			
			if(order.getName() == "Tea"){
				System.out.printf("\t%s: %s, size %s %doz., cost: $%.2f\n", order.getName(), ((Tea) order).getFlavor(), cup, order.getSize(), order.getCost());
			}
			else if(order.getName() == "Coffee"){
				System.out.printf("\t%s, %s, size %s %doz., cost: $%.2f\n", order.getName(), ((Coffee) order).getType(), cup, order.getSize(), order.getCost());
			}
			else{
				System.out.printf("\t%s, size %s %doz., cost: $%.2f\n", order.getName(), cup, order.getSize(), order.getCost());
			}
			total = total + (order.getCost());
			
		}
		System.out.printf("Your total comes to: $%.2f\n\n",total);
	}


}
