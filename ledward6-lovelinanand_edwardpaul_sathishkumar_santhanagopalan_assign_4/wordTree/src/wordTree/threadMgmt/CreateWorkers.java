package wordTree.threadMgmt;

import wordTree.util.MyLogger;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import java.lang.Thread;

import wordTree.treeBuilder.TreeBuilder;

public class CreateWorkers {
	
	private FileProcessor file;
	private Thread[] threadsArr;
	private TreeBuilder treeBuilder;
	private String[] delWords;

	public CreateWorkers(FileProcessor fileIn, String[] delWords, TreeBuilder treeBuilder) {
		MyLogger.writeMessage("CreateWorkers constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		this.file = fileIn;
		this.treeBuilder = treeBuilder;
		this.delWords = delWords;
	}	

	public void startPopulateWorkers(int threads) {
		threadsArr = new Thread[threads];
		for(int i = 0; i < threadsArr.length; i++) {
			String threadName = "thread" + i;
			threadsArr[i] = new Thread(new PopulateThread(file, treeBuilder), threadName);
			threadsArr[i].start();
		}

		for(int i = 0; i < threadsArr.length; i++) {
			try {
				threadsArr[i].join();
			}catch(InterruptedException e) {
				System.err.println("Thread InterruptedException occured!!");
				e.printStackTrace();
				System.exit(0);
			}
		}

		// treeBuilder.Print(false);
	}

	public void startDeleteWorkers(int threads) {
		threadsArr = new Thread[threads];
		for(int i = 0; i < threadsArr.length; i++) {
			String threadName = "thread" + i;
			threadsArr[i] = new Thread(new DeleteThread(delWords[i], treeBuilder), threadName);
			threadsArr[i].start();
		}

		for(int i = 0; i < threadsArr.length; i++) {
			try {
				threadsArr[i].join();
			}catch(InterruptedException e) {
				System.err.println("Thread InterruptedException occured!!");
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}