package decisionTreeNodes;

public class Filled extends Conditional{

	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		return board[row][col] > 0;
	}
	
	
}
