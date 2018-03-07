package fileVisitors.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileProcessor{
  private String filename;
  private File inputFile;
  private BufferedReader bufferedRdr;
  public FileProcessor (String filenameParam){

    try{
      filename = filenameParam;
      inputFile = new File(filenameParam);
      bufferedRdr = new BufferedReader(new FileReader(inputFile));
      MyLogger.writeMessage("FileProcessor constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
    }catch(IOException error){
      System.out.println("IOException: " + error);
      error.printStackTrace();
      System.exit(0);
    }
  }
  /**
  * @return String
  */
  public String readLine(){
    if(bufferedRdr != null){
      try{
        return bufferedRdr.readLine();
      }catch(IOException error){
        System.out.println("IOException: "+ error);
        error.printStackTrace();
        System.exit(0);
      }
    }
    return null;
  }

}