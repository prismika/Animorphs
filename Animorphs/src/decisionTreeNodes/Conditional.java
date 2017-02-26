package decisionTreeNodes;

public abstract class Conditional extends Node{
	public Conditional(String codon){
		super(codon);
	}
	
	public abstract boolean decide(int[][] board, int player);
}
