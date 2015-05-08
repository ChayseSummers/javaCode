
public class EnigmaClient {

	public static void main(String[] args) {
		Enigma example = new Enigma("#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV");
		Enigma example2 = new Enigma();
		example2.setRotor(5, 2, 5); //XOFTP##MOKPBHOPBOPOXBOAMORCXDIHTFOR#PGGOD#TPGTOVXJTOATKPBOPOD#IG
		String x = example2.encode("TEST HERE NOW dadf fd ");
		example2.setRotor(5, 2, 5);
		System.out.println(x);
		System.out.println(example2.decode(x));
		System.out.println(example2.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDT#FIEOWAIGFWQOCCRQ#AHZIDEOABHRAEHFUBR"));
		System.out.println(example.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDT#FIEOWAIGFWQOCCRQ#AHZIDEOABHRAEHFUBR"));
		System.out.println(example.decode("OKNNWRDHGERPILRLAMFZF#FMUC"));
		System.out.println(example.decode("OKNNWRDHGERPILRLAMFZF#FMUC"));
		System.out.println(example.encode("I#REALLY#WANT#AN#A#IN#MY#COMPUTER#CLASS#PLEASE#GIVE#ME#AN#A#PLUS"));
		System.out.println(example.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDV#FIEOWAIGFWQOCCRQ#AHZIDEOADHRAEHFUBR"));
		System.out.println(example2.decode("RQPMAJ#JAPVEYEISBFIQWFPLCHDV#FIEOWAIGFWQOCCRQ#AHZIDEOADHRAEHFUBR"));
		
	}

}
