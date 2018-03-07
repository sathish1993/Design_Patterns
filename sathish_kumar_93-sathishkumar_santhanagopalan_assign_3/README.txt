## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[0-4]

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/19/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Data Structures:

ArrayList:
	Insertion & Other manipulations Time and Space Complexity: O(n) where n is the size of the list

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

State pattern design: //http://www.newthinktank.com/2012/10/state-design-pattern-tutorial/
-----------------------------------------------------------------------

State Pattern Implementation: 

1. Input string is read and sent to helper class to parse it.
2. Default current state is set as low
3. Invoked tightenOrLoosenSecurity() with the current state object in the Context class (Airport.java)
4. Based on the value in current state oject, corresponding state class's tightenOrLoosenSecurity() is invoked
5. New state is identified based on the input metric values and current state object in Context class is updated
6. Once the current state is set, corresponding operations are carried out