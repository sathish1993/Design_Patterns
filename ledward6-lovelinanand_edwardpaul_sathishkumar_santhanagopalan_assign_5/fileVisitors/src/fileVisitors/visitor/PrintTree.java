package fileVisitors.visitor;

import java.util.Set;
import java.util.TreeSet;

import fileVisitors.treeBuilder.Node;
import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Results;
public class PrintTree implements VisitorI {
	private Results results;
	private Set<String> uniqueNodes = null;
	
	public PrintTree(Results resultIn) {
		MyLogger.writeMessage("PrintTree constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.results = resultIn;
		this.uniqueNodes = new TreeSet<String>();
	}

	public void visit(TreeBuilder treeBuilderIn) {
		MyLogger.writeMessage("visit from PrintTree", MyLogger.DebugLevel.WORD_VISIT);	
		Node root = treeBuilderIn.getRootNode();
		traverseTree(root);
		for(String word : uniqueNodes)
			this.results.storeNewResult(word);
	}

	private void traverseTree(Node node) {
		if(node != null) {
			uniqueNodes.add(node.getName());
			traverseTree(node.left);
			traverseTree(node.right);
		}
	}
}
