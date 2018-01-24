package com.ctci.arraysandstrings;
/**
 * 
 * @author Siddharth Sharma
 *CTCI 1.2
 *Given 2 strings, check if one is permutation of other.
 */
public class CheckPermutation {

	//
	private boolean checkPermutationString(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		int[] charFreqStr1 = charFrequency(str1); 
		int[] charFreqStr2 = charFrequency(str2);
		for(int i=0; i<charFreqStr1.length; i++) {
			if(charFreqStr1[i]!=charFreqStr2[i])
				return false;
		}
		return true;
	}
	
	//Check for each char how many time, it is repeated, then for next string just try to find if all characters are there or not.
	//Need to see if only a-z char should be checked or symbols also
	private int[] charFrequency(String str) {
		//Considering all ASCII values
		int[] iCharFreq  = new int[128];
		for(int i=0; i<str.length();i++) {
			iCharFreq[str.charAt(i)]+=1;
		}
		
		return iCharFreq;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckPermutation cp = new CheckPermutation();

		String str1 = "Hi  who is this ?";
		String str2 = "who  Hi si ?his t";
		System.out.println("Check if the strings ["+str1+"] and ["+str2+"] are permutation of each other: "+cp.checkPermutationString(str1,str2) );
	}

}
