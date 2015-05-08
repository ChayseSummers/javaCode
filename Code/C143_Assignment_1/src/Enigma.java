
//Work on javadocs, email meeting tomorrow at trio RSB66 or 67 possibly noon.

public class Enigma {
	private String outer = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
	private String middle;
	private String inner;
	private int count;
	private String tempInner;
	private String tempMiddle;
	
	/**
	 * 
	 * @param in
	 * @param mid
	 */
	public Enigma(String in, String mid){
		this.middle = mid;
		this.inner = in;
		this.tempInner = in;
		this.tempMiddle = mid;
		
	}
	public String encode(String message){
		 //List<String> inner = new ArrayList<String>(Arrays.asList(third.split("")));
	        String result ="";
	        for (char ch: message.toCharArray()) {
	            
	            //first
	            String thai = String.valueOf(ch);
	            
	            // 1-3-2-3
	            int f = inner.indexOf(thai);
	           // int f = getIndex(thai,inner);
	            char thai_step2 = outer.charAt(f);//.get(f);// chu vong 3
	            f = middle.indexOf(thai_step2);//getIndex(thai_step2,middle); // get index vong 2
	            char thai_step3 = outer.charAt(f);//.get(f);
	            //f = getIndex(thai_step3,vong3);
	            result += thai_step3;
	            Inner_rotate();
	        }
	        resetRotors();
	        return(result);
	}
	            
//	            String temp = inner.get(inner.size()-1);
//	            inner.remove(inner.size()-1);
//	            
//	            inner.add(0, temp);
//	            
//	            for(int j = 0; j <inner.size();j++)    
//	                System.out.print(inner.get(j));
//	            System.out.println();
//	                            
//	        }
//	        System.out.println(result);
//	            
//	                 
//	    }
//	
//    public static int getIndex(String a,List<String> temp){
//        for(int i =0;i< temp.size();i++){
//             if(temp.get(i).equals(a)){
//                 return i;
//             }
//         }
//        return 0;
//    }
	
	public String decode(String message){
		int outTempIndex;
		char midTempChar;
		String result = "";
		for(char character: message.toCharArray()){
			outTempIndex = outer.indexOf(character);
			midTempChar = middle.charAt(outTempIndex);
			outTempIndex = outer.indexOf(midTempChar);
			result = result + inner.charAt(outTempIndex);
			Inner_rotate();
		}

		
		resetRotors();
		return result;
	}

    private void resetRotors() {
    	count = 0;
		inner = tempInner;
		middle = tempMiddle;
		
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
	
}