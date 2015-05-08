
public class StoryBook {

	public static void main(String[] args) {
		FictionalCharacter fc = new FictionalCharacter("Hercules", 76);
		Hero h = new Hero(56, "Wolverine", 67);
		BatMan b = new BatMan(77, "Bruce Wayne", 58, 34343434);
		
		b.spendStrength(10);

		
//		Object o = new BatMan(44, "BW", 45, 234434);
//		
//		b = (BatMan)h;
		
//		FictionalCharacter [] characters = new FictionalCharacter [3];
//		characters[0]=fc;
//		characters[1]=h;
//		characters[2]=b;
//		
//		for (FictionalCharacter fc1: characters){
//			System.out.println(fc1);
//		}
		
	}

}
