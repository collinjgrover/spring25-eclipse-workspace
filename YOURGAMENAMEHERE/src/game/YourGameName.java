package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.Polygon;
import java.awt.event.*;

class YourGameName extends Game {
	static int counter = 0;

	static Triangle triangle;
	
//	Collection<Map> maps;

	public YourGameName() {
		super("YourGameName!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);
		
		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		
		Point p1 = new Point(100.0d, 100.0d);
		Point p2 = new Point(400.0d, 100.0d);
		Point p3 = new Point(400.0d, 500.0d);

		Point[] points = {p1, p2, p3};
		
		Point center = new Point(300.0d, 233.00d);
		
        int[] xPoints = new int[points.length];
        int[] yPoints = new int[points.length];
        
        for (int i = 0; i < points.length; i++) {
            xPoints[i] = (int)points[i].x;
            yPoints[i] = (int)points[i].y;
        }
		triangle = new Triangle(points, center, counter);
		
		brush.setColor(Color.white);
        brush.fillPolygon(xPoints, yPoints, 3 );
//        brush.fillPolygon);
		
		counter++;
//		brush.drawString("Counter is " + counter, 10, 10);
	}

	public static void main(String[] args) {
		YourGameName a = new YourGameName();
		
		a.repaint();
	}
}