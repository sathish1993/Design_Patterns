package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.SubjectI;
import studentCoursesBackup.myTree.ObserverI;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import java.util.List;
import java.util.ArrayList;

public class Observable implements SubjectI, ObserverI{

	//Method to add clones to the main node as observers
	public void registerObserver(Node original, Node clone){
		List<Node> tempList = original.getObserverList();
		tempList.add(clone);
		original.setObserverList(tempList);
	}

	//Method to notify all the observers about some change
	public void notifyObservers(Node node, String courseToDelete){
		List<Node> tempList = node.getObserverList();
		for(Node nodeTemp : tempList){
			update(nodeTemp, courseToDelete);
		}
	}

	//Method to apply changes in cloned nodes on call of notify observers
	public void update(Node node, String courseToDelete){
		List<String> tempList = node.getCourseList();
		if(tempList.contains(courseToDelete)){
			tempList.remove(courseToDelete);
			node.setCourseList(tempList);
		}
	}

	//Method to do deep clone of an object
	public Object deepClone(Object object){
		try{
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      		objectOutputStream.writeObject(object);
      		ByteArrayInputStream byteArrayInputStream = 
      						new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
      		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
      		return objectInputStream.readObject();
		}catch(Exception e){
			return null;
		}finally{
			//Left empty as specified by professor
		}
	}

}