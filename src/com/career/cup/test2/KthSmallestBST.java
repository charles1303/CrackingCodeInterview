package com.career.cup.test2;

import java.util.Stack;

public class KthSmallestBST{
	public class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int num) {
			this.data = num;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}

		public int getData(){
			return this.data;
		}
	}

	int getKthSmallest(Node n, int k){
		Stack<Node> nodeStack = new Stack<Node>();
		while(n != null){
			nodeStack.push(n);
			n = n.left;
		}
		int i = 0;

		while(!nodeStack.isEmpty()){
			Node l = nodeStack.pop();
			i++;

			if(i == k){
				return l.data;
			}

			Node r = l.right;
			while(r != null){
				nodeStack.push(r);
				r = r.left;
			}
		}
		return -1;
	}
}
