package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.treeBuilder.Node;
import wordTree.treeBuilder.TreeBuilder;
import wordTree.util.MyLogger;
import java.lang.Runnable;

public class PopulateThread implements Runnable {

	private FileProcessor file = null;
	private TreeBuilder treeBuilder = null;

	public PopulateThread(FileProcessor fileIn, TreeBuilder treeBuilder) {
		MyLogger.writeMessage("PopulateThread constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.file = fileIn;
		this.treeBuilder = treeBuilder;
	}
	
	public void run() {
		MyLogger.writeMessage("PopulateThread run method is invoked", MyLogger.DebugLevel.IN_RUN);
		while(true) {
			// System.out.println(Thread.currentThread().getName());
			String input = file.readLine();
			// System.out.println(input);
			if(input == null)
				break;
			if(input.isEmpty())
				continue;
			buildTree(input);
		}	
	}

	public void buildTree(String input) {		
		String[] words = input.split("\\s+");
		for(int i = 0; i < words.length; i++) {
			Node temp = treeBuilder.searchNode(words[i]);
			if(temp == null) {
				MyLogger.writeMessage("Inserting " + words[i], MyLogger.DebugLevel.WORD_ADD);
				Node newNode = new Node(words[i], 1);
				treeBuilder.insertNode(newNode);
			}else {
				MyLogger.writeMessage("Updating " + words[i], MyLogger.DebugLevel.WORD_ADD);
				int frequency = temp.getFrequency();
				temp.setFrequency(++frequency);
			}
		}
	}

}