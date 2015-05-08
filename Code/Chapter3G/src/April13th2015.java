import java.awt.Color;
import java.awt.Graphics2D;

//CSC143
//Graphics Test

public class April13th2015 {

	public static final int CanvasHeight = 500,CanvasWidth = 800;
	public static final int TargetHeight = 250,TargetWidth = 450;
	public static int count = 0;
	public static final int attempts = 10000;
	public static void main(String[] args) {
		
		DrawingPanel canvas = new DrawingPanel(CanvasWidth,CanvasHeight);
		Graphics2D pen = canvas.getGraphics();
		pen.setColor(Color.red);
		draw(canvas, pen);
		for(int i = 1; i<=attempts; i++){
			throwADart(canvas, pen);		
				}
		double total = percentageHit();
		System.out.printf("The percentage of hits is %.1f out of %d attempts.", total, attempts);
		//System.out.println()
		

	}
	
	private static double percentageHit() {
		System.out.println((double)count/attempts);
		double percentage = ((double)count/attempts)*100;
		return percentage;
		
	}

	private static boolean didHitTarget(int x, int y){
		if((x<=(CanvasWidth-TargetWidth)/2+TargetWidth && x>=(CanvasWidth-TargetWidth)/2) && (y<(CanvasHeight-TargetHeight)/2 + TargetHeight && y>(CanvasHeight-TargetHeight)/2)){
			count++;
			System.out.println(count);
			return true;
			
		}
		return false;
		
	}

	private static void throwADart(DrawingPanel canvas, Graphics2D pen) {
		int dartX = (int) (Math.random()*canvas.getWidth());
		int dartY = (int) (Math.random()*canvas.getHeight());
		if(didHitTarget(dartX,dartY)){
			pen.setColor(Color.green);
		}
		else{
			pen.setColor(Color.red);
		}
		pen.fillRect(dartX, dartY, 3, 3);
		
		
	}

	private static void draw(DrawingPanel canvas, Graphics2D pen) {
		pen.drawRect((CanvasWidth-TargetWidth)/2, (CanvasHeight-TargetHeight)/2, TargetWidth, TargetHeight);
		
	}

}
