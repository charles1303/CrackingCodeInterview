package com.career.cup;

import com.career.cup.RemoveResources.Stack.Node;

public class RemoveResources{
	public class Stack{
		private Node top;

		public class Node<E>{
			private Node next;
			private E data;

			public Node(E data){
				this.data = data;
			}
			
			public int getData(){
				return (int)data;
			}
		}

		public Node pop(){
			if(top != null){
				Node n = top;
				top = top.next;
				return n;
			}
			return null;
		}

		public void push(Node n){
				Node temp = top;
				top = n;
				top.next = temp;
		}

		public Node peek(){
			return top;
		}

		public boolean isEmpty(){
			return top == null;
		}	
	}

	public void doRemove(Node node){
		Stack s = new Stack();
		while(node != null){
			int negativeVal = 0;
			if(node.getData() > 0 || s.isEmpty()){
				s.push(node);
			}else{
				negativeVal = node.getData();
				while(negativeVal != 0){
					negativeVal +=s.pop().getData();
				}
			node = node.next;
				
			}
		}
	}
}
