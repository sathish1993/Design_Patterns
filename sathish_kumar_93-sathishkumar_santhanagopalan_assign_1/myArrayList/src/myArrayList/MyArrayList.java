package myArrayList;

public class MyArrayList{
	private int CURR_SIZE = 50;
	private int[] myArray = new int[CURR_SIZE];

	//Initialize array
	public MyArrayList(){
		for(int i = 0; i < myArray.length; i++)
			myArray[i] = -1;
	}
	
	//Method to insert element into array
	public void insertSorted(int newValue){
		if(size() == CURR_SIZE){
			CURR_SIZE = myArray.length + (myArray.length/2);
			int[] tempArray = new int[CURR_SIZE];
			tempArray = copyToTempArray(tempArray);
			myArray = tempArray;
			insert(newValue);
		}else {
			insert(newValue);	
		}
	}

	//Helper method to insert
	private void insert(int value){
		int breakIndex = 0;
		for(int i = 0; i < myArray.length; i++){
			if(myArray[i] == -1){
				myArray[i] = value;
				breakIndex = i;
				break;
			}
		}
		sortArray(breakIndex);
	}

	//Helper method to copy to temp array
	private int[] copyToTempArray(int[] copyToArray){
		for(int i = 0; i < myArray.length; i++)
			copyToArray[i] = myArray[i];
		for(int j = myArray.length; j < copyToArray.length; j++)
			copyToArray[j] = -1;
		return copyToArray;
	}

	//Helper method to sort array using bubble sort
	private void sortArray(int breakIndex){
		for(int i = 0; i <= breakIndex; i++){
			for(int j = 1; j <= (breakIndex-i); j++){
				if(myArray[j-1] > myArray[j]){
					int temp = myArray[j-1];
					myArray[j-1] = myArray[j];
					myArray[j] = temp; 
				}	
			}
		}
	}

	//Method to remove value
	public void removeValue(int value){
		int index = 0;
		for(int i = 0; i < myArray.length-1; i++){
			if(myArray[i] == value){
				myArray[index] = myArray[i+1];
			}else{
				myArray[index++] = myArray[i];
			}
		}
		if(myArray[myArray.length-1] !=  value)
			myArray[index] = myArray[myArray.length-1];
		else
			myArray[index] = -1;	
	}

	//Method to return index of certain value
	public int indexOf(int value){
		for(int i = 0; i < myArray.length; i++)
			if(myArray[i] == value)
				return i;
		return -1;
	}

	//Method to return size of array
	public int size(){
		for(int i = 0; i < myArray.length; i++)
			if(myArray[i] == -1)
				return i;			
		return myArray.length;
	}

	//Method to retyrn sum of array
	public int sum(){
		int sum = 0;
		for(int i = 0; i < myArray.length; i++){
			if(myArray[i] != -1){
				sum += myArray[i];
			}else{
				break;
			}
		}
		return sum;
	}

	//Method to return elements of the array
	public String toString(){
		System.out.println("Elements in the array:");
		for(int i = 0; i < myArray.length; i++){
			if(myArray[i] != -1){
				System.out.println("Index " + i + " Value " + myArray[i]);
			}else{
				break;
			}
		}
		return "true";
	}
}