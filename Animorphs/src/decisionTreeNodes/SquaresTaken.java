package decisionTreeNodes;

public class SquaresTaken extends Conditional{

	@Override
	public boolean decide(int low, int high, int[][] board, int player) {
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
