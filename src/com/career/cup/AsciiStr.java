package com.career.cup;

import java.util.HashMap;

public class AsciiStr {
	static HashMap<Integer,Character> map = new HashMap<Integer,Character>();
	public static void main(String[] args){
		createMap();
		decrypt(encrypt("middle-Outy"));
	}

	private static void createMap() {
		
		for(int i = 65; i <= 90; i++){
			char character = (char)i;
			map.put(i, character);
			System.out.println(i+"===="+character);
		}
		
		for(int i = 97; i <= 122; i++){
			char character = (char)i;
			map.put(i, character);
			System.out.println(i+"===="+character);
		}
		
		/*for(int i = 48; i <= 57; i++){
			char character = (char)i;
			map.put(i, character);
			System.out.println(i+"===="+character);
		}*/
	}
	
	private static int getAsciiVal(char ch){
		return (int)ch;
	}
	
	private static String encrypt(String str){
		StringBuffer buffer = new StringBuffer();
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length;i++){
			int ascii = getAsciiVal(c[i]);
			if(!map.containsKey(ascii)){
				buffer.append(c[i]);
				continue;
			}
			int newAscii = ascii;
			if(map.containsKey(ascii)){
				if((ascii > 64 && (ascii + 2) < 90) || (ascii > 96 && (ascii + 2) < 122)){
					newAscii = (ascii + 2);
					
				}else if((ascii + 2) > 90 && ascii <= 97){
					newAscii = 64 + (ascii + 2) - 90;
				}else{
					newAscii = 96 + (ascii + 2) - 122;
				}
			}
			System.out.println("newAscii===="+newAscii);
			buffer.append(map.get(newAscii));
		}
		
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	//int ascii = (int) character;
	private static void decrypt(String str){
		StringBuffer buffer = new StringBuffer();
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length;i++){
			int ascii = getAsciiVal(c[i]);
			if(!map.containsKey(ascii)){
				buffer.append(c[i]);
				continue;
			}
			//
			int newAscii = ascii;
			if(map.containsKey(ascii)){
				if((ascii > 64 && (ascii + 2) < 90) || (ascii > 96 && (ascii + 2) < 122)){
					newAscii = (ascii - 2);
					
				}else if((ascii - 2) < 64 && ascii <= 97){
					newAscii = 64 + (ascii - 2) - 90;
				}else{
					newAscii = 96 + (ascii - 2) - 122;
				}
			}
			System.out.println("newAscii===="+newAscii);
			buffer.append(map.get(newAscii));
		}
		
		System.out.println(buffer.toString());
	}
	

}
