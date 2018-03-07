package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;

import java.lang.NumberFormatException;

public class MyArrayListTest{

	public MyArrayListTest(MyArrayList myArrayListObject, FileProcessor fileProcessorObject){
		while(true){
	    	String inputValue = fileProcessorObject.readLine();
	    	if(inputValue == null)
	    		break;
	    	try{
	    		int parsedInputValue = Integer.parseInt(inputValue);
	    		if(parsedInputValue < 0)
	    			throw new Exception();
	    		myArrayListObject.insertSorted(parsedInputValue);	
	    	}catch(NumberFormatException e){
	    		System.err.println("Please give integer values as input");
	    		e.printStackTrace();
	    		System.exit(0);
	    	}catch(Exception e){
	    		System.err.println("Please give positive values as input");
	    		e.printStackTrace();
	    		System.exit(0);
	    	}finally{
	    		//Left empty as specified by professor
	    	}
	    }
	}

	//Method to run test cases on myArrayList
	public void testMe(MyArrayList myArrayList, Results results){
		
		int initialSum = myArrayList.sum(); 
		//Test 1: Adding more elements than initial size = 50, to check if array size increases or not
		int sum = 0;
		for(int i = 1; i < 52; i++){
			myArrayList.insertSorted(i);
			sum += i;
		}
		if(myArrayList.size() > 50){
			String result = "Test ArrayResize Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test ArrayResize Fail, MyArrayList size did not increase by 50%";
			results.storeNewResult(result);
		}

		//Test 2: Removing 0 from myArrayList
		int curSize = myArrayList.size();
		myArrayList.removeValue(0);
		if(myArrayList.size() == --curSize){
			String result = "Test RemoveValue 0 Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test RemoveValue 0 Fail, Element 0 is not removed";
			results.storeNewResult(result);
		}

		//Test 3: Removing an negative value, which would not be there
		myArrayList.removeValue(-10);
		if(myArrayList.size() == curSize){
			String result = "Test RemoveNegativeValue Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test RemoveNegativeValue Fail, -10 found";
			results.storeNewResult(result);
		}		

		//Test 4: Checking index of removed element 0 should return -1
		if(myArrayList.indexOf(0) == -1){
			String result = "Test CheckIndexFor0 Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test CheckIndexFor0 Fail, Element 0 found.";
			results.storeNewResult(result);
		}

		//Test 5: Checking index of element 1 should return index 1 
		if(myArrayList.indexOf(1) == 0){
			String result = "Test CheckIndexFor1 Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test CheckIndexFor1 Fail, Element 1 not in index 1";
			results.storeNewResult(result);
		}		

		//Test 6: Checking if sum() is working as expected
		if(myArrayList.sum() - initialSum == sum){
			String result = "Test Sum Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test Sum Fail, Sum did not match with test value";
			results.storeNewResult(result);
		}

		//Test 7: Checking size of MyArrayList, after inserting 57 values
		if(myArrayList.size() == 60){
			String result = "Test Size Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test Size Fail, MyArrayList size is " + myArrayList.size() + " but test value is 60";
			results.storeNewResult(result);	
		}
		
		//Test 8: Checking if all the occurences of values are removed
		for(int i = 1; i < 52; i++){
			myArrayList.removeValue(i);
			if(myArrayList.indexOf(i) != -1){
				String result = "Test RemoveAllOccurences Fail, not all occurences of the value " + i + " is removed, as -1 is not returned";
				results.storeNewResult(result);			
				break;
			}
		}
		String resultRemoveAllOccurences = "Test RemoveAllOccurences Pass";
		results.storeNewResult(resultRemoveAllOccurences);
		
		//Test 9: Checking if size and sum after removing some of the elements
		if(myArrayList.size() != 3 || myArrayList.sum() != 11356){
			String result = "Test SizeAndSumAfterClearingSomeOfTheArrayList Fail, as sum is myArrayList size is " + 
				myArrayList.size() + " and myArrayList sum is " + myArrayList.sum();
			results.storeNewResult(result);			
		}else{
			String result = "Test SizeAndSumAfterClearingSomeOfTheArrayList Pass";
			results.storeNewResult(result);
		}

		//Inserting values
		for(int i = 4; i > -1; i--){
			myArrayList.insertSorted(i);
		}

		//Test 10: Checking if first value is the smallest after inserting some elements
		if(myArrayList.indexOf(0) == 0){
			String result = "Test FirstValue Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test FirstValue Fail, as 0 is not the first element after sorting";
			results.storeNewResult(result);
		}

		//Test 11: Checking if last value is the largest after inserting some elements
		if(myArrayList.indexOf(4) == 4){
			String result = "Test LastValue Pass";
			results.storeNewResult(result);
		}else{
			String result = "Test LastValue Fail, as 4 is not the last element after sorting";
			results.storeNewResult(result);	
		}

	}
}