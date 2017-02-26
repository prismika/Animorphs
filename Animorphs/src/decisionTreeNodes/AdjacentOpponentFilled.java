package decisionTreeNodes;

public class AdjacentOpponentFilled  extends Conditional{
	public AdjacentOpponentFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int row = Math.floorMod(args[0],board.length);
		int col = Math.floorMod(args[1],board.length);
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(board[Math.floorMod((row+i-1),board.length)][Math.floorMod((col+j-1),board.length)] != 0
						&& board[Math.floorMod((row+i-1),board.length)][Math.floorMod((col+j-1),board.length)] != player && (i!=2 || j!=2)){
					return true;
				}
			}
		}
		return false;
	}
}
