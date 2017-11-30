package com.career.cup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test1 {
	
	public static void main(String[] args){
		groupElements();
	}

	public int hasBalancedBracket(String str){
		Stack<Character> s = new Stack();
		char[] arr = str.toCharArray();
		for(int i = 0; i < arr.length;i++){
			if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
				s.push(arr[i]);
			}else if(arr[i] == ')'&& s.peek() == '('){
				s.pop();
			}else if(arr[i] == ']'&& s.peek() == '['){
				s.pop();
			}else if(arr[i] == '}'&& s.peek() == '}'){
				s.pop();
			}
						
		}
		if(s.isEmpty()){
			return 1;
		}else{
			return 0;
		}
	
		}
	
	public static void groupElements(){
		int[] arr = {8,4,1,2,3,4,2,1};
		SortedMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i])){
				map.replace(arr[i], map.get(arr[i]) + 1);
			}else{
				map.put(arr[i], 1);
			}
		}
		String str = "";
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			
			System.out.print(str+entry.getKey() + "-" + entry.getValue());
			str = ",";
		}
	}
	
	public static void sortElems(Map<String, String> map){
		//Sort by map key
	      SortedSet<String> keys = new TreeSet<String>(map.keySet());
			for (String key : keys) { 
			   String value = map.get(key);
			   // do something
			}
			
			//Sort by map value
	        Map<Integer, String> studentMap = new HashMap<Integer, String>();  
	        studentMap.put(1, "Satish");  
	        studentMap.put(2, "Ashish");  
	        studentMap.put(3, "Manish");  
	        studentMap.put(4, "Rajnish");  
	        studentMap.put(5, "Kavita");  
	        Set<Map.Entry<Integer, String>> set = studentMap.entrySet();  
	        List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(  
	                  set);  
	        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {  
	             @Override  
	             public int compare(Entry<Integer, String> o1,  
	                       Entry<Integer, String> o2) {  
	                  return o1.getValue().compareTo(o2.getValue());  
	             }  
	        });  
	        for (Map.Entry<Integer, String> entry : list) {  
	             System.out.println(entry.getKey() + " " + entry.getValue());  
	        }  
	     
	}
}
