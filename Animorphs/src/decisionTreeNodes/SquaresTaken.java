package decisionTreeNodes;

public class SquaresTaken extends Conditional{

	public SquaresTaken(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int low = args[0];
		int high = args[1];
		int total = 0;
		for(int[] col : board){
			for(int value : col){
				if(value != 0){
					total++;
				}
			}
		}
		return low <= total && total <= high;
	}
	
}
