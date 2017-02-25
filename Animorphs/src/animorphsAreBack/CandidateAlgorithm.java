package animorphsAreBack;

import java.util.BitSet;
import decisionTreeNodes.*;


public class CandidateAlgorithm extends Player{
	private BitSet dna;
	private int dnaLength;
	private final static int SEQUENCELENGTH = 64;
	/**
	 * Initializes with random string of bits
	 * @param length
	 */
	public CandidateAlgorithm(int player){
		super(player);
		this.dna = new BitSet(SEQUENCELENGTH);
		this.dnaLength = this.dna.size();
		randomize();
		constructStrategyTree();
	}
	public CandidateAlgorithm(int player, BitSet dna){
		super(player);
		this.dna = dna;
		this.dnaLength = dna.size();
		constructStrategyTree();
	}
	
	public void randomize(){
		for(int i = 0; i < dnaLength; i++){
			dna.set(i,Util.randBit());
		}
	}
	
	private void constructStrategyTree(){
		//TODO
	}
	
	
	private Node decode(String codon){
		//TODO
		
		
		return null;
	}
	
}
