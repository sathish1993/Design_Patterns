package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {

	private int myInt;

	public void setmyInt(int myIntIn) {
		myInt = myIntIn;
	}

	public int getmyInt() {
		return myInt;
	} 

	@Override
	public String toString() {
		return getClass().getName() + "~~~" + myInt;
	} 
}