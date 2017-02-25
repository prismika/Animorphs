package animorphsAreBack;

import java.util.BitSet;
import decisionTreeNodes.*;

public class CandidateAlgorithm extends Player {
	private BitSet dna;
	private int dnaLength;
	private final static int SEQUENCELENGTH = 64;

	/**
	 * Initializes with random string of bits
	 * 
	 * @param length
	 */
	public CandidateAlgorithm(int player) {
		super(player);
		this.dna = new BitSet(SEQUENCELENGTH);
		this.dnaLength = this.dna.size();
		randomize();
		constructStrategyTree();
	}

	public CandidateAlgorithm(int player, BitSet dna) {
		super(player);
		this.dna = dna;
		this.dnaLength = dna.size();
		constructStrategyTree();
	}

	public void randomize() {
		for (int i = 0; i < dnaLength; i++) {
			dna.set(i, Util.randBit());
		}
	}

	private void constructStrategyTree() {
		//TODO
	}

	private Node decode(String codon, boolean terminal) throws InvalidCodingException{
		if(!terminal){
			switch(codon){
			case "0000": 
			case "0010": return new Filled();
			case "0001": return new MyFilled();
			case "0011": return new OpponentFilled();

			case "0100": 
			case "0110": return new AdjacentFilled();
			case "0101": return new AdjacentMyFilled();
			case "0111": return new AdjacentOpponentFilled();
			
			case "1000":
			case "1001":
			case "1010":
			case "1011": return new SquaresTaken();
			
			case "1100":
			case "1101":
			case "1110":
			case "1111": throw new InvalidCodingException();
			
			default: throw new IllegalArgumentException("Impossible conditional codon:" + codon);
			}
		}else{
			switch(codon){
			case "0000":
			case "0100": return new PlaceUp();
			case "0010":
			case "0110": return new PlaceDown();
			case "0001":
			case "0101": return new PlaceLeft();
			case "0011":
			case "0111": return new PlaceRight();
			
			case "1000":
			case "1001":
			case "1010":
			case "1011":
			case "1100":
			case "1101":
			case "1110":
			case "1111": throw new InvalidCodingException();
			
			default: throw new IllegalArgumentException("Impossible terminal codon: " + codon);
			}
		
		}
	}

}
