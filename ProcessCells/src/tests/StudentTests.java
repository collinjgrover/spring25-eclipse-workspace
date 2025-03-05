package tests;

import static org.junit.Assert.*;
import java.io.StreamCorruptedException;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.BoardCell;
import model.Game;
import model.ProcessCellGame;

/* The following directive executes tests in sorted order */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void studentTest1() {
		// testing next animation step
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String answer = "";

		int maxRows = 5, maxCols = 6, strategy = 1;
		Game game = new ProcessCellGame(maxRows, maxCols, new Random(2L),
				strategy);

		game.nextAnimationStep();
		game.nextAnimationStep();

		answer = getBoardStr(game);
		System.out.println(answer);
		System.out.print(getBoardStr(game));
		answer = "Board(Rows: 5, Columns: 6)\n" + "GRBYRG\n" + "YBRBRR\n"
				+ "......\n" + "......\n" + "......\n" + "";

		assertTrue(answer == getBoardStr(game));
//		assertTrue(TestingSupport.isResultCorrect(testName, answer, true));
	}

	@Test
	public void studentTest2() {
		// testing next animation step, with invalid inputs
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String answer = "";

		int maxRows = 0, maxCols = 0, strategy = 1;
		Game game = new ProcessCellGame(maxRows, maxCols, new Random(2L),
				strategy);
		Game game1 = new ProcessCellGame(-1, -1, new Random(2L), strategy);

		// testing invalid input sizes
		assertTrue(2 == game.getMaxCols() && 2 == game.getMaxRows());
		assertTrue(2 == game1.getMaxCols() && 2 == game1.getMaxRows());
	}

	@Test
	public void studentTest3() {
		// testing processCell() and score
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String answer = "";

		int maxRows = 5, maxCols = 6, strategy = 1;
		Game game = new ProcessCellGame(maxRows, maxCols, new Random(2L),
				strategy);

		game.nextAnimationStep();
		game.nextAnimationStep();
		game.nextAnimationStep();
		game.nextAnimationStep();

//		RGYBRB
//		RrRGBR --> calling processCell on row 1 col 1, 5 cells should be cleared
//		GRBYRG
//		YBRBRR
//		......

		game.processCell(1, 1);

		answer = getBoardStr(game);

		System.out.println(answer);
		int score = 5;
		String board = "Board(Rows: 5, Columns: 6)\n" + ".GYBRB\n" + "...GBR\n"
				+ "G.BYRG\n" + "YBRBRR\n" + "......";
		assertTrue(board.contains(answer));
		assertTrue(score == game.getScore());
	}

	@Test
	public void studentTest4() {
		/*
		 * things to test: ensure score is right ensure rows are collapsing
		 *' If you add a new strategy, make sure you add a conditional so the
		 * processing described below is associated with strategy #1. '
		 * 
		 * edge cases: 0 or less input board dimension nextAnimationStep
		 * maxRows() # of times
		 * setRow or setCol w/ color 
		 * 	- invalid idx inputs, color is ?
		 * 
		 */
	}

	/* Support methods (from PublicTests.java) */
	private static String getBoardStr(Game game) {
		int maxRows = game.getMaxRows(), maxCols = game.getMaxCols();

		String answer = "Board(Rows: " + maxRows + ", Columns: " + maxCols
				+ ")\n";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				answer += game.getBoardCell(row, col).getName();
			}
			answer += "\n";
		}

		return answer;
	}
}
