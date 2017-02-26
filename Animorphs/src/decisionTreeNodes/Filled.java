package decisionTreeNodes;

public class Filled extends Conditional{

	public Filled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int row = args[0];
		int col = args[1];
		return board[row][col] > 0;
	}
	
	
}
