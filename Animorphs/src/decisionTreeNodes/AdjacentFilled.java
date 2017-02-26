package decisionTreeNodes;

public class AdjacentFilled extends Conditional{
	public AdjacentFilled(String codon) {
		super(codon);
	}

	@Override
	public boolean decide(int[][] board, int player) {
		int row = args[0];
		int col = args[1];
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(board[(row+i-1)%board.length][(col+j-1)%board.length] != 0 && (i!=2 || j!=2)){
					return true;
				}
			}
		}
		return false;
	}
}

