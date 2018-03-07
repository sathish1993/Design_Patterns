## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------
## To take java documentation: 
ant -buildfile src/build.xml doc

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/03/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Data Structures:

Tree:
	Insertion & Search Time complexity: O(log n) where n is the number of nodes in the tree
	Insertion & Search Space complexity: O(n) where n is the number of nodes in the tree


ArrayList:
	Insertion & Other manipulations Time and Space Complexity: O(n) where n is the size of the list

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

BST Algorithm: https://en.wikipedia.org/wiki/Binary_search_tree

Clonebale Interface : http://mrbool.com/how-to-implement-cloning-in-java-using-cloneable-interface/28410

Java doc generation:  https://stackoverflow.com/questions/1495982/how-to-generate-javadoc-with-ant-for-an-existing-project

Observer Pattern: https://dzone.com/articles/observer-pattern-java

Deep Clone through Object Serialisation: https://alvinalexander.com/java/java-deep-clone-example-source-code
-----------------------------------------------------------------------

Observer Pattern Implementation: 

When a course has to be deleted. we remove it from the course arraylist and call notifyObservers(). 
For all observers associated to the original node, we call update(), which in turn removes the 
required course from the backup nodes.
