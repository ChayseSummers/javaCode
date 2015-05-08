
public class EnigmaClient {

	public static void main(String[] args) {
		Enigma example = new Enigma("#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV");
		System.out.println(example.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDT#FIEOWAIGFWQOCCRQ#AHZIDEOABHRAEHFUBR"));
		System.out.println(example.decode("OKNNWRDHGERPILRLAMFZF#FMUC"));
		System.out.println(example.decode("OKNNWRDHGERPILRLAMFZF#FMUC"));
		System.out.println(example.encode("I#REALLY#WANT#AN#A#IN#MY#COMPUTER#CLASS#PLEASE#GIVE#ME#AN#A#PLUS"));
		System.out.println(example.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDV#FIEOWAIGFWQOCCRQ#AHZIDEOADHRAEHFUBR"));
		 
		//example.setMiddle(1)
		
		//Enigma new = new En
//		example.setInnerRotor("");
	}

}
