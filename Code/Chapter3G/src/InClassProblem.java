import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.*;

public class InClassProblem {

	public static void main(String[] args) {
		int width = 1200; int height = 800;
//		int x = 100; int y = 100;
		DrawingPanel canvas = new DrawingPanel(width,height); 
		Graphics2D pen = canvas.getGraphics();
//		for (x=100;x<=width;x=x+100){
//			pen.drawLine(x, 00, x, height);
//		}
//		for (y=100;y<=height;y=y+100){
//			pen.drawLine(00, y, width, y);
//		}
	// How I did it.
		
		drawPattern(canvas,pen);
		
			
	}

	private static void drawPattern(DrawingPanel canvas, Graphics2D pen) {
		int side = 100;
		int mid = 50;
		for (int i=0; i <canvas.getWidth()/side;++i){
			for(int j = 0; j<= canvas.getHeight()/side; j++){
				if (pen.getColor().equals(Color.white))
					pen.setColor(Color.red);
				else
					pen.setColor(Color.black);
				int x = i*side;
				int y = j*side;
				pen.drawRect(x, y, side, side);
				if (pen.getColor().equals(Color.black))
					pen.setColor(Color.red);
				else
					pen.setColor(Color.black);
				pen.fillOval(x, y, side, side);
				canvas.sleep(30);
			//pen.setColor(Color.white);
			if (pen.getColor().equals(Color.red))
				pen.setColor(Color.white);
			else
				pen.setColor(Color.black);
			pen.drawLine(x,y+mid,x+mid,y);
			pen.drawLine(x+mid,y,x+side,y+mid);
			pen.drawLine(x+side,y+mid,x+mid,y+side);
			pen.drawLine(x+mid,y+side,x,y+mid);
			}// How he did it.
		}
			
		}
		
	

}
