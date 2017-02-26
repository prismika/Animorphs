package animorphsAreBack;

public class TheHungerGames implements Runnable {

	private static final int POPULATIONSIZE = 32;
	private static final int GAMESIZE = 3;
	private static CandidateAlgorithm[] population = new CandidateAlgorithm[POPULATIONSIZE];

	public static void main(String args[]) {

		// Create players
		for(int i = 0; i < POPULATIONSIZE; i++){
			population[i] = new CandidateAlgorithm(0);
		}
		
		for(int i = 0; i < POPULATIONSIZE; i++){
			for(int j = i + 1; j < POPULATIONSIZE; j++){
				int fit = 0;
				population[i].setPlayer(1);
				population[j].setPlayer(2);
				fit += pit(population[i], population[j]);
				fit -= pit(population[j], population[i]);
				population[i].addToFitness(Math.max(0, fit));
				population[j].addToFitness(Math.max(0, -1*fit));
			}
		}
		
//		CandidateAlgorithm playerX;
//		CandidateAlgorithm playerO;
//		// Thread thd1 = new Thread();
//
//		TicTacToeriginal ticTacTest = new TicTacToeriginal(GAMESIZE);
//		
//		int weiner = 0;
//		while (ticTacTest.winner() == 0) {
//
//			playerX.executeMove(ticTacTest.getBoard());
//			playerO.executeMove(ticTacTest.getBoard());
//			weiner = ticTacTest.winner();
//
//		}
		

	}
	
	public static int pit(CandidateAlgorithm playerX,CandidateAlgorithm playerY){
		TicTacToeriginal tictactest = new TicTacToeriginal(GAMESIZE);
		int turn = 1;
		while(tictactest.winner() == 0){
			if(turn == 1){
				playerX.executeMove(tictactest.getBoard());
				turn = 2;
			}else{
				playerY.executeMove(tictactest.getBoard());
				turn = 1;
			}
		}
		switch(tictactest.winner()){
		case 1: return 1;
		case 2: return -1;
		case -1: return 0;
		default: throw new IllegalStateException("Winner number was: " + tictactest.winner());
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

	private CandidateAlgorithm[] breedPlayers(CandidateAlgorithm first, CandidateAlgorithm second) {
		// TODO
		return null;
	}

}
