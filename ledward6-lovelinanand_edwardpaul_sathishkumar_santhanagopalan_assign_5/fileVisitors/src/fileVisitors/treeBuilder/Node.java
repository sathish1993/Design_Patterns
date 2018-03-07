package fileVisitors.treeBuilder;

import fileVisitors.util.MyLogger;

public class Node {
	
	private String name;
	public Node left;
	public Node right;

	public Node(String name, int frequency){
		MyLogger.writeMessage("Node constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.name = name;
		this.left = this.right = null;
	}

	public String getName() {
		return name;
	}	

	public void setName(String newName) {
		name = newName;
	}

}