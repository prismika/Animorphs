package animorphsAreBack;

import java.util.Arrays;

public class RandomTester {
	public static void main(String args[]) {

		int gameSize = 3;

		int testBoard[][] = { { 2, 2, 1 }, 
							  { 0, 2, 1 }, 
							  { 1, 2, 0 } };
		
		for(int i = 0; i < testBoard.length; i++){
			System.out.println(Arrays.toString(testBoard[i]));
		}
		
		System.out.println("");

		TicTacToeriginal ttto = new TicTacToeriginal(testBoard, gameSize);

		if (ttto.winner() == 1) {
			System.out.println("Winner is X");
		}

		if (ttto.winner() == 2) {
			System.out.println("Winner is O");
		}
		
		if (ttto.winner() == -1) {
			System.out.println("No winner!");
		}

	}
}
