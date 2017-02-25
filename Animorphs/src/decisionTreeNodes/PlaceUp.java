package decisionTreeNodes;

public class PlaceUp extends Terminal{

	public PlaceUp(String codon) {
		super(codon);
	}

	@Override
	public void place(int x, int y, int[][] board, int player) {
		for(int row = 0; row < board.length; row--){
			for(int col = 0; col < board.length; col--){
				if(board[(x+row)%board.length][(y+col)%board.length] == 0){
					board[(x+row)%board.length][(y+col)%board.length] = player;
				}
			}
		}
		
	}
}
