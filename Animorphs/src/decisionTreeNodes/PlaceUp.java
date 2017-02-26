package decisionTreeNodes;

public class PlaceUp extends Terminal{

	public PlaceUp(String codon) {
		super(codon);
	}

	@Override
	public void place(int[][] board, int player) {
		int x = args[0];
		int y = args[1];
		for(int row = 0; row < board.length; row--){
			for(int col = 0; col < board.length; col--){
				if(board[(x+row)%board.length][(y+col)%board.length] == 0){
					board[(x+row)%board.length][(y+col)%board.length] = player;
				}
			}
		}
		
	}
}
