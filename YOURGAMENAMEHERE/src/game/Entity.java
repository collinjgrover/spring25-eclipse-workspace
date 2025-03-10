package game;

import java.awt.Color;
import java.awt.Graphics;

public class Entity extends Polygon{
	
	private int hp;
	private int damageOutput;

	public Entity(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		hp = 100;
		damageOutput = 0; // will be set in subclasses
	}
	
	/*
	 * change the position of your element if the forward key is being held and
	 * change the rotation of the element if either of the turn keys are being
	 * held.
	 */
	public void move() {
		
		// move forward (up) aka w key
		// translate all inShape() up by a set amount of pixels, 
		int xMax = 800;
		int yMax = 600;
		// set an amount of pixels to move up by 
		int xMove = 2 ;
		double currX = position.x;
		int yMove = 2;
		double currY = position.y;
		
//		// moving forward , aka up , or W key
		if ( currY - yMove > 0.00) {
			position.y -= yMove;
			// 0 deg is due east, so 90 deg is straight ahead
			rotation = 90.00;
		}
		
//		 moving down
//		if (currY + yMove < yMax) {
//			position.y += yMove;
//			rotation = 270.00;
//		}
//		
//		// move right
//		if (currX + xMove < xMax) {
//			position.x += xMove;
//			rotation = 360.00;
//		}
//		
//		// move left
		if (canMoveLeft() && currX - xMove > 0.00) {
			position.x -= xMove;
			rotation = 180.00;
		}
		
	}
	
	private boolean canMoveLeft() {
		// must implement after wall constructs are implemented
		return true;
	}

	public void paint(Graphics brush) {
		Point[] points = getPoints();

		int[][] xYPoints = dividePoints(points);
		
		brush.fillPolygon(xYPoints[0], xYPoints[1], 3);

		brush.setColor(Color.WHITE);
	}

	private int[][] dividePoints(Point[] points) {
		int[] xPoints = null;
		int[] yPoints = null;

		xPoints = new int[points.length];
		yPoints = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].x;
			yPoints[i] = (int) points[i].y;
		}
		int[][] out = { xPoints, yPoints };

		return out;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public void setDamageOutput(int damage) {
		damageOutput = damage;
	}
	
	public int getDamageOutput() {
		return damageOutput;
	}
	
	public int getHp () {
		return hp;
	}
	
}