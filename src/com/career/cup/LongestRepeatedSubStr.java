package com.career.cup;

import java.util.Arrays;

public class LongestRepeatedSubStr {
	// return the longest common prefix of s and t
    public static String lcp(String s, String t) {
    	System.out.println("Comapring====="+s+" with "+t);
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        
        System.out.println("Before sorting====="+Arrays.toString(suffixes));

        // sort them
        Arrays.sort(suffixes);
        
        System.out.println("After sorting====="+Arrays.toString(suffixes));

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            System.out.println("printing x====="+x+" for "+suffixes[i]);
            if (x.length() > lrs.length()){
            	System.out.println(x+" is greater than "+lrs);
                lrs = x;
            }
        }
        
        System.out.println("Final LRS====="+lrs);
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        //String s = StdIn.readAll();
        //s = s.replaceAll("\\s+", " ");
        //StdOut.println("'" + lrs(s) + "'");
    	lrs("banana");
    	lrs("GEEKSFORGEEKS");
    }
}
