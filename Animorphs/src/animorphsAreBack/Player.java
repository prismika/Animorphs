package animorphsAreBack;

public abstract class Player {
	protected int playerNumber;
	Player(int playerNumber){
		this.playerNumber = playerNumber;
	}
	public abstract void executeMove(int[][] board);
}
