package decisionTreeNodes;

public class MyFilled extends Conditional{
	public MyFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		return board[row][col] == player;
	}
}
