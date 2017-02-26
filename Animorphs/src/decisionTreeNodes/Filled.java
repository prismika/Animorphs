package decisionTreeNodes;

public class Filled extends Conditional{

	public Filled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		return board[row][col] > 0;
	}
	
	
}
