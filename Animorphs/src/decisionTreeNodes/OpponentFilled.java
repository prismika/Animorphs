package decisionTreeNodes;

public class OpponentFilled extends Conditional{
	public OpponentFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		return board[row][col] != 0 && board[row][col] != player;
	}
}
