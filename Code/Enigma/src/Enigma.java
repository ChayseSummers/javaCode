/**
 * Here we have an Engima Class which can construct Enigma Models for us to use
 * in encrypting and decrytping messages. The program allows the user to create
 * a default Enigma model with the assignments example rotors as the default.
 * The program also has a constructor class to allow the user to input what the
 * middle and inner rotors contents should be. Apart from choosing a default or
 * custom enigma model, the user can also chose to specify which position all
 * three rotors should start in. It should be noted that the rotors will reset
 * to default position of (0,0,0) after encrypting or decrypting a message.
 * 
 * @author Quyen T Truong, Chayse Summers, Phuc Tan Bui
 * @version 1.2.3
 * @date April 24th, 2015
 */

public class Enigma {
	private String outer = " BDFHJLNPRTVXZACEGIKMOQSUWY";
	private String middle;
	private String inner;
	private int count;
	private String tempInner;
	private String tempMiddle;
	private String tempOuter;

	public Enigma() {
		// this.outer="#BDFHJLNPRTVXZACEGIKMOQSUWY"; //I don't think this code
		// is necessary for default
		// constructor. Quyen please remove this code when putting in your
		// comments/javadocs.
		this.middle = " EJOTYCHMRWAFKPUZDINSXBGLQV";
		this.inner = " GNUAHOVBIPWCJQXDKRYELSZFMT";
		this.tempInner = inner;
		this.tempMiddle = middle;
		this.tempOuter = outer;
	}

	/**
	 * Constructor method for enigma model which allows the user to determine
	 * what the inner and middle rotors are.
	 * 
	 * @author Chayse Summers
	 * @param in
	 *            Used to set what the inner rotors contents are. 27 characters
	 *            required.
	 * @param mid
	 *            Used to set what the middle rotors contents are. 27 characters
	 *            required.
	 */
	public Enigma(String in, String mid) {
		this.middle = mid;
		this.inner = in;
		this.tempInner = in;
		this.tempMiddle = mid;
		this.tempOuter = outer;

	}

	public String encode(String message) {
		String result = "";
		try {
			for (char ch : message.toUpperCase().toCharArray()) {

				// first
				String thai = String.valueOf(ch);
				if(thai.equals(' ')){
					thai.replace(' ', '#');
				}

				// 1-3-2-3
				int f = inner.indexOf(thai);
				char thai_step2 = outer.charAt(f);
				f = middle.indexOf(thai_step2);
				char thai_step3 = outer.charAt(f);
				result += thai_step3;
				Inner_rotate();
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Number of Character for rotor is Invalid!");
			System.exit(0);
		}
		resetRotors();
		return (result);

	}

	/**
	 * This method is used to decode an already encoded message using the same
	 * rotors and positioning of rotors, as the encoded message had used.
	 * 
	 * @author Chayse Summers
	 * @param message
	 *            i.e. the message to be decoded.
	 * @return result which is equal to the decoded message.
	 */
	public String decode(String message) {
		int outTempIndex; // used to temporarily keep track of an index number
							// in the decryption process.
		char midTempChar;// Used to temporarily keep track of a letter as part
							// of the decryption process.
		String result = ""; // Variable to store each decrypted character
							// throughout the process.

		// Decrytion process here where we look at the first character of the
		// encrypted message and find what
		// index that is on the outer rotor. From there we make note of which
		// character is at that same spot on
		// the middle rotor, storing this character temporarily. Now we find
		// that character on the outer rotor
		// and add the character at the same index on the inner rotor to the
		// "result" variable.
		try {
			for (char character : message.toUpperCase().toCharArray()) {
				outTempIndex = outer.indexOf(character);
				midTempChar = middle.charAt(outTempIndex);
				outTempIndex = outer.indexOf(midTempChar);
				result = result + inner.charAt(outTempIndex);
				Inner_rotate();
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Number of Character for rotor is Invalid!");
			System.exit(0);
		}// Catch for the case where there is either too many or too few
			// characters on one of the rotors.

		resetRotors();
		return result;
	}

	/**
	 * This method is used to reset the rotors back to default position (0,0,0)
	 * after having encrypted or decrypted a message.
	 * 
	 * @author Chayse Summers
	 */
	private void resetRotors() {
		count = 0;
		inner = tempInner;
		middle = tempMiddle;
		outer = tempOuter;

	}

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

	public void setRotor(int pos_inner, int pos_mid, int pos_outer) {
		resetRotors();
		try {
			if (pos_inner != 0)
				inner = inner.substring(pos_inner, inner.length())
						+ inner.substring(0, pos_inner);
			// System.out.println("After rotor change (inner) " + inner);
			if (pos_mid != 0)
				middle = middle.substring(pos_mid, middle.length())
						+ middle.substring(0, pos_mid);
			// System.out.println("After rotor change (middle) " + middle);
			if (pos_outer != 0)
				outer = outer.substring(pos_outer, outer.length())
						+ outer.substring(0, pos_outer);
			// System.out.println("After rotor change (outer) " + outer);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Out of range");
			System.exit(0);
		}
	}

}