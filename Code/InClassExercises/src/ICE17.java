import java.util.*;
public class ICE17 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int[] list1 = {1,2,3,4,5};
		int[] list2 = {2,4,6};
		int[] newList = appendArrays(list1,list2);
		System.out.println(Arrays.toString(newList));
		console.close();
	}

	private static int[] appendArrays(int[] list1, int[] list2) {
		int[] appended = new int[list1.length+list2.length];
		int count = 0;
		for(int i = 0;i<list1.length;i++){
			appended[i]=list1[i];

		}
		for(int j = list1.length; j<appended.length;j++){
			appended[j]=list2[count];
			count= count + 1;
		}
		return appended;
	}

}
