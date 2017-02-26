package animorphsAreBack;

import java.util.Arrays;

public class RandomTester {
	public static void main(String args[]) {

		int gameSize = 3;

		int testBoard[][] = { { 2, 1, 2 }, { 0, 1, 2 }, { 2, 2, 1 } };

		TicTacToeriginal ttto = new TicTacToeriginal(testBoard, gameSize);

		System.out.println(ttto.toString());

		int[][] testArray = ttto.fromStringToBoard(ttto.toString());

		String temp = "";

		// for (int i = 0; i < gameSize; i++) {
		// temp = temp + Arrays.toString(testArray[i]) + "\n";
		// }

		for (int i = 0; i < gameSize; i++) {
			System.out.println(Arrays.toString(testArray[i]));
		}

	}
}
