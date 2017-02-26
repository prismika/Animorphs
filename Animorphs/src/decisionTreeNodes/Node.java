package decisionTreeNodes;

public abstract class Node {
	private Node child[] = {null, null};
	private boolean isRoot = false;
	private int[] args = {0,0};
	private String codon;
	
	public Node(String codon){
		this.codon = codon;
	}
	
	public String getCodon(){
		return codon;
	}
	
	public void setRoot(){
		isRoot = true;
	}
	
	public boolean isRoot(){
		return isRoot;
	}
	
	public void setArg(int argNum, int value){
		args[argNum] = value;
	}
	
	/**
	 * Returns true if both child slots weren't full
	 * @param newChild
	 * @return
	 */
	public boolean setChild(Node newChild){
		if(child[0] == null){
			child[0] = newChild;
			return true;
		}
		if(child[1] == null){
			child[1] = newChild;
			return true;
		}
		return false;
	}
	
	public Node getChild(int childNumber){
		return child[childNumber];
	}
	
	public boolean hasChildSlots(){
		return child[0] != null || child[1] != null;
	}
	
}
