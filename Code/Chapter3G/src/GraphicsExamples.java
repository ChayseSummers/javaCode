import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class GraphicsExamples {

	public static void main(String[] args) {
		DrawingPanel canvas = new DrawingPanel(600,400);
		Graphics2D pen = canvas.getGraphics();
		
		pen.setColor(Color.red);// Determines the color or the pen.
		
//		//pen.drawOval(250, 150, 100, 100);// This will draw a open oval.
//		pen.fillOval(250, 150, 100, 100);// This will draw a filled in oval.
//		
//		pen.setColor(Color.RED);// Placing a pen.setColor before the object to be draw allows
//		//you to change the colors between object. Must be layered in proper order to get desired
//		//color scheme.
//		pen.fillRect(50, 50, 50, 80);
//		
//		pen.setColor(Color.BLUE);
//		pen.drawLine(0, 0, 600, 400);
//		
		String message = "This is CSC 142 Bouncy Ball :)";
		pen.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 24));// Name, style, size.
		
		int x = 100;
		int y = 200;
		int size = 40;
		int xStep = 15;
		int yStep = 15;
		int yDirection = 1;
		int xDirection = 1;
		for (int num = 1; num <= 5000; num = num + 1){
			//pen.setColor(Color.red);
			if (y< 0 || y > canvas.getHeight()){//575)
				yDirection = yDirection * -1;
				//pen.setColor(Color.green);
				if (pen.getColor().equals(Color.yellow))
					pen.setColor(Color.RED);// new Color(red, green, blue)
				else
					pen.setColor(Color.green);
			}
			
			if (x< 0 || x > canvas.getWidth()){//575)
				xDirection = xDirection * -1;
				if (pen.getColor().equals(Color.green))
					pen.setColor(Color.yellow);
				else
					pen.setColor(Color.blue);
				//pen.setColor(Color.GREEN);
			}
			pen.fillOval(x, y, size, size);
			//pen.fillOval(x*2, y*2, size, size);
			x = x + xStep*xDirection;
			y = y + yStep*yDirection;
			//pen.setColor(Color.CYAN);
			//pen.drawString(message, 200, 350);
			canvas.sleep(30);
			canvas.clearWithoutRepaint();
		}
			

	}

}
