package animorphsAreBack;

public abstract class TicTacToe {
	public abstract int[][] getBoard();
	public abstract void move(int row, int col, int player);
	public abstract int winner();
}
