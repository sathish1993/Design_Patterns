package fileVisitors.util;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface, FileDisplayInterface{
  ArrayList<String> strStore;
 
  public Results(){
    strStore = new ArrayList<String>();
    MyLogger.writeMessage("Results constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
  }
  
  public void storeNewResult(String log){
    strStore.add(log);
  }
  
  public void writeToStdout(){
    int totalTests = strStore.size();
    for(int i = 0; i < totalTests; i ++){
      System.out.println(strStore.get(i));      
    }
  }
 
  public void writeToFile(String outputFile){
    try{
      PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
      int totalTests = strStore.size();
      for(int i = 0; i < totalTests; i ++){
        writer.println(strStore.get(i));
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("IOException:" + e);
    }
  }
}