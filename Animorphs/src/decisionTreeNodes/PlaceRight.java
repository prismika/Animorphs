package decisionTreeNodes;

public class PlaceRight extends Terminal{

	@Override
	public void place(int x, int y, int[][] board, int player) {
		for(int col = 0; col < board.length; col++){
			for(int row = 0; row < board.length; row++){
				if(board[(x+row)%board.length][(y+col)%board.length] == 0){
					board[(x+row)%board.length][(y+col)%board.length] = player;
				}
			}
		}
		
	}
	
}
