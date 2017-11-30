package com.career.cup;

import java.util.HashMap;

public class LRUCache{

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head;
	Node end;

	public class Node{
		Node next;
		Node prev;
		int key;
		int value;
		public Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}

	public int get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
			
		}
		return -1;
	} 

	public void remove(Node n){
		if(n.prev != null){
			
			n.prev.next = n.next;
		}else{
			head = n.next;
		}
		if(n.next != null){
			n.next.prev = n.next;
		}else{
			end = n.prev;
		}
	}

	public void setHead(Node n){
		if(head == null){
			head = n;
		}else{
			n.next = head;
			head = n;
		}
		if(end == null) end = head;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)){
		    Node old = map.get(key);
		    old.value = value;
		    remove(old);
		    setHead(old);
		}else{
		    Node created = new Node(key, value);
		    if(map.size()>=capacity){
		        map.remove(end.key);
		        remove(end);
		        setHead(created);
	 
		    }else{
		        setHead(created);
		    }    
	 
		    map.put(key, created);
		}
	    }
}
