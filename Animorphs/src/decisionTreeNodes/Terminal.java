package decisionTreeNodes;

public abstract class Terminal extends Node{
	public abstract void place(int x, int y, int[][] board, int player);
}
