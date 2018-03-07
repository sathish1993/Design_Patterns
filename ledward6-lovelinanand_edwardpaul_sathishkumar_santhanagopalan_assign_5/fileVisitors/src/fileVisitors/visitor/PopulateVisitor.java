package fileVisitors.visitor;

import fileVisitors.treeBuilder.Node;
import fileVisitors.treeBuilder.TreeBuilder;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

public class PopulateVisitor implements VisitorI {

	private FileProcessor file = null;

	public PopulateVisitor(String fileName) {
		MyLogger.writeMessage("PopulateVisitor constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.file = new FileProcessor(fileName);
	}

	public void visit(TreeBuilder treeBuilderIn) {	
		MyLogger.writeMessage("visit from PopulateVisitor", MyLogger.DebugLevel.WORD_VISIT);
		while(true) {
			String input = file.readLine();
			if(input == null)
				break;
			if(input.isEmpty())
				continue;
			buildTree(input, treeBuilderIn);
		}
	}

	private void buildTree(String input, TreeBuilder treeBuilder) {
		String[] words = input.split("\\s+");
		for(int i = 0; i < words.length; i++) {
			Node temp = treeBuilder.searchNode(words[i]);
			if(temp == null) {
				MyLogger.writeMessage("Inserting " + words[i], MyLogger.DebugLevel.WORD_ADD);
				Node newNode = new Node(words[i], 1);
				treeBuilder.insertNode(newNode);
			}
		}
	}


}