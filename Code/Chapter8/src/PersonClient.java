
public class PersonClient {

	public static void main(String[] args) {
		Person p = new Person("Patrick Pow",3424356, 4543.34);
		
		//p.doubleWealth();
		//System.out.println(p);
		Person[] listOfPeople = new Person[10];
		Person c = new Person("Chayse Summers", 991129233, 100.00);
		Person b = new Person("Clemit Johnson", 8099112, 50.00);
		Person d = new Person("Calvey Auto", 0023452, 100000.00);
		Person e = new Person("Hendrix Zepplin", 1964, 1000000.00);
		Person f = new Person("Eggbert", 7162354, 198767.05);
		Person g = new Person("Tracy Jordan", 53453877, 12358.98);
		Person h = new Person("Aimee Lemon", 123456, 50.00);
		Person i = new Person("Jeremia Fredrixson", 123456677, 50.00);
		Person j = new Person("Smith England", 321456723, 50.00);
		
		
		listOfPeople[0]= c;
		//System.out.println(listOfPeople[0]);
		listOfPeople[1] = new Person("Jerry Rice", 80, 12.34e17);
		listOfPeople[2] = d;
		listOfPeople[3] = b;
		listOfPeople[4] = e;
		listOfPeople[5] = f;
		listOfPeople[6] = g;
//		listOfPeople[7] = h;
//		listOfPeople[8] = i;
//		listOfPeople[9] = j;
		//System.out.println(listOfPeople[1]);
		printPersonsList(listOfPeople);
		
		System.out.println(c); //After calling printPersonsList the doubled wealth value sticks with the person
		//object.

	}

	private static void printPersonsList(Person[] list) {
		for(Person p:list){
			if(p!=null){
				p.doubleWealth();
				System.out.println(p);
			}
		}
	}

}
