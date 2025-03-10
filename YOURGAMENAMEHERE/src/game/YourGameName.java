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

	public YourGameName() {
		super("YourGameName!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		
		// code i wrote (to init an element):
		Point p1 = new Point(0.0d, 0.00d);
		Point p2 = new Point(300.0d, 0.0d);
		Point p3 = new Point(0.0d, 100.0d);	
		
		Point[] points = {p1, p2, p3};
		
		Point center = new Point(300.0d, 233.00d);
       
		triangle = new Triangle(points, center, 0);
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);
		 
		brush.setColor(Color.red);

        triangle.paint(brush);
        triangle.move();

    	// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.drawString("Counter is " + counter, 10, 10);
	}

	public static void main(String[] args) {
		YourGameName a = new YourGameName();
		
		a.repaint();
	}
	
	
}