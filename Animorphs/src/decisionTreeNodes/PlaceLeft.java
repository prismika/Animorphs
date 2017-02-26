package decisionTreeNodes;

public class PlaceLeft extends Terminal{

	public PlaceLeft(String codon) {
		super(codon);
	}

	@Override
	public void place(int[][] board, int player) {
		int x = args[0];
		int y = args[1];
		for(int col = 0; col < board.length; col--){
			for(int row = 0; row < board.length; row--){
				if(board[(x+row)%board.length][(y+col)%board.length] == 0){
					board[(x+row)%board.length][(y+col)%board.length] = player;
				}
			}
		}
		
	}

}
