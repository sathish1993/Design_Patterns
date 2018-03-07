package wordTree.treeBuilder;

import wordTree.util.MyLogger;
public class Node {
	
	private String name;
	private int count;
	public Node left;
	public Node right;

	public Node(String name, int frequency){
		MyLogger.writeMessage("Node constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.name = name;
		this.count = frequency;
		this.left = this.right = null;
	}

	public String getName() {
		return name;
	}

	public int getFrequency() {
		return count;
	}

	public void setFrequency(int newCount) {
		count = newCount;
	}	

}