package decisionTreeNodes;

public class OpponentFilled extends Conditional{
	public OpponentFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int row = args[0];
		int col = args[1];
		return board[row][col] != 0 && board[row][col] != player;
	}
}
