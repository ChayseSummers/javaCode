
public class Enigma1 {
	private String inner;
	private String middle;
	private String outer = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
	public int innerCount;
	public int middleCount = 0;
	private int count;
	
	public Enigma1(String r1, String r2){
		inner = r1;
		middle = r2;
	}

	public String decode(String message) {
		//int i = 0;
		int tempIndex;
		char tempLetter;
		int tempIndex2;
		char[] tempInner = inner.toCharArray();
		char[] tempMiddle = middle.toCharArray();
		String decoded ="";
		char[] message1 = message.toCharArray();
		for(char character:message1){
			tempIndex = outer.indexOf(character);
			if(innerCount == tempInner.length-1){
				middleCount += 1;
			}
			tempLetter = tempMiddle[tempIndex];
			tempIndex2 = outer.indexOf(tempLetter);
			decoded = decoded + tempInner[tempIndex2];
			if(innerCount == tempInner.length-1){
				innerCount = 0;
			}
			else{
				innerCount += 1;
			}
			//tempInner = rotateInner(tempInner);
			Inner_rotate();
			
		}
		return decoded;
	}
	
	public String encode(String message) {
		//int i = 0;
		int tempIndex;
		char tempLetter;
		int tempIndex2;
		char[] tempInner = inner.toCharArray();
		String tempInner2 ="";
		String tempMiddle = middle;
		String encoded ="";
		char[] message1 = message.toCharArray();
		for(char character:message1){
			for(char letter: tempInner){
				tempInner2 = tempInner2 + letter;
			}
			tempIndex = tempInner2.indexOf(character);
			tempLetter = outer.charAt(tempIndex);
			tempIndex2 = tempMiddle.indexOf(tempLetter);
			encoded = encoded + outer.charAt(tempIndex2);
			
			//tempInner = rotateInner(tempInner);
			Inner_rotate();
			tempInner2 = "";
		}
		return encoded;
	}

//	public char[] rotateInner(char[] tempInner2){
//		int i = 0;
//		char temp1 = tempInner2[i];
//		char[] tempInner = new char[inner.length()];
//
//		for(char character:tempInner2){
//			
//			if(i==0){
//				tempInner[i]=tempInner2[tempInner2.length-1];
//			}
//			else{
//				tempInner[i]=temp1;
//				temp1 = character;
//			}
//			if(i==inner.length()-1){
//				i=0;
//				temp1 = tempInner2[i];
//			}
//			else{
//				i++;
//			}
//		}
//		return tempInner;
//	}

	// Rotate middle rotor after inner rotor returns to original position
    private void Mid_rotate() {
        if (count == inner.length()) {
            char last = middle.charAt(middle.length() - 1);
            middle = last + middle.substring(0, middle.length() - 1);
            count = 0;
        }
    }

    // Rotate inner rotor after converted
    private void Inner_rotate() {
        char last = inner.charAt(inner.length() - 1);
        inner = last + inner.substring(0, inner.length() - 1);
        count++;
        Mid_rotate();
    }
}
