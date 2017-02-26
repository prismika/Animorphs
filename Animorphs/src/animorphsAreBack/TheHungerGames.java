package animorphsAreBack;

import java.util.Random;

public class TheHungerGames implements Runnable {

	private static final int POPULATIONSIZE = 10;

	public static void main(String args[]) {

		// Create two players

		int gameSize = 3;

		CandidateAlgorithm playerX = new CandidateAlgorithm(1);
		CandidateAlgorithm playerO = new CandidateAlgorithm(2);

		// Thread thd1 = new Thread();

		TicTacToeriginal ticTacTest = new TicTacToeriginal(3);

		Random whoStartsFirst = new Random();

		int startOrder = whoStartsFirst.nextInt(1);

		int weiner = 0; // changes depending on the 
		
		for (int i = 0; i < 2; i++) {
			if (startOrder == 0) {

				while (ticTacTest.winner() == 0) {

					playerX.executeMove(ticTacTest.getBoard());
					playerO.executeMove(ticTacTest.getBoard());

				}

				// This sets the winner of the battle
				weiner = ticTacTest.winner();

			} else {

				while (ticTacTest.winner() == 0) {

					playerO.executeMove(ticTacTest.getBoard());
					playerX.executeMove(ticTacTest.getBoard());

				}

				// Sets the winner of the battle
				weiner = ticTacTest.winner();

			}
			// Nifty math trick to switch the numbers
			startOrder = Math.abs(startOrder - 1);
			
		}

	}

	@Override
	public void run() {

		// TODO

	}

	/**
	 * 
	 * 
	 * @param player
	 */
	private static void picNextGeneration(CandidateAlgorithm player) {
		// TODO array list with random number gen.
	}

	private static void breedPlayers(CandidateAlgorithm first, CandidateAlgorithm second) {
		// TODO
	}

}
