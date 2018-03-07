package studentCoursesBackup.myTree;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;

public class Node implements Serializable{

	private int bNumber;
	private List<String> courseList;
	public Node left;
	public Node right;
	private List<Node> observerList;

	public Node(int number){
		bNumber = number;
		courseList = new ArrayList<String>();
		observerList = new ArrayList<Node>();
		left = right = null;
	}

	public int getBNumber(){
		return bNumber;
	}
	
	public List<String> getCourseList(){
		return courseList;
	}

	public void setCourseList(List<String> list){
		courseList = list;
	}

	public List<Node> getObserverList(){
		return observerList;
	}

	public void setObserverList(List<Node> list){
		observerList = list;
	}
	
}