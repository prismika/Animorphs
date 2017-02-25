package animorphsAreBack;

import java.util.Random;

public class RandomTester {
	public static void main(String args[]) {

		int gameSize = 3;

		TicTacToeriginal ttto = new TicTacToeriginal(gameSize);

		int testBoard[][] = { { 0, 1, 1 }, { 0, 1, 0 }, { 1, 0, 0 } };

		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				ttto.move(i, j, testBoard[i][j]);
			}
		}

		if (ttto.winner() == 1) {
			System.out.println("Winner is X");
		}

		if (ttto.winner() == 2) {
			System.out.println("Winner is O");
		}

	}
}
