package fileVisitors.wordManipulation;

import fileVisitors.util.MyLogger;
import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.visitor.VisitorI;

public class WordManipulation {

	private TreeBuilder treeBuilder = null;

	public WordManipulation(TreeBuilder treeBuilderIn) {
		MyLogger.writeMessage("WordManipulation constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.treeBuilder = treeBuilderIn;
	}

	public void accept(VisitorI visitor) {
		visitor.visit(treeBuilder);
	}
}