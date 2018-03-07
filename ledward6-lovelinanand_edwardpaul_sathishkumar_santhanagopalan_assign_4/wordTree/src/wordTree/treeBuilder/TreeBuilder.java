package wordTree.treeBuilder;

import wordTree.store.Results;
import wordTree.util.MyLogger;
public class TreeBuilder {

	private Node root = null;

	public TreeBuilder() {
		MyLogger.writeMessage("TreeBuilder constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public Node getRootNode(){
		return root;
	}
	//Method to clone a node and insert that node in a tree
	public synchronized void insertNode(Node node){
		root = insertNodeHelper(root, node);
	}

	//Helper method to insert into tree
	private synchronized Node insertNodeHelper(Node root, Node node){
		if(root == null)
			root = node;
		else if(node.getName().compareTo(root.getName()) > 0)
			root.left = insertNodeHelper(root.left, node);
		else
			root.right = insertNodeHelper(root.right, node);
		return root;
	}

	public synchronized Node searchNode(String searchString) {
		return searchNodeHelper(root, searchString);
	}

	//Method to search for a node in a tree
	public synchronized Node searchNodeHelper(Node root, String searchString){
		if(root == null || root.getName().compareTo(searchString) == 0)
			return root;
		if(root.getName().compareTo(searchString) < 0)
			return searchNodeHelper(root.left, searchString);
		return searchNodeHelper(root.right, searchString);
	}
}