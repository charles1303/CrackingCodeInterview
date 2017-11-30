package com.career.cup.test2;

import java.util.Arrays;

public class CntSubstringWithSameFirstAndLastXter {
	
	static int MAX_CHAR = 26;
	
	public static void main(String[] args){
		countSubstringWithEqualEnds("abcab");
		//subStrings("abcab");
	}
	
	static void subStrings(String s)
	 {
	  int cnt = 0;
	  System.out.println("All substring of "+s+" are:");
	   for (int i = 0; i < s.length(); i++) {
	   for (int j = i+1; j <= s.length(); j++) {
	         System.out.println(s.substring(i,j));
	         cnt++;
	  
	   }
	  }
	   System.out.println(cnt);
	 }
	
	
	static int countSubstringWithEqualEnds(String s)
	{
	    int result = 0;
	    int n = s.length();
	    char[] arr = s.toCharArray();
	 
	    // Calculating frequency of each character
	    // in the string.
	    int[] count = new int[MAX_CHAR];
	    for (int i=0; i<n; i++){
	    	int k = arr[i]-'a';
	    	System.out.println("****"+k);
	    	count[k]++;
	    }
	    
	    System.out.println("count===="+Arrays.toString(count));
	    System.out.println("count length===="+count.length);
	    	//int k = arr[i]-'a';
	    	//System.out.println("****"+arr[i]-'a');
	        
	 
	    // Computing result using counts
	    for (int i=0; i<MAX_CHAR; i++){
	    	System.out.println("count[i]****"+count[i]);
	    	System.out.println("(count[i]+1)/2****"+(count[i]+1)/2);
	    	System.out.println("count[i]*(count[i]+1)/2****"+count[i]*(count[i]+1)/2);
	    	result += (count[i]*(count[i]+1)/2);
	    	
	    }
	        
	    
	 
	    return result;
	}

}
