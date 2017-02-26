package animorphsAreBack;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeriginal extends TicTacToe {

	private int[][] board;

	private int size;

	public TicTacToeriginal(int size) {
		board = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = 0;
			}
		}

		this.size = size;
	}

	public TicTacToeriginal(int[][] board) {

		this(board.length);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}

	}

	public void move(int row, int col, int player) {
		if (board[row][col] == 0) {
			board[row][col] = player;
		}
	}

	@Override
	public int[][] getBoard() {
		return board;
	}

	/**
	 * Tests if there is a winner. Winner will traverse through the board and
	 * count if there are any series of X's or O's equal to the. This class is
	 * not set up for more than three variable games.
	 * 
	 * @return Player number or -1 if there is no winner yet.
	 */
	@Override
	public int winner() {

		// if the board is a draw then the return is -1
		int playerNumber = -1;		
		
		// Checking rows for a matching set.
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (getBoard()[i][j] == getBoard()[i][j + 1]) {
					playerNumber = getBoard()[i][j];
				} else {
					playerNumber = -1;
					break; // added to reduce an operation on larger boards.
				}
			}
			// ensures that if a row is matched that the last isn't checked.
			if (playerNumber != -1) {
				break;
			}
		}

		// Checking columns for a matching set if the row check failed.
		if (playerNumber == -1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - 1; j++) {
					if (getBoard()[j][i] == getBoard()[j + 1][i]) {
						playerNumber = getBoard()[j][i];
					} else {
						playerNumber = -1;
						break; // added to reduce operations on larger boards.
					}
				}
				// ensures that if a column is matched that the last isn't
				// checked.
				if (playerNumber != -1) {
					break;
				}
			}
		}

		// Checking forward Slash of cross section
		if (playerNumber == -1) {
			for (int i = 0, j = size - 1; i < size - 1; i++, j--) {
				if (getBoard()[i][j] == getBoard()[i + 1][j - 1]) {
					playerNumber = getBoard()[i][j];
				} else {
					playerNumber = -1;
					break; // Saves steps to jump out of for-loop.
				}
			}
		}

		// Checks the back-slash cross for matching pairs.
		if (playerNumber == -1) {
			for (int i = 0, j = 0; i < size - 1; i++, j++) {
				if (getBoard()[i][j] == getBoard()[i + 1][j + 1]) {
					playerNumber = getBoard()[i][j];
				} else {
					playerNumber = -1;
					break; // Saves time.
				}
			}
		}
		
		if(playerNumber == -1){
			
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(getBoard()[i][j] == 0){
						playerNumber = 0;
					}
				}
			}
		}

		return playerNumber; // return '-1' if there isn't a match

	}

	/**
	 * From String method takes a string of values and converts them into a
	 * board.
	 */
	public TicTacToeriginal fromStringToBoard(String str) {

		if (str == null)
			return null;

		String tempString = "";

		Scanner scn = new Scanner(str);

		while (scn.hasNextInt()) {
			tempString = tempString + scn.nextInt();
		}

		scn.close();
		return null;

	}

	/**
	 * Override value of toString converts the given array
	 * 
	 */
	@Override
	public String toString() {

		if (this.getClass() != TicTacToeriginal.class)
			return "null";

		String temp = new String();

		for (int i = 0; i < size; i++) {
			temp = temp + Arrays.toString(getBoard()[i]) + "\n";
		}

		return temp;
	}

	/**
	 * Compares two different boards and checks their validity.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (obj == null || this.getClass() != obj.getClass())
			return false;

		TicTacToeriginal temp = (TicTacToeriginal) obj;

		if (this.size != temp.size || this == null)
			return false;

		boolean testValue = true;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.getBoard()[i][j] != temp.getBoard()[i][j])
					testValue = false;
			}
		}

		return testValue;
	}
}
