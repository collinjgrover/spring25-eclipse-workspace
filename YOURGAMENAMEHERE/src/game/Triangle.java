package game;

import java.awt.*;

public class Triangle extends Polygon{

	public Triangle(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}
	
	
//	public void paint(Graphics brush) {
//		Point[] points = super.getPoints();
//        int[] xPoints = new int[points.length];
//        int[] yPoints = new int[points.length];
//        
//        for (int i = 0; i < points.length; i++) {
//            xPoints[i] = (int)points[i].x;
//            yPoints[i] = (int)points[i].y;
//        }
//
//        brush.setColor(Color.WHITE); 
//	}
	
}
