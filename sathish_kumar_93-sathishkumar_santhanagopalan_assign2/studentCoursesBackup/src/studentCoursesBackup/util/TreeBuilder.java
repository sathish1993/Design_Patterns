package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder implements Cloneable{

	private Node root, clone1Root, clone2Root;
	private Observable observable = null;

	public TreeBuilder(){
		root = null;
		clone1Root = null;
		clone2Root = null;
		observable = new Observable();
	}

	//Method to return the original tree's root node
	public Node getOriginalRoot(){
		return root;
	}

	//Method to return the cloned tree's root node
	public Node getClone1Root(){
		return clone1Root;
	}

	//Method to return the cloned tree's root node
	public Node getClone2Root(){
		return clone2Root;
	}

	//Method to clone a node and insert that node in a tree
	public void insertNode(Node node){
		Node clone1 = null, clone2 = null;
		try{
			clone1 = (Node)observable.deepClone(node);
			clone2 = (Node)observable.deepClone(node);
			if(clone1 == null || clone2 == null)
				throw new CloneNotSupportedException();
			observable.registerObserver(node, clone1);
			observable.registerObserver(node, clone2);
		}catch(CloneNotSupportedException e){
			System.err.println("Cloning not allowed");
			e.printStackTrace();
			System.exit(0);
		}
		root = insertNodeHelper(root, node);
		clone1Root = insertNodeHelper(clone1Root, clone1);
		clone2Root = insertNodeHelper(clone2Root, clone2);		
	}

	//Helper method to insert into tree
	private Node insertNodeHelper(Node rootX, Node node){
		if(rootX == null)
			rootX = node;
		else if(node.getBNumber() < rootX.getBNumber())
			rootX.left = insertNodeHelper(rootX.left, node);
		else
			rootX.right = insertNodeHelper(rootX.right, node);
		return rootX;
	}

	//Method to search for a node in a tree
	public Node searchNode(Node rootS, int bNumber){
		if(rootS == null || rootS.getBNumber() == bNumber)
			return rootS;
		if(rootS.getBNumber() > bNumber)
			return searchNode(rootS.left, bNumber);
		return searchNode(rootS.right, bNumber);
	}

}