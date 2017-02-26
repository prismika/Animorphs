package animorphsAreBack;

public abstract class Player {
	private int playerNumber;
	Player(int playerNumber){
		this.playerNumber = playerNumber;
	}
	public abstract void executeMove(int[][] board);
}
