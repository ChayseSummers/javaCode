/* Chayse Summers
 * CSC142 - Gandham
 * January 29th, 2015
 * ICE 8
 */
import java.awt.*;
public class ICE8 {
	// This was an interesting program to build, it helped me to see how to display
	//graphics and info in the same problem. I enjoyed building the triangle and discovering
	//how to get the area to compute and display on the screen. If I wanted to put more time
	//into this I would probably change colors for the sides or lables of the sides.

	public static void main(String[] args) {
		
		int width = 900; int height = 1000; // Variables for canvas size.
		double side1x = 100; double side1y = 200;
		double side2x = 700; double side2y = 200; // Variables for points of triangle.
		double side3x = 700; double side3y = 900;
		
		DrawingPanel canvas = new DrawingPanel(width,height); // Creating canvas and pen
		Graphics2D pen = canvas.getGraphics();//to draw with.
		
		pen.drawLine(100,200,700,900);// Using pen to draw sides of triangle
		pen.drawLine(700,200,700,900);//from point to point.
		pen.drawLine(100,200,700,200);
		
		double sideA = lengthD (side1x,side1y,side2x,side2y);
		double sideB = lengthD (side1x,side1y,side3x,side3y);// Calling upon method lengthD
		double sideC = lengthD (side2x,side2y,side3x,side3y);//to calculate length of sides.
		
		double semi = (sideA+sideB+sideC)/2;// Calculating semi-parameter for use in area calculation.
		double Area = Math.sqrt(semi*(semi-sideA)*(semi-sideB)*(semi-sideC));// Calculating area.
		
		String A = "Side A = "+sideA;
		String B = "Side B (rounded) = "+Math.round(sideB);// Strings to display computed information on screen.
		String C = "Side C = "+sideC;
		String dispArea = "The area of this triangle rounded to the nearest whole number is: "+ Math.round(Area);
		String dispArea2 = "The area of this triangle not rounded is: "+ Area;
		
		pen.drawString(A,400,190);
		pen.drawString(B,200,550);// Drawing strings to canvas.
		pen.drawString(C,710,550);
		pen.drawString(dispArea, 100, 900);
		pen.drawString(dispArea2, 100, 925);
	}

	private static double lengthD(double x1, double y1, double x2, double y2) {
		double x = x2-x1;
		double y = y2-y1;
		double d = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		return d;
		// Method to calculate the length between two points.
	}
	
		

}
