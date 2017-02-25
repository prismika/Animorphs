package decisionTreeNodes;

public abstract class Conditional extends Node{
	public Conditional(String codon){
		super(codon);
	}
	
	public abstract boolean decide(int x,int y, int[][] board, int player);
}
