package com.career.cup;

import java.util.*;

public class TestHeap {
	
	public static void main(String[] args){
		testHeapUsingPriorityQueue();
	}
	
	
	static void testHeapUsingPriorityQueue(){
	     
	    //create a new object and add a custom comparator that provides the "MinHeap" behaviour.
	    PriorityQueue<Integer> minheap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o1-o2;
	        }
	    });
	    //add elements
	    minheap.addAll(Arrays.asList(new Integer[]{8,9,1,2,3,4,5,}));
	    System.out.println("Minheap---------------------");
	    System.out.println(Arrays.toString(minheap.toArray()));
	    for (Iterator iterator = minheap.iterator(); iterator.hasNext();) {
	        System.out.println("Min : "+minheap.element());
	        System.out.println("Removing " + minheap.element());
	        minheap.remove();
	    }
	 
	    //create a new object and add a custom comparator that provides the "MaxHeap" behaviour.
	    PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o2-o1;
	        }
	    });
	    System.out.println("Maxheap---------------------");
	    //add elements
	    maxheap.addAll(Arrays.asList(new Integer[]{8,9,1,2,3,4,5,}));
	    System.out.println(Arrays.toString(maxheap.toArray()));
	    for (Iterator iterator = maxheap.iterator(); iterator.hasNext();) {
	        System.out.println("Max : "+maxheap.element());
	        System.out.println("Removing " + maxheap.element());
	        maxheap.remove();
	    }       
	    
	  //create a new object and add a custom comparator that provides the "MinHeap" behaviour.
	    PriorityQueue<Character> minCharheap=new PriorityQueue<Character>(1,new Comparator<Character>() {
	        @Override
	        public int compare(Character c1, Character c2) {
	            //return c1-c2;
	        	return c1.compareTo(c2);
	            
	        }
	    });
	    System.out.println("Min Char heap---------------------");
	    //add elements
	    minCharheap.addAll(Arrays.asList(new Character[]{'a','z','v','h','b','u'}));
	    System.out.println(Arrays.toString(minCharheap.toArray()));
	    for (Iterator iterator = minCharheap.iterator(); iterator.hasNext();) {
	        System.out.println("Min : "+minCharheap.element());
	        System.out.println("Removing " + minCharheap.element());
	        minCharheap.remove();
	    }  
	    
	    //create a new object and add a custom comparator that provides the "MaxHeap" behaviour.
	    PriorityQueue<Character> maxCharheap=new PriorityQueue<Character>(1,new Comparator<Character>() {
	        @Override
	        public int compare(Character c1, Character c2) {
	            //return c2-c1;
	        	return c2.compareTo(c1);
	            
	        }
	    });
	    System.out.println("Max Char heap---------------------");
	    //add elements
	    maxCharheap.addAll(Arrays.asList(new Character[]{'a','z','v','h','b','u'}));
	    System.out.println(Arrays.toString(maxCharheap.toArray()));
	    for (Iterator iterator = maxCharheap.iterator(); iterator.hasNext();) {
	        System.out.println("Max : "+maxCharheap.element());
	        System.out.println("Removing " + maxCharheap.element());
	        maxCharheap.remove();
	    }    
	    
	    /*Sort by map key
	     * SortedSet<String> keys = new TreeSet<String>(map.keySet());
			for (String key : keys) { 
			   String value = map.get(key);
			   // do something
			}
			
			Sort by map value
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
	     */
	}

}
