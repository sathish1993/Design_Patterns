package fileVisitors.treeBuilder;

import fileVisitors.util.MyLogger;

public class TreeBuilder {

	private Node root = null;

	public TreeBuilder() {
		MyLogger.writeMessage("TreeBuilder constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public Node getRootNode(){
		return root;
	}

	//Method to insert a node in a tree, takes Node as input
	public void insertNode(Node node){
		root = insertNodeHelper(root, node);
	}

	//Helper method to insert into tree takes 2 Nodes as input and returns Node
	private Node insertNodeHelper(Node root, Node node){
		if(root == null)
			root = node;
		else if(node.getName().compareTo(root.getName()) <= 0)
			root.left = insertNodeHelper(root.left, node);
		else
			root.right = insertNodeHelper(root.right, node);
		return root;
	}

	//Method to search a Node, takes a String as input and Node as output
	public Node searchNode(String searchString) {
		return searchNodeHelper(root, searchString);
	}

	//Helper Method to search for a node in a tree, takes String and Node as input and retuns the expected Node
	private Node searchNodeHelper(Node root, String searchString){
		if(root == null || root.getName().compareTo(searchString) == 0)
			return root;
		if(root.getName().compareTo(searchString) < 0)
			return searchNodeHelper(root.left, searchString);
		return searchNodeHelper(root.right, searchString);
	}

	public void displayTree(Node node) {
		if(node != null) {
			displayTree(node.left);
			System.out.println(node.getName());
			displayTree(node.right);
		}
	}
}