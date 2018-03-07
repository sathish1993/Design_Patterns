package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import java.util.Random;
import java.io.PrintWriter;
import java.lang.Class;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Object;

public class XMLSerialization implements SerStrategyI {

	private String file;
    private PrintWriter printWriter;

    public XMLSerialization(PrintWriter printWriterIn) {
		this.printWriter = printWriterIn;
    }

    public PrintWriter getPrintWriter() {
    	return printWriter;
    }

    public void processInput(SerializableObject sObject) {
    	Random random = new Random();
    	setRandomValuesToObject(sObject, random);
     	printWriter.println("<DPSerialization>");
     	String className =  sObject.getClass().toString();
     	String[] classSplit = className.split(" ");
     	printWriter.println(" <complexType xsi:type=\"" + classSplit[1] +"\">");
     	buildXML(sObject);
     	printWriter.println(" </complexType>");
     	printWriter.println("</DPSerialization>");
    }

    private void setRandomValuesToObject(SerializableObject sObject, Random random) {
    	try {
	    	Field[] fields = sObject.getClass().getDeclaredFields();
	 		for(Field field: fields) {
	 			if(field.getType() == int.class) {
					String fieldName = field.getName();
					String methName = "set" + fieldName;
	        		Class[] argTypes = new Class[] { int.class };
	        		Method method = sObject.getClass().getDeclaredMethod(methName, argTypes);
	        		method.invoke(sObject, random.nextInt(1000) + 1);
				}
	 		}
	 	}catch(Exception e) {
	 		System.err.println("Exception occured");
			e.printStackTrace();
	 	}
    }

	private void buildXML(SerializableObject sObject) {
		try {
			Field[] fields = sObject.getClass().getDeclaredFields();
			for(Field field: fields) {
				String fieldName = field.getName();
				String methName = "get" + fieldName;
	        	Method method = sObject.getClass().getMethod(methName);
	        	String value = method.invoke(sObject).toString();
	        	printWriter.println("  <" + fieldName + " xsi:type=\"xsd:" + field.getType() + "\">" + value + "</" + fieldName + ">");
			}
		}catch(Exception e) {
			System.err.println("Exception occured");
			e.printStackTrace();
		}
	}



}
