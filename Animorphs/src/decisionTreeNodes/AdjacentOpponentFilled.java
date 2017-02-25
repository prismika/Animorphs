package decisionTreeNodes;

public class AdjacentOpponentFilled  extends Conditional{
	@Override
	public boolean decide(int row, int col, int[][] board, int player) {
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(board[(row+i-1)%board.length][(col+j-1)%board.length] != 0
						&& board[(row+i-1)%board.length][(col+j-1)%board.length] != player && (i!=2 || j!=2)){
					return true;
				}
			}
		}
		return false;
	}
}
