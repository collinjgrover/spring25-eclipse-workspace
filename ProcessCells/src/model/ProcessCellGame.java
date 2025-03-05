/*
 * Name: Collin Grover
 * UID: 121312136
 * Date: 2/26/25
 * 
 * This child class of Game.java provides a specific implementation of a Game 
 * that involves a Board, represented by a 2D array, each element representing a 
 * cell. Given the visual representation provided as well as the javadoc this 
 * class provides the mechanisms to get a functioning game, similar to Candy
 * Crush where cells surrounding your selected cell are eliminated if they hold
 * the same color. This involves immediately modifying the board to represent 
 * each move done by the user. 
 */
package model;

import java.util.Random;

/**
 * This class extends GameModel and implements the logic of strategy #1. A
 * description of this strategy can be found in the javadoc for the processCell
 * method.
 * 
 * We define an empty cell as BoardCell.EMPTY. An empty row is defined as one
 * where every cell corresponds to BoardCell.EMPTY.
 * 
 * @author Department of Computer Science, UMCP
 */

public class ProcessCellGame extends Game {

	// field(s) likely to be needed below
	private int strategy;
	private int score;
	private Random random;

	/**
	 * Defines a board with empty cells. It relies on the super class
	 * constructor to define the board. The random parameter is used for the
	 * generation of random cells. The strategy parameter defines which
	 * processing cell strategy to use (for this project the default will be 1).
	 * 
	 * @param maxRows
	 * @param maxCols
	 * @param random
	 * @param strategy
	 */
	public ProcessCellGame(int maxRows, int maxCols, Random random,
			int strategy) {
		super(maxRows, maxCols);
		this.strategy = strategy;
		this.random = random;

		setBoardWithColor(BoardCell.EMPTY);
	}

	/**
	 * The game is over when the last board row (row with index board.length -1)
	 * is different from empty row.
	 */
	public boolean isGameOver() {
		boolean out = false;
		BoardCell[] lastRow = board[board.length - 1];
		for (int i = 0; i < lastRow.length; i++) {
			if (lastRow[i] == BoardCell.EMPTY) {
				out = false;
			} else {
				out = true;
				break;
			}
		}
		return out;
	}

	public int getScore() {
		return score;
	}

	/**
	 * This method will attempt to insert a row of random BoardCell objects if
	 * the last board row (row with index board.length -1) corresponds to the
	 * empty row; otherwise no operation will take place.
	 */
	public void nextAnimationStep() {
		if (!isGameOver()) {

			moveRowsDown();
			setRowWithColor(0, BoardCell.EMPTY);

			// generates a random first row
			for (int j = 0; j < board[0].length; j++)
				setBoardCell(0, j,
						BoardCell.getNonEmptyRandomBoardCell(random));
		}

	}

	/**
	 * The default processing associated with this method is that for strategy
	 * #1. If you add a new strag tegy, make sure you add a conditional so the
	 * processing described below is associated with strategy #1. <br>
	 * <br>
	 * Strategy #1 Description.<br>
	 * <br>
	 * This method will turn to BoardCell.EMPTY the cell selected and any
	 * adjacent surrounding cells in the vertical, horizontal, and diagonal
	 * directions that have the same color. The clearing of adjacent cells will
	 * continue as long as cells have a color that corresponds to the selected
	 * cell. Notice that the clearing process does not clear every single cell
	 * that surrounds a cell selected (only those found in the vertical,
	 * horizontal or diagonal directions). <br>
	 * IMPORTANT: Clearing a cell adds one point to the game's score.<br>
	 * <br>
	 * 
	 * If after processing cells, any rows in the board are empty,those rows
	 * will collapse, moving non-empty rows upward. For example, if we have the
	 * following board (an * represents an empty cell):<br />
	 * <br />
	 * RRR<br />
	 * GGG<br />
	 * YYY<br />
	 * * * *<br/>
	 * <br />
	 * then processing each cell of the second row will generate the following
	 * board<br />
	 * <br />
	 * RRR<br />
	 * YYY<br />
	 * * * *<br/>
	 * * * *<br/>
	 * <br />
	 * IMPORTANT: If the game has ended no action will take place.
	 * 
	 * 
	 */
	public void processCell(int rowIndex, int colIndex) {
		if (strategy == 1 && isValidIndices(rowIndex, colIndex)
				&& !isGameOver()) {
			BoardCell curr = getBoardCell(rowIndex, colIndex);

			clearCellsHorizontal(rowIndex, colIndex, curr);
			clearCellsVertical(rowIndex, colIndex, curr);
			clearCellsDiagonal(rowIndex, colIndex, curr);

			setBoardCell(rowIndex, colIndex, BoardCell.EMPTY);

			if (isRowEmpty(rowIndex)) {
				// collapsing rows
				moveRowsUp();
			}
		}
	}

	/*
	 * private helper method(s)
	 */
	private void moveRowsDown() {
		// find first empty row, get its rowIdx
		// for each row until that index, swap with its succeeding row

		int emptyRowIdx = findNextEmptyRow(0, true);
		// backwards for loop starting at emptyRowIdx
		for (int i = emptyRowIdx - 1; i >= 0; i--) {
			board[i + 1] = board[i].clone();
			// will not cause ArrayIndexOutOfBounds since !isGameOver() when
			// called
		}

	}

	private void moveRowsUp() {
		int firstEmptyRowIdx = findNextEmptyRow(0, true);
		// ^ will never be row idx 0, will return atleast 1
		int lastEmptyRowIdx = findNextEmptyRow(firstEmptyRowIdx, false);
		// ^ could be the final row

		for (int i = firstEmptyRowIdx + 1; i <= lastEmptyRowIdx; i++) {
			board[i - 1] = board[i].clone();
		}
	}

