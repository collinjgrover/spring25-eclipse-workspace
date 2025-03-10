package game;

public class Enemy extends Entity{
	
	private static Player player; // each enemy has only one corresponding player

	
	public Enemy(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		setDamageOutput(20);  
		setHP(75);
		double x = position.x;
	}
	
	/*
	 * should be called upon every moment of the player (?). Check if player is
	 * within a certain radius
	 */
	public void attemptAttack () {
		
	}
	
	// once we know the player is within desired radius then subtract health from
	// player
	private void attack() {
		player.setHP(player.getHp()-getDamageOutput());
	}
	

}
