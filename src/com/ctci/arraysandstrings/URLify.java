package com.ctci.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Siddharth Sharma
 * CTCI 1.3 URLify
 *Replace space with %20
 *True length: length till last character (excluding spaces at end)
 *First calculate true length. Find spaces, then calculate the length of final string and the replace all spaces with %20 looping from the last character
 *It can also be implemented with string inbuilt method, (String.replace(' ','%20')) but will have to first remove white spaces at end (String.trim()).
 */

public class URLify {
	
	
	//First it will count the spaces
	private String replaceSpaces(char[] cInput,int trLen) {
		int countSpaces = 0;
		for(int i=0; i<trLen; i++)
		{
			if(cInput[i] == ' ')
				countSpaces++;
		}
		int totalLen = trLen + 2*countSpaces;
		cInput[totalLen-1] = '\0';
		for(int i = trLen-1; i>=0; i-- )
		{
			if(cInput[i] == ' ')
			{
				cInput[--totalLen] = '0';
				cInput[--totalLen] = '2';
				cInput[--totalLen] = '%';
			}
			else
				cInput[--totalLen] = cInput[i];		
		}
		return String.valueOf(cInput);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLify ur = new URLify();
		String strInput = "Mr John Smith    ";
		char[] charInput = strInput.toCharArray();
		int trueLength = charInput.length;
		//Count true length, excluding trail spaces
		while(charInput[trueLength-1] == ' ')
			trueLength--;
		System.out.println("Replaced String is: "+ur.replaceSpaces(charInput, trueLength));
		
	}

}