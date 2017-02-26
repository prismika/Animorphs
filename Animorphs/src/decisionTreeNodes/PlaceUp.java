package decisionTreeNodes;

public class PlaceUp extends Terminal{

	public PlaceUp(String codon) {
		super(codon);
	}

	@Override
	public void place(int[][] board, int player) {
		int x = Math.floorMod(args[0],board.length);
		int y = Math.floorMod(args[1],board.length);
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board.length; col++){
				if(board[Math.floorMod(x-row,board.length)][Math.floorMod(y-col,board.length)] == 0){
					board[Math.floorMod(x-row,board.length)][Math.floorMod(y-col,board.length)] = player;
					return;
				}
			}
		}
		
	}
}
