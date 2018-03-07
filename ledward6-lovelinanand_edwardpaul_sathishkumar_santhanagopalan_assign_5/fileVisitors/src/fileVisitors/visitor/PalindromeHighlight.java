package fileVisitors.visitor;

import fileVisitors.treeBuilder.Node;
import fileVisitors.treeBuilder.TreeBuilder;

import fileVisitors.util.MyLogger;

public class PalindromeHighlight implements VisitorI {
	
	public PalindromeHighlight() {
		MyLogger.writeMessage("PalindromeHighlight constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void visit(TreeBuilder treeBuilderIn) {
		MyLogger.writeMessage("visit from PalindromeHighlight", MyLogger.DebugLevel.WORD_VISIT);
		Node root = treeBuilderIn.getRootNode();
		traverseTree(root);
	}

	private void traverseTree(Node node) {
		if(node != null) {
			if(checkForPalindrome(node.getName()) && node.getName().length() > 3)
				node.setName(node.getName().toUpperCase());
			traverseTree(node.left);
			traverseTree(node.right);
		}
	}

	private boolean checkForPalindrome(String nodeName) {
		int start = 0, end = nodeName.length()-1;
		String reverse = new StringBuffer(nodeName).reverse().toString();
		if(nodeName.equals(reverse)){
			return true;
		}else{
			return false;
		}
	}
}