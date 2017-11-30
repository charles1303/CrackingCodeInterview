package com.career.cup;

import java.util.ArrayList;
import java.util.List;

public class InterLeaver {

    /**
     * Returns a list containing all possible interleavings of two strings.
     * The order of the characters within the strings is preserved.
     */
    public static String s1 = "ab";
    public static String s2 = "1234";

    public static void interleave(int i, int j, String s) {

        if (i == s1.length() && j == s2.length()) {
            System.out.println("" + s);
        }

        if (i != s1.length()) {
            interleave(i + 1, j, s + s1.charAt(i));
        }

        if (j != s2.length()) {
            interleave(i, j + 1, s + s2.charAt(j));
        }

    }//Method ends here
    
    private static void printAllInterleavings(String str1, String str2, String interleavingString){
    	  
    	  //If string 1 is null then print string 2 and return
    	  if(str1 == null){
    	   System.out.println(str2);
    	   return;
    	  }
    	  
    	  //If string 2 is null then print string 1 and return
    	  if(str2 == null){
    	   System.out.println(str1);
    	   return;
    	  }
    	  
    	  //if string 1 and string 2 length became 0, it means all characters from str1 and str2 is present in interleaving, print interleavingString.
    	  if(str1.length()==0 && str2.length()==0){
    	   System.out.println("interleavingString====="+interleavingString);
    	  }
    	  
    	  //pick characters from string 1 until string 1 length is empty.
    	  if(str1.length() != 0){
    	   //pick character from string 1 and append it in interleavingString string. In next recursive call remove picked character from string 1. 
    		  System.out.println("str1===="+str1);
    		  printAllInterleavings(str1.substring(1), str2, interleavingString + str1.charAt(0));
    	  }
    	  
    	  //pick characters from string 2 until string 2 length is empty.
    	  if(str2.length() != 0){
    	   //pick character from string 2 and append it in interleavingString string. In next recursive call remove picked character from string 2.
    		  System.out.println("str2===="+str2);
    		  printAllInterleavings(str1, str2.substring(1), interleavingString + str2.charAt(0));
    	  }
    }

    /**
     * Prints some example interleavings to stdout.
     */
   /* public static void main(String[] args) {

        interleave(0, 0, "");
    }//Method ends here*/
    
    
    public static List<String> interleave(String s, String t) {
        List<String> result = new ArrayList<String>();
        if (t.isEmpty()) {
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                    result.add(left + c + u);
                }
            }
        }
        return result;
    }

    /**
     * Prints some example interleavings to stdout.
     */
    public static void main(String[] args) {
        /*System.out.println(interleave("", ""));
        System.out.println(interleave("a", ""));
        System.out.println(interleave("", "1"));
        System.out.println(interleave("a", "1"));
        System.out.println(interleave("ab", "1"));
        System.out.println(interleave("ab", "12"));
        System.out.println(interleave("abc", "12"));*/
        //System.out.println(interleave("ab", "1234"));
        //interleave(0, 0, "");
        printAllInterleavings("ab", "1234", "");
    }

}//Class ends here
