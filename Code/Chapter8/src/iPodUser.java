
public class iPodUser {

	public static void main(String[] args) {
		iPod chaysesIpod = new iPod("red", 500);
		iPod marcosIpod = new iPod("red", 400);
		System.out.println(chaysesIpod);//.showDetails()); These .showDetails not needed
		System.out.println(marcosIpod);//.showDetails()); after changing method to toString();
		System.out.println(chaysesIpod.equals(marcosIpod));
		chaysesIpod.charge();
		String[] songs = {"1000 miles","Bad Day","Good Day","Beat It","Lucy in the Sky with Diamonds"};
		chaysesIpod.loadSongs(songs);
		chaysesIpod.playSongs();
		System.out.println(chaysesIpod);//.showDetails());

	}

}
