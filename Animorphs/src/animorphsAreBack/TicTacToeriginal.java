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
		//TODO
		//Check if someone has won. If someone has won, return their player number (1 or 2).
		//If no one has won, return 0.
		
		
		
		return -1;
	}
}
