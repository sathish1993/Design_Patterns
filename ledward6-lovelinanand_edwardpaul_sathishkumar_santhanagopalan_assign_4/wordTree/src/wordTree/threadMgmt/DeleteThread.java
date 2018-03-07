package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.treeBuilder.Node;
import wordTree.treeBuilder.TreeBuilder;
import wordTree.util.MyLogger;
import java.lang.Runnable;

public class DeleteThread implements Runnable {

	private FileProcessor file = null;
	private TreeBuilder treeBuilder = null;
	private String toDelete = null;

	public DeleteThread(String delWord, TreeBuilder treeBuilder) {
		MyLogger.writeMessage("DeleteThread constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.toDelete = delWord;
		this.treeBuilder = treeBuilder;
	}
	
	public void run() {
		MyLogger.writeMessage("DeleteThread run method is invoked", MyLogger.DebugLevel.IN_RUN);
		Node temp = treeBuilder.searchNode(toDelete);
		if(temp != null) {
			int frequency = temp.getFrequency();
			if(frequency > 0){
				temp.setFrequency(--frequency);
				MyLogger.writeMessage("Decrementing frequency by 1 for node " + temp.getName() + " current frequency " + temp.getFrequency(), MyLogger.DebugLevel.WORD_DELETE);
			}

		}
	}
}