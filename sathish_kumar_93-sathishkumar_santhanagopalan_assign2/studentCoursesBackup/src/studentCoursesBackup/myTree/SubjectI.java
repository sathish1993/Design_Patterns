package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

public interface SubjectI{
	public void registerObserver(Node node, Node clone);
	public void notifyObservers(Node node, String courseToDelete);
}