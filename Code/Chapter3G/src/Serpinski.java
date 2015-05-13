import java.awt.Color;
import java.awt.Graphics2D;




public class Serpinski {
	public static final int size = 900;
	public static final Color[] COLORS = {Color.blue,Color.green,Color.magenta,Color.ORANGE,Color.red,Color.PINK};

	public static void main(String[] args) {
		DrawingPanel carpet = new DrawingPanel(size,size);
		drawSerpinski(carpet);

	}

	public static void drawSerpinski(DrawingPanel carpet) {
		Graphics2D pen = carpet.getGraphics();
		drawCarpet(carpet, pen, 0, 0, size, 5);
	}

	private static void drawCarpet(DrawingPanel carpet, Graphics2D pen, int x,
			int y, int side, int level) {
		if(level >= 1){//recursive path.
			side = side/3;
			for(int row =0 ; row<=2;++row){
				for(int col = 0; col<=2;++col){
					drawCarpet(carpet, pen, x+side*col, y+side*row, side, level-1);
					//carpet.sleep(2);
				}
			}
			pen.setColor(COLORS[level-1]);//(COLORS[level-1]);
			pen.fillRect(x+side, y+side, side, side);
		}
			
	}

}
