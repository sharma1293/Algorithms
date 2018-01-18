package com.ctci.arraysandstrings;
//Check if all the characters in the string are unique
//CTCI 1.1
public class isUnique {
	//When checking without using a Data Structure
	//This assumes that the given string is ASCII string, so it has 128 unique characters. So we will firsth check if the string length is more than 128 or not. Then we will create a array of 128 length and if any char is repeated, it will return false.
	private boolean checkUniqueChars(String strUniqueStringCheck) {
		//Case1:
		if(strUniqueStringCheck.length()>128)
			return false;
		//Case2:
		boolean[] boolCharCheck = new boolean[128];
		for(int i = 0; i<strUniqueStringCheck.length(); i++) {
			int iCurrentChar = Character.getNumericValue(strUniqueStringCheck.charAt(i));
			//If the boolean for that char is already true, then it has already been set. Hence return false
			if(boolCharCheck[iCurrentChar])
				return false;
			else
				boolCharCheck[iCurrentChar] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isUnique iu = new isUnique();
		String[] strSamples = new String[]{"Computers","Concurrence"};
		for(String strSample: strSamples)
		System.out.println("The given string ["+strSample+"] has unique characters: "+iu.checkUniqueChars(strSample));
	}

}
