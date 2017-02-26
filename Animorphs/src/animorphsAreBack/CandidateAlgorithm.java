package animorphsAreBack;

import java.util.BitSet;
import java.util.LinkedList;

import decisionTreeNodes.*;

public class CandidateAlgorithm extends Player {
	private BitSet dna;
	private int dnaLength;
	private Node root;
	private boolean treeIsValid = true;
	private int fitness = 0;
	private final static int CODONLENGTH = 14;
	private final static int CODONNUMBER = 64;
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

	private void randomize() {
		for (int i = 0; i < dnaLength; i++) {
			dna.set(i, Util.randBit());
		}
	}
	
	public void addToFitness(int fitnessPlus){
		fitness += fitnessPlus;
	}
	public int getFitness(){
		return fitness;
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
		try{
			root = decode(rootCodon.substring(0, 4), false);
			root.setRoot();
			root.setArg(0,Integer.parseInt(rootCodon.substring(4, 8), 2));
			root.setArg(1,Integer.parseInt(rootCodon.substring(8, 12), 2));
			nodesWithChildSlots.add(root);
		}catch(InvalidCodingException e){
			this.treeIsValid = false;
			return;
		}
		
		//Construct all other nodes
		int codonNumber = 1;
		while((codonNumber+1)*CODONLENGTH < dna.size()){
			String thisCodon = "";
			for(int i = 0; i < CODONLENGTH; i++){
				if(dna.get(i+CODONLENGTH*codonNumber) == true)
					thisCodon += "1";
				else
					thisCodon += "0";
			}
			
			Node branch;
			boolean terminal = thisCodon.substring(12, 14).equals("11");
			try{
				branch = decode(thisCodon, terminal);
				branch.setArg(0,Integer.parseInt(thisCodon.substring(4, 8), 2));
				branch.setArg(1,Integer.parseInt(thisCodon.substring(8, 12), 2));
				Node newParent = nodesWithChildSlots.getFirst();
				newParent.setChild(branch);
				if(!newParent.hasChildSlots())
					nodesWithChildSlots.removeFirst();
				if(branch.hasChildSlots())
					nodesWithChildSlots.add(branch);
			}catch(InvalidCodingException e){
			}
			
			
			codonNumber++;
			
			//TODO set done to true when done
		}
		terminate(root);
	}
	
	private void terminate(Node node){
		if(node.getChild(0).getChildNumber() < 2){
			node.setChild(0, decode(node.getChild(0).getCodon(), true));
			node.getChild(0).setArg(0,Integer.parseInt(node.getChild(0).getCodon().substring(4, 8), 2));
			node.getChild(0).setArg(1,Integer.parseInt(node.getChild(0).getCodon().substring(8, 12), 2));
			
			node.getChild(0).clearChildren();
		}else{
			terminate(node.getChild(0));
		}
		
		if(node.getChild(1).getChildNumber() < 2){
			node.setChild(1, decode(node.getChild(1).getCodon(), true));
			node.getChild(1).setArg(1,Integer.parseInt(node.getChild(1).getCodon().substring(4, 8), 2));
			node.getChild(1).setArg(1,Integer.parseInt(node.getChild(1).getCodon().substring(8, 12), 2));
			
			node.getChild(1).clearChildren();
		}else{
			terminate(node.getChild(1));
		}
	}

	private Node decode(String codon, boolean terminal) throws InvalidCodingException{
		String subCodon = codon.substring(0,4);
		if(!terminal){
			switch(subCodon){
			//Conditionals
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
			case "1111":
				throw new InvalidCodingException();
			
			default: throw new IllegalArgumentException("Impossible conditional codon:" + codon);
			}
		}else{
			//Terminals
			switch(subCodon){
			
			case "0000":
			case "0100":
			case "1000": 
				return new PlaceUp(codon);
			case "0010":
			case "0110": 
			case "1010":
				return new PlaceDown(codon);
			case "0001":
			case "0101": 
			case "1001":
				return new PlaceLeft(codon);
			case "0011":
			case "0111": 
			case "1011":
				return new PlaceRight(codon);
			
			case "1100":
			case "1101":
			case "1110":
			case "1111": 
				throw new InvalidCodingException();
			
			default: throw new IllegalArgumentException("Impossible terminal codon: " + codon);
			}
		
		}
	}
	
	public boolean isValid(){
		return treeIsValid;
	}

	@Override
	public void executeMove(int[][] board) {
		// TODO Auto-generated method stub
		//player is superclass variable
		
	}
	
	public String treeToString(){
		if(!this.treeIsValid){
			return "Tree Invalid Strategy";
		}
		return subtreeToString(root,0);
	}
	private String subtreeToString(Node node, int level){
		
		if(node.getChildNumber() == 0){
			return level + node.getClass().getSimpleName()+"|||";
		}
		if(node.getChildNumber() == 2){
			return level + node.getClass().getSimpleName() + " " + subtreeToString(node.getChild(0),level+1) + " " + subtreeToString(node.getChild(1), level+1);
		}
		return "Children: " + node.getChildNumber();
	}

}
