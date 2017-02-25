package animorphsAreBack;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

import decisionTreeNodes.*;

public class CandidateAlgorithm extends Player {
	private BitSet dna;
	private int dnaLength;
	private final static int CODONLENGTH = 14;
	private final static int CODONNUMBER = 32;
	private final static int SEQUENCELENGTH = CODONLENGTH * CODONNUMBER;

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

	private void constructStrategyTree() {//TODO Make sure to check that every dna string has at least CODONLENGTH elements
		LinkedList<Node> nodesWithChildSlots = new LinkedList<>();
		//Construct root node
		String rootCodon = "";
		for(int i = 0; i < CODONLENGTH; i++){
			if(dna.get(i) == true)
				rootCodon += "1";
			else
				rootCodon += "0";
		}
		Node root = decode(rootCodon.substring(0, 4), false);
		root.setRoot();
		root.setArg(0,Integer.parseInt(rootCodon.substring(4, 8), 2));
		root.setArg(1,Integer.parseInt(rootCodon.substring(8, 12), 2));
		nodesWithChildSlots.add(root);
		
		//Construct all other nodes
		boolean done = false;
		int codonNumber = 1;
		while(!done){
			String thisCodon = "";
			for(int i = 0; i < CODONLENGTH; i++){
				if(dna.get(i+CODONLENGTH*codonNumber) == true)
					thisCodon += "1";
				else
					thisCodon += "0";
			}
			
			Node branch;
			boolean invalid = false;
			boolean terminal = thisCodon.substring(12, 14) == "11";
			try{
				branch = decode(thisCodon.substring(0, 4), terminal);
				branch.setArg(0,Integer.parseInt(thisCodon.substring(4, 8), 2));
				branch.setArg(1,Integer.parseInt(thisCodon.substring(8, 12), 2));
			}catch(InvalidCodingException e){
				invalid = true;
			}
			Node newParent = nodesWithChildSlots.getFirst();
			newParent.setChild(branch);
				if(!newParent.hasChildSlots()){
					nodesWithChildSlots.removeFirst();
				}
			nodesWithChildSlots.add(branch);
			
			codonNumber++;
			//TODO check if node must be terminal
			//TODO set done to true when done
		}
		
	}

	private Node decode(String codon, boolean terminal) throws InvalidCodingException{
		if(!terminal){
			switch(codon){
			case "0000": 
			case "0010": return new Filled(codon);
			case "0001": return new MyFilled(codon);
			case "0011": return new OpponentFilled(codon);

			case "0100": 
			case "0110": return new AdjacentFilled(codon);
			case "0101": return new AdjacentMyFilled(codon);
			case "0111": return new AdjacentOpponentFilled(codon);
			
			case "1000":
			case "1001":
			case "1010":
			case "1011": return new SquaresTaken(codon);
			
			case "1100":
			case "1101":
			case "1110":
			case "1111": throw new InvalidCodingException();
			
			default: throw new IllegalArgumentException("Impossible conditional codon:" + codon);
			}
		}else{
			switch(codon){
			case "0000":
			case "0100": return new PlaceUp(codon);
			case "0010":
			case "0110": return new PlaceDown(codon);
			case "0001":
			case "0101": return new PlaceLeft(codon);
			case "0011":
			case "0111": return new PlaceRight(codon);
			
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
