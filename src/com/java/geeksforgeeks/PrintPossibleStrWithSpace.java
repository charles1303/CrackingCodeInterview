package com.java.geeksforgeeks;

public class PrintPossibleStrWithSpace {

	public static void main2 (String[] args) {
		//code
		StringBuffer s = new StringBuffer("ABC");
		System.out.println(s);
		func(s,1,s.length());
	}
	//Soln 1
	static void func(StringBuffer s,int index,int strLen){
	    for(int i=index;i<strLen;i++){
	        s.insert(i," ");
	        System.out.println(s);
	        func(s,i+2,s.length());
	        s.delete(i,i+1);
	    }
	}
	
	//Soln 2
	public static void main3(String[] args) {
        String str = "ABC";
        char[] ar = str.toCharArray();
        
        //Keep tempAr size double-1 than original
        //So that it could hold String like "A B C"
        char[] tempAr = new char[(2 * ar.length)-1];
        tempAr[0] = ar[0];
        getCombinations(ar, tempAr, 1, 1, ar.length);
 }
	
	public static void getCombinations(char[] ar, char[] tempAr, int i, int j,int len) {
        if (i == len) {
               while (j < tempAr.length) {
                     tempAr[j] = ' ';
                     j++;
               }
               System.out.println(tempAr);
               return;
        }
        tempAr[j] = ar[i];
        getCombinations(ar, tempAr, i + 1, j + 1, len);

        tempAr[j] = ' ';
        tempAr[j + 1] = ar[i];
        getCombinations(ar, tempAr, i + 1, j + 2, len);
        return;
 }
	//Soln 3
	public static void main(String[] args) {
        String str = "ABCD";
        boolean used[] = new boolean[str.toCharArray().length];
        permUtil(str.toCharArray(),0,used);

    }
	public static void printArray(char[] result, boolean[] used){
        for(int i=0;i<used.length;i++){
            if(used[i]){
                System.out.print(result[i]+ " ");
            }else{
                System.out.print(result[i]);
            }
        }
        System.out.println();

    }

    public static void permUtil(char[] str, int pos, boolean[] used){

        if(pos==str.length)
            printArray(str,used);

        for(int i=pos;i<str.length;i++){
            used[i] = true;
            permUtil(str,i+1,used);
            used[i] = false;
        }

    }
	
    //Soln 4
	public static void bitImpl(String s){
		//String s="hello";
		int exp = (int) Math.pow(2, s.length());
 
		for(int i=0;i<(exp/2);i++)
		{
			for(int j=0;j<s.length();j++)
			{
				if(j==0)
				{
					System.out.print(s.charAt(j));
					continue;
				}
 
				int check=1<<j-1 & i;
				if(check>=1)
				{
					System.out.print(" "+s.charAt(j));
				}
				else
				{
					System.out.print(s.charAt(j));
				}
			}
			System.out.print("\n");
		}
	}
	
}
