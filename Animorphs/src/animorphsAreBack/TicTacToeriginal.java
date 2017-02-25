package animorphsAreBack;

public class TicTacToeriginal extends TicTacToe {

	private int[][] board;
	private int size;

	public TicTacToeriginal(int size) {
		board = new int[size][size];
		this.size = size;
	}

	public TicTacToeriginal(int[][] board, int size) {

		this(size);

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
	 * count if there are any series of X's or O's equal to the
	 * 
	 * @return Player number or -1 if there is no winner yet.
	 */
	@Override
	public int winner() {

		int xICounter = 0;
		int oICounter = 0;
		int xJCounter = 0;
		int oJCounter = 0;

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {

				// Adds values if there is a square on the board that has X
				// values
				if (board[i][j] == 1) {
					xICounter = xICounter + i;
					xJCounter = xJCounter + j;
				}

				// Adds values if there is a square on the board that has O
				// values
				if (board[i][j] == 2) {
					oICounter = oICounter + i;
					xJCounter = xJCounter + j;
				}

				// If values add up there is a series of O values.
				if (oICounter == size * 2 || oJCounter == size * 2) {
					return 2;
				}

				// If values add up there is a series of X values.
				if (xICounter == size * 2 || xJCounter == size * 2) {
					return 1;
				}

			}

		}

		return -1; // return zeor if there isn't a match

	}
}
