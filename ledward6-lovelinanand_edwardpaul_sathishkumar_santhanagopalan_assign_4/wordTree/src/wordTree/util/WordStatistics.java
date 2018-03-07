package wordTree.util;

import wordTree.treeBuilder.Node;

public class WordStatistics {
  private int wordCount = 0;
  private int charCount = 0;
  private int uniqueWordCount = 0;

  public WordStatistics(Node node){
    MyLogger.writeMessage("WordStatistics constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
    _calculateRecursive(node);
  }

  private void _calculateRecursive(Node root){
    if(root != null){
      wordCount += root.getFrequency();
      charCount += root.getName().length() * root.getFrequency();
      uniqueWordCount += 1; 
      // System.out.println("Root Name " + root.getName() + " frequency " + root.getFrequency());
      _calculateRecursive(root.left);
      _calculateRecursive(root.right);
    }
  }
  public int getWordCount(){
    return wordCount;
  }

  public int getCharCount(){
    return charCount;
  }

  public int getUniqueWordCount(){
    return uniqueWordCount;
  }

}