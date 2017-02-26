package animorphsAreBack;

import java.util.Arrays;

public class RandomTester {
	public static void main(String args[]) {

		int gameSize = 3;

		int testBoard[][] = { { 2, 1, 2 }, 
							  { 0, 1, 2 }, 
							  { 2, 2, 1 } };

		TicTacToeriginal ttto = new TicTacToeriginal(testBoard, gameSize);

		System.out.println(ttto.toString());

		// Can use for a tester class to test the method winner().

		if (ttto.winner() == 1) {
			System.out.println("Winner is X");
		}

		if (ttto.winner() == 2) {
			System.out.println("Winner is O");
		}

		if (ttto.winner() == -1) {
			System.out.println("No winner!");
		}

		if (ttto.winner() == 0) {
			System.out.println("Still able to move");
		}
	}
}
