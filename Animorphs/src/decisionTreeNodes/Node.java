package decisionTreeNodes;

public abstract class Node {
	private Node child[] = {null, null};
	private boolean isRoot;
	public boolean isRoot(){
		return isRoot;
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
	
}
