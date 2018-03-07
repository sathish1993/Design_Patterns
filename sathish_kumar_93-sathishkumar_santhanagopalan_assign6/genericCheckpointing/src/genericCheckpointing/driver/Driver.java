package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.util.List;
import java.util.ArrayList;

public class Driver {
    
    public static void main(String[] args) {
	
	// FIXME: read the value of checkpointFile from the command line
    try {
			if(args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
				System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[0-4]");
				System.exit(0);
			}
	}catch(NumberFormatException e) {
			System.err.println("Number Format Exception!! Pleasae enter proper value between 0 and 4. Number Format Exception");
			e.printStackTrace();
			System.exit(0);		
	}

	String mode = args[0];
	int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
	String fileName = args[2];

	ProxyCreator pc = new ProxyCreator();
	
	// create an instance of StoreRestoreHandler (which implements
	// the InvocationHandler
	StoreRestoreHandler storeRestoreHandler = new StoreRestoreHandler();
	
	// create a proxy
	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 storeRestoreHandler
								 );
		
	// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
	storeRestoreHandler.setFileName(fileName);
	MyAllTypesFirst myFirst;
	MyAllTypesSecond  mySecond;

	// Use an if/switch to proceed according to the command line argument
	// For deser, just deserliaze the input file into the data structure and then print the objects
	// The code below is for "serdeser" mode
	// For "serdeser" mode, both the serialize and deserialize functionality should be called.

	List<SerializableObject> myRecordRetList = new ArrayList<SerializableObject>();
	if(mode.equalsIgnoreCase("deser")) {
		SerializableObject myRecordRet;

		// create a data structure to store the returned ojects
		for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

		    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
		    System.out.println(myRecordRet);
		    myRecordRetList.add(myRecordRet);
		}
	}else {
		storeRestoreHandler.setPrintWriter(fileName);
	// create a data structure to store the objects being serialized
        // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
		for (int i=0; i<NUM_OF_OBJECTS; i++) {

		    // FIXME: create these object instances correctly using an explicit value constructor
		    // use the index variable of this loop to change the values of the arguments to these constructors
		    myFirst = new MyAllTypesFirst();
		    mySecond = new MyAllTypesSecond();

		    // FIXME: store myFirst and mySecond in the data structure
		    ((StoreI) cpointRef).writeObj(myFirst, "XML");
		    ((StoreI) cpointRef).writeObj(mySecond, "XML");

		}
		storeRestoreHandler.getPrintWriter().close();	
		/*SerializableObject myRecordRet;

		// create a data structure to store the returned ojects
		for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

		    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
		    // FIXME: store myRecordRet in the vector
		}*/
	}
	// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

	// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
	// The comparison should use the equals and hashCode methods. Note that hashCode 
	// is used for key-value based data structures
    
    }
}