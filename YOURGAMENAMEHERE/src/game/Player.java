package game;

import java.util.Collection;

public class Player extends Entity {

	/*
	 * items to be used, can press a key to use a corresponding item, and if the
	 * player has that item then the item is used.
	 */
	private boolean hasSword;
	// do we even need to do a pickaxe? we could just reveal the door to next
	// 'level' after final enemy is killed;
	private boolean hasPickaxe;
	private boolean hasPowerup;
	
	// the player has a collection of enemies on the board at any given time;
	private Collection<Enemy> enemies; 

	private static int score;

	public Player(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		score = 0;
		hasSword = false;
		hasPickaxe = false;
		hasPowerup = false;
		
		/*
		 * figure out size of player 
		 */
		
		
	}
	
	public void obtainSword() {
		hasSword = true;
	}
	
	// bind this method to a key ...
	// check if hasSword and if an enemy is within a certain radius
	// if there is an enemy, subtract health from them. 
	// from there, if enemy hp reaches 0, clear that enemy from the board, and 
	// increase score.
	// (make that old Enemy obj eligible for garbage collection?)
	public void useSword() {
		if (hasSword) {
			
			for (Enemy currEnemy : enemies) {
				if (withinRadius(currEnemy)) {
					attack(currEnemy);
					
				}
			}
		}
	}
	
	private boolean withinRadius(Enemy enemy) {
		// if they are within 50 pixels up / down, the enemy is within 
		// a swingable distance
		boolean out = false;
		
		double xDiff = Math.abs(position.x - enemy.position.x);
		double yDiff = Math.abs(position.y - enemy.position.y);
		if (xDiff < 50 || yDiff < 50) {
			out = true;
		} 

		return out;
	}
	
	public void obtainPickaxe() {
		hasPickaxe = true;
	}
	
	// bind this method to a key ...
	// check if hasPickaxe and if a wall construct is nearby to mine 
	// if so, break wall construct it is clicked on if/only if it is the way to 
	// the door to next lvl?
	
	// maybe we just shouldnt do the pickaxe ?
	public void usePickaxe() {
		
	}
	
	public void obtainPowerup() {
		hasPowerup = true;
	}
	
	
	// bind this method to a key ...
	// check if hasPowerup and if so, refill your HP to 100/100
	public void usePowerup() {
		if (hasPowerup)
			setHP(100);
	}
	
	public void addEnemy(Enemy enemy) {
		// figure out what type of data structure to use, then add it
		// arrayList should be fine
		
		if (!enemies.contains(enemy)) { // prevent duplications
			enemies.add(enemy);
		}
	}
	
	public Collection<Enemy> getEnemies() {
		return enemies;
	}
	
	// sets new HP of enemy after an attack is done, if enemys HP reaches 0 or 
	// less, the enemy is removed from the collection of enemies
	private void attack(Enemy enemy) {
		int newHp = enemy.getHp() - getDamageOutput();
		enemy.setHP(newHp);
		if (newHp <= 0) {
			enemies.remove(enemy);
		}
	}

}
