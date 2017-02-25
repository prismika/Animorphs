package animorphsAreBack;

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

		boolean xWins = false;
		boolean oWins = false;

		// Check Rows && colums
		for (int i = 0; i < size; i++) {
			if (getBoard()[i][0] == 1 && getBoard()[i][1] == 1 && getBoard()[i][2] == 1) {
				xWins = true;
			}
			if (getBoard()[i][0] == 2 && getBoard()[i][1] == 2 && getBoard()[i][2] == 2) {
				oWins = true;
			}
			if (getBoard()[0][i] == 1 && getBoard()[1][i] == 1 && getBoard()[2][i] == 1) {
				xWins = true;
			}
			if (getBoard()[0][i] == 2 && getBoard()[1][i] == 2 && getBoard()[2][i] == 2) {
				oWins = true;
			}
		}

		int j = size;
		
		int xCountForwardSlash = 0;
		int oCountForwardSlash = 0;
		int xCountBackSlash = 0;
		int oCountBackSlash = 0;
		
		// Diagonal lines
		for (int i = 0; i < size; i++) {
			
			// Checks the forward diagonal of the matrix for x
			if (getBoard()[i][j - 1] == 1) {
				oCountForwardSlash += 1;
				if(oCountForwardSlash == size)
					return 1;
			}
			
			// Checks the forward diagonal of the matrix for o
			if (getBoard()[i][j - 1] == 2) {
				oCountForwardSlash += 1;
				if(oCountForwardSlash == size);
					return 2;
			}
			
			j--;
			
			// Checks the backward diagonal of the matrix of x
			if(getBoard()[i][i] == 1){
				xCountBackSlash += 1;
				if(xCountBackSlash == size)
					return 1;
			}
			
			// checks the backward diagonal of the matrix for o.
			if(getBoard()[i][i] == 2){
				oCountBackSlash += 1;
				if(oCountBackSlash == size)
					return 2;
			}
			
		}

		return -1; // return '-1'  if there isn't a match

	}

}
