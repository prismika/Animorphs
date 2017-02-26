package decisionTreeNodes;

public abstract class Terminal extends Node{
	
	public Terminal(String codon){
		super(codon);
	}
	public abstract void place(int x, int y, int[][] board, int player);
	
	@Override
	public boolean setChild(Node newChild){
		return false;
	}
	public Node getChild(int childNumber){
		return null;
	}
	public boolean hasChildSlots(){
		return false;
	}
}
