package animorphsAreBack;

import java.util.ArrayList;
import java.util.Random;

public class TheHungerGames implements Runnable {

	private static final int POPULATIONSIZE = 256;//Must be even
	private static final int GAMESIZE = 3;
	private static final int ITERATIONS = 10;
	private static CandidateAlgorithm[] population = new CandidateAlgorithm[POPULATIONSIZE];

	public static void main(String args[]) {

		// Create initial population
		for(int i = 0; i < POPULATIONSIZE; i++){
			population[i] = new CandidateAlgorithm(0);
		}
		
		
		
		for(int generation = 0; generation < ITERATIONS; generation++){
			for(int i = 0; i < POPULATIONSIZE; i++){
				for(int j = i + 1; j < POPULATIONSIZE; j++){
					if(population[i].isValid() && population[j].isValid()){
						int fit = 0;
						population[i].setPlayer(1);
						population[j].setPlayer(2);
						fit += pit(population[i], population[j]);
						fit -= pit(population[j], population[i]);
						population[i].addToFitness(Math.max(0, fit));
						population[j].addToFitness(Math.max(0, -1*fit));
					}else{
						if(population[i].isValid()){
							population[i].addToFitness(1);
						}
					}
				}
			}
			//Generation testing complete
//			for(int i = 0; i < POPULATIONSIZE; i++){
//				System.out.println(population[i].getFitness());
//			}
			CandidateAlgorithm[] nextGen = new CandidateAlgorithm[POPULATIONSIZE];
			ArrayList<CandidateAlgorithm> wheel = new ArrayList<>();
			for(int i = 0; i < POPULATIONSIZE; i++){
				for(int j = 0; j < population[i].getFitness(); j++){
					wheel.add(population[i]);
				}
			}
			Random selection = new Random();
			for(int i = 0; i < nextGen.length; i += 2){
				int choice1 = selection.nextInt(wheel.size());
				int choice2 = selection.nextInt(wheel.size());
				CandidateAlgorithm[] twins = breedPlayers(wheel.get(choice1), wheel.get(choice2));
				nextGen[i] = twins[0];
				nextGen[i+1] = twins[1];
			}
			population = nextGen;
			
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

	private static CandidateAlgorithm[] breedPlayers(CandidateAlgorithm first, CandidateAlgorithm second) {
		CandidateAlgorithm[] reply = new CandidateAlgorithm[2];
		Random rand = new Random();
		
//		reply[0] = first;
//		reply[1] = second;
		return reply;
	}
	
	
	
	
	
	
	
	

}