	private int findNextEmptyRow(int startingRowIdx, boolean isFirst) {
		// we need it to return 0 for moveRowsDown() first step where the first
		// row is 0, however for mvoeRowsUp() we would rather ignore the
		// firstRow
		int out = 0;
		// to start from beginning, startingRowIdx = 0, isFirst = true
		// however for moveCellsUp() we must start at the row we KNOW is Empty
		int i = (isFirst ? startingRowIdx : startingRowIdx + 1);
		for (; i < getMaxRows(); i++) {
			if (isRowEmpty(i)) {
				out = i;
				break;
			} else {
				out++;
			}
		}
		return out;
	}

	private boolean isRowEmpty(int rowIdx) {
		boolean out = false;

		if (isValidIndices(rowIdx, getMaxCols() - 1)) {
			boolean remainedTrue = true;

			for (int i = 0; i < board[rowIdx].length; i++) {
				if (board[rowIdx][i] != BoardCell.EMPTY) {
					remainedTrue = false;
				}

			}
			if (remainedTrue) {
				out = true;
			}
		}

		return out;
	}

	private void clearCellsHorizontal(int rowIdx, int colIdx, BoardCell state) {
		if (isValidIndices(rowIdx, colIdx)) { // base case for recursive calls

			if (isValidIndices(rowIdx, colIdx - 1)) {
				// ensuring the cell has a left neighbor
				BoardCell leftCell = getBoardCell(rowIdx, colIdx - 1);
				// first check left recursively
				if (leftCell == state) {
					setBoardCell(rowIdx, colIdx - 1, BoardCell.EMPTY);
					score++;
					clearCellsHorizontal(rowIdx, colIdx - 1, state);
				}
			}

			// ensuring the cell has a right neighbor
			if (isValidIndices(rowIdx, colIdx + 1)) {
				BoardCell rightCell = getBoardCell(rowIdx, colIdx + 1);
				// next check right recursively if we are not on the edge
				if (rightCell == state) {
					setBoardCell(rowIdx, colIdx + 1, BoardCell.EMPTY);
					score++;
					clearCellsHorizontal(rowIdx, colIdx + 1, state);
				}
			}
		}
	}

	private void clearCellsVertical(int rowIdx, int colIdx, BoardCell state) {
		if (isValidIndices(rowIdx, colIdx)) { // base case for recursive calls

			// ensuring cell has an upper neighbor
			if (isValidIndices(rowIdx - 1, colIdx)) {
				BoardCell topCell = getBoardCell(rowIdx - 1, colIdx);
				// first check top recursively
				if (topCell == state) {
					setBoardCell(rowIdx - 1, colIdx, BoardCell.EMPTY);
					score++;
					clearCellsVertical(rowIdx - 1, colIdx, state);
				}
			}

			// ensuring cell has a lower neighbor
			if (isValidIndices(rowIdx + 1, colIdx)) {
				BoardCell bottomCell = getBoardCell(rowIdx + 1, colIdx);
				// next check lower cell recursively
				if (bottomCell == state) {
					setBoardCell(rowIdx + 1, colIdx, BoardCell.EMPTY);
					score++;
					clearCellsVertical(rowIdx + 1, colIdx, state);
				}
			}
		}
	}

	private void clearCellsDiagonal(int rowIdx, int colIdx, BoardCell state) {
		if (isValidIndices(rowIdx, colIdx)) { // base case for recursive calls

			// ensuring cell has a upper left neighbor
			if (isValidIndices(rowIdx - 1, colIdx - 1)) {
				BoardCell topLeft = getBoardCell(rowIdx - 1, colIdx - 1);
				// next check up and to the left recursively
				if (topLeft == state) {
					setBoardCell(rowIdx - 1, colIdx - 1, BoardCell.EMPTY);
					score++;
					clearCellsDiagonal(rowIdx - 2, colIdx - 2, state);
				}
			}

			// ensuring cell has a lower left neighbor
			if (isValidIndices(rowIdx + 1, colIdx - 1)) {
				BoardCell bottomLeft = getBoardCell(rowIdx + 1, colIdx - 1);
				// next check down and to the left recursively
				if (bottomLeft == state) {
					setBoardCell(rowIdx + 1, colIdx - 1, BoardCell.EMPTY);
					score++;
					clearCellsDiagonal(rowIdx + 2, colIdx - 2, state);
				}
			}

			// ensuring cell has a upper right neighbor
			if (isValidIndices(rowIdx + 1, colIdx - 1)) {
				BoardCell topRight = getBoardCell(rowIdx - 1, colIdx + 1);
				// next check up and to the right recursively
				if (topRight == state) {
					setBoardCell(rowIdx - 1, colIdx + 1, BoardCell.EMPTY);
					score++;
					clearCellsDiagonal(rowIdx - 2, colIdx + 2, state);
				}
			}

			// ensuring cell has a lower right neighbor
			if (isValidIndices(rowIdx + 1, colIdx - 1)) {
				BoardCell bottomRight = getBoardCell(rowIdx + 1, colIdx + 1);
				// next check down and to the right recursively
				if (bottomRight == state) {
					setBoardCell(rowIdx - 1, colIdx + 1, BoardCell.EMPTY);
					score++;
					clearCellsDiagonal(rowIdx + 2, colIdx + 2, state);
				}
			}

		}
	}

}