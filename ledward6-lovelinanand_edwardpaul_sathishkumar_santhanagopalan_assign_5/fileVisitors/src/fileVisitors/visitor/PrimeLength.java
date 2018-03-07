package fileVisitors.visitor;

import fileVisitors.treeBuilder.Node;
import fileVisitors.treeBuilder.TreeBuilder;

import fileVisitors.util.MyLogger;

public class PrimeLength implements VisitorI {

	public PrimeLength() {
		MyLogger.writeMessage("PrimeLength constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void visit(TreeBuilder treeBuilderIn) {
		MyLogger.writeMessage("visit from PrimeLength", MyLogger.DebugLevel.WORD_VISIT);	
		Node root = treeBuilderIn.getRootNode();
		traverseTree(root);
	}

	private void traverseTree(Node node) {
		if(node != null) {
			int nodeLength = node.getName().length(); 
			if(checkIfPrime(nodeLength))
				node.setName(node.getName() + "-PRIME");
			traverseTree(node.left);
			traverseTree(node.right);
		}
	}

	private boolean checkIfPrime(int nodeLength) {
		if(nodeLength <= 1)
			return false;

		for(int i = 2; i <= Math.sqrt(nodeLength); i++) {
			if(nodeLength % i == 0)
				return false;
		}
		return true;
	}

}