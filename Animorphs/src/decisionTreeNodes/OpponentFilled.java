package decisionTreeNodes;

public class OpponentFilled extends Conditional{
	public OpponentFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int row = args[0]%board.length;
		int col = args[1]%board.length;
		return board[row][col] != 0 && board[row][col] != player;
	}
}
