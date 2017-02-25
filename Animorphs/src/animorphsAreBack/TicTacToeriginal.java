package animorphsAreBack;

public class TicTacToeriginal extends TicTacToe{
	
	private int[][] board;
	private int size;
	
	public TicTacToeriginal(int size){
		board = new int[size][size];
		this.size = size;
	}
	
	public TicTacToeriginal(int[][] board, int size){
		
		this(size);
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				this.board[i][j] = board[i][j];
			}
		}
		
	}
	
	
	public void move(int row, int col, int player){
		if(board[row][col] == 0){
			board[row][col] = player;
		}
	}
	@Override
	public int[][] getBoard(){
		return board;
	}
	
	@Override
	public int winner() {
		
		int xICounter = 0;
		int oICounter = 0;
		int xJCounter = 0;
		int oJCounter = 0;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				
				if(board[i][j] == 1){
					xICounter = xICounter + i;
					xJCounter = xJCounter + j;
				}
				if(board[i][j] == 2){
					oICounter = oICounter + i;
					xJCounter = xJCounter + j;
				}
				
			}
		}
		
		return -1;
	}
}
