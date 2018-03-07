package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.lang.Object;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

public class StoreRestoreHandler implements InvocationHandler {
	
	private FileProcessor fileProcessor;
	private PrintWriter printWriter;
	private String file;
	private XMLSerialization xMLSerialization;
	
	public void setFileName(String fileIn) {
		System.out.println(fileIn);
		this.file = fileIn;

		try {
			File f = new File(fileIn);
			if(!f.exists())
				throw new FileNotFoundException("File Not found.. " + f);

			this.fileProcessor = new FileProcessor(fileIn);	
		}catch(FileNotFoundException e) {
			//For serdeser mode, no need of fileprocesspr obj
		}	
	}

	public void setPrintWriter(String fileIn) {
		try {
			File f = new File(fileIn);
			f.createNewFile();
			if(!f.exists())
				throw new FileNotFoundException("File Not found.. " + f);

			this.printWriter = new PrintWriter(f, "UTF-8");
		}catch(Exception e) {
			System.err.println("No such file");
			e.printStackTrace();
		}
		
	}

	public PrintWriter getPrintWriter() {
		return xMLSerialization.getPrintWriter();
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		String method = m.getName();
		if(method.equalsIgnoreCase("writeObj")) {
			String wireFormat = args[1].toString();
			if(wireFormat.equalsIgnoreCase("XML")){
				this.xMLSerialization = new XMLSerialization(printWriter);
				serializeData((SerializableObject)args[0], xMLSerialization);	
			}
		}else {
			XMLDeSerialization xMLDeSerialization = new XMLDeSerialization(fileProcessor);
			deSerializeData(xMLDeSerialization);
			return xMLDeSerialization.getObject();
		}
		return null;
	}

    public void serializeData(SerializableObject sObject, SerStrategyI sStrategy) {
   		sStrategy.processInput(sObject);
    }

    public void deSerializeData(SerStrategyI sStrategy) {
    	sStrategy.processInput(null);
    }

}