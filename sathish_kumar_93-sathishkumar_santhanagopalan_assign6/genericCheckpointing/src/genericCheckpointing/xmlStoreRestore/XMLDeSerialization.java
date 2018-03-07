package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;
import java.lang.Class;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Object;
// import java.lang.ClassNotFoundException;

public class XMLDeSerialization implements SerStrategyI {
    
    private FileProcessor fileProcessor;
    private Class<?> clazz = null;
    private SerializableObject object = null;
	
    public XMLDeSerialization(FileProcessor fileProcessorIn) {
		  this.fileProcessor = fileProcessorIn;
    }

    public SerializableObject getObject() {
      return object;
    }

    public void processInput(SerializableObject sObject) {
    	String input = fileProcessor.readLine().trim();
    	if(input != null) {
    		if(input.equalsIgnoreCase("<DPSerialization>")) {
    			object = processObject();
    		}
    	}
   	}

   	private SerializableObject processObject() {
      Object object = null;
      try {    
     		String objectType = fileProcessor.readLine().trim();
      	objectType = objectType.substring(49);
        System.out.println("objectType----->" + objectType);
  		  String obj[] = objectType.split("\"");
        
        clazz = Class.forName("genericCheckpointing.util." + obj[0]);
     		object = clazz.newInstance();
        while(true) {
          String input = fileProcessor.readLine().trim();
          if(input == null || input.equalsIgnoreCase("</DPSerialization>"))
            break;
     			
          if(input.equalsIgnoreCase("</complexType>"))
     				continue;
          
     			String entry[] = parseLine(input);
  		    Field field = clazz.getDeclaredField(entry[0]);

  		    if(field.getType() == int.class) {
  				  String fieldName = field.getName();
  				  String methName = "set" + fieldName;
            Class[] argTypes = new Class[] { int.class };
            Method method = clazz.getDeclaredMethod(methName, argTypes);
            method.invoke(object, Integer.parseInt(entry[1]));
  			 }
  		
  		  }
      }catch(Exception e) {
        System.err.println("Exception occured " + e);
        e.printStackTrace();
      }
		  return (SerializableObject)object;  
   	}

   	private String[] parseLine(String line) {
   		String[] lineArr = line.split(" ");
   		String field = lineArr[0].substring(1);
   		int start = lineArr[1].indexOf(">");
   		int end = lineArr[1].indexOf("<");
   		String fieldEntry = lineArr[1].substring(start+1, end);
   		return new String[]{field, fieldEntry};
   	}
}