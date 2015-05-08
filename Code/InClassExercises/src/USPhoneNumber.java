// CSC 142
// Chayse Summers
// 3/17/2015
public final class USPhoneNumber {
	//fields
	private int area;
	private int exchange;
	private int extension;
	
	//constructor(s)
	public USPhoneNumber(int a, int exc, int ext){
		area = a;
		exchange = exc;
		extension = ext;
	}
	
    // equals method
	public boolean equals(USPhoneNumber ph2){
		return(this.area == ph2.area && this.exchange == ph2.exchange && this.extension == ph2.extension);
	}

	
	
	//toString method
	public String toString() {
       return("("+area+") "+exchange+"-"+extension);
    }


	//This static method tests this class
    public static void main(String[] args) {
    	
        USPhoneNumber a = new USPhoneNumber(206, 934, 5300);
        USPhoneNumber b = new USPhoneNumber(206, 877, 5379);
        USPhoneNumber c = new USPhoneNumber(206, 934, 5300);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("a == b:      " + (a == b));// false
        System.out.println("a == c:      " + (a == c));// false
        
        System.out.println("a.equals(b): " + (a.equals(b)));// false
        System.out.println("a.equals(c): " + (a.equals(c)));// true
    }



}
