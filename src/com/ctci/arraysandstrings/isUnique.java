package com.ctci.arraysandstrings;
/**
 * @author Siddharth Sharma
 *Check if all the characters in the string are unique
 *CTCI 1.1 
 *If the string contain spaces, the spaces will be considered as repeating characters
 */
import java.util.Arrays;


public class isUnique {
	//When checking without using a Data Structure. The time complexity is nlog(n) for sorting plus O(n) for comparision
	private boolean checkUniqueCharsNoDS(String strUniqueStringCheck){
		//Case1:
		if(strUniqueStringCheck.length()>128)
			return false;
		//Case2:
		//First sort the string, then check if the adjacent characters are same or not
		char[] charUniqueStringCheck = strUniqueStringCheck.toCharArray(); 
		Arrays.sort(charUniqueStringCheck);
		String strUniqueStringCheckSorted = new String(charUniqueStringCheck);

		//Since Upper case and lower case characters have different ASCII values, it will consider them as different. 
		for(int i=0; i < (strUniqueStringCheckSorted.length()-1); i++) {
			if(strUniqueStringCheckSorted.charAt(i+1) == strUniqueStringCheckSorted.charAt(i))
				return false;
		}
		return true;
	}

	//This assumes that the given string is ASCII string, so it has 128 unique characters. So we will first check if the string length is more than 128 or not. Then we will create a array of 128 length and if any char is repeated, it will return false.
	private boolean checkUniqueChars(String strUniqueStringCheck) {
		//Case1:
		if(strUniqueStringCheck.length()>128)
			return false;
		//Case2:
		boolean[] boolCharCheck = new boolean[128];
		for(int i = 0; i<strUniqueStringCheck.length(); i++) {
			int iCurrentChar = strUniqueStringCheck.charAt(i);
			//If the boolean for that char is already true, then it has already been set. Hence return false
			if(boolCharCheck[iCurrentChar])
				return false;
			else
				boolCharCheck[iCurrentChar] = true;
		}
		return true;
	}
	
	//This method reduces space complexity, because it uses just one int variable. It can only be used for strings containing only lower case letters from a to z 
	private boolean checkUniqueCharsBitVector(String strUniqueStringCheck) {
		int checker = 0;
		for(int i=0; i<strUniqueStringCheck.length();i++) {
			int num = strUniqueStringCheck.charAt(i) - 'a';
			//If the bit is already set to 1 in checker, then that particular char is repeating. Hence return false.
			if((checker&(1 << num))>0)
				return false;
			//Make the bit corresponding to the char in ith loc as 1 in checker.
			checker |= (1 << num);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isUnique iu = new isUnique();
		String[] strSamples = new String[]{"Computers","Concurrence","This is a test string"};
		for(String strSample: strSamples)
			System.out.println("The given string ["+strSample+"] has unique characters: "+iu.checkUniqueChars(strSample));//Test with iu.checkUniqueCharsNoDS() for testing with method using no data structure
	}

}
