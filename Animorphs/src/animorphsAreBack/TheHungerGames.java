package animorphsAreBack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheHungerGames implements Runnable {

	private static final int POPULATIONSIZE = 256;//Must be even
	private static final int GAMESIZE = 4;
	private static final int ITERATIONS = 2;
	private static CandidateAlgorithm[] population = new CandidateAlgorithm[POPULATIONSIZE];

	private static final int SWAPODDS = 5;
	private static final int MUTATEODDS = 2;

	public static void main(String args[]) throws IOException {

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
			System.out.print("|");
			if(generation%50 ==0)
				System.out.println();
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
				mutate(nextGen[i]);
				mutate(nextGen[i+1]);
			}
			population = nextGen;
			
		}
		
		//Iterations done
		FileWriter save = new FileWriter("best.txt");
		BufferedWriter print = new BufferedWriter(save);
//		for(int i = 0; i < 10; i++)
//			print.write(population[i].getDNAString() + "\n");
//		
//		print.close();
		
		CandidateAlgorithm enemy = population[0];
		int max = 0;
		for(CandidateAlgorithm c : population){
			if(c.getFitness() > max){
				enemy = c;
				max = c.getFitness();
			}
		}
		print.write(enemy.getDNAString());
		
		//Play against enemy
		enemy.setPlayer(2);
		System.out.println("\n" + enemy.treeToString());
		Scanner in = new Scanner(System.in);
		TicTacToeriginal challenge = new TicTacToeriginal(GAMESIZE);
		System.out.println("Ready to play?\nYou are Player 1.");
		while(challenge.winner() == 0){
			System.out.println(challenge.print());
			System.out.println("Row?");
			int row = in.nextInt() - 1;
			System.out.println("Column?");
			int col = in.nextInt() - 1;
			challenge.move(row, col, 1);
			enemy.executeMove(challenge.getBoard());
			
		}
		

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
		CandidateAlgorithm[] reply = {new CandidateAlgorithm(0,first.getDNA()),new CandidateAlgorithm(0,second.getDNA())};
		Random rand = new Random();
		
		for(int i = 0; i < first.getDNA().size(); i++){
			if(rand.nextInt(100)<=SWAPODDS){
				reply[0].getDNA().set(i,second.getDNA().get(i));
				reply[1].getDNA().set(i,first.getDNA().get(i));
			}
		}
		
//		reply[0] = first;
//		reply[1] = second;
		return reply;
	}
	
	private static void mutate(CandidateAlgorithm alg){
		Random rand = new Random();
		for(int i = 0; i < alg.getDNA().size(); i++){
			if(rand.nextInt(100) <= MUTATEODDS){
				alg.getDNA().flip(i);
			}
		}
	}
	
	
	
	
	
	
	
	

}
