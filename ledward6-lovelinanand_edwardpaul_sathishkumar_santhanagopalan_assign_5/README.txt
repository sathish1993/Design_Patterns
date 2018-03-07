## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=debugLevel

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

[Date: 11/08/2017]

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

-----------------------------------------------------------------------
PRINT_RESULT, WORD_ADD, WORD_VISIT
Debug Level:
case 3: DebugLevel.WORD_VISIT;
  Whenever a visit functions is called

case 2: DebugLevel.WORD_ADD;
	Whenever a new word is added into tree

case 1: DebugLevel.PRINT_RESULT;
	When the output result has to be printed in console
