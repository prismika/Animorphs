package decisionTreeNodes;

public class OpponentFilled extends Conditional{
	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		return board[row][col] != 0 && board[row][col] != player;
	}
}
