package com.career.cup;

public class MaxTreeDepth {
	
	public class Node{
		Node left,right;
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		int val;
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		
		
	}
	public int maxDepth(Node root) {
	    if(root==null)
	        return 0;
	 
	    int leftDepth = maxDepth(root.left);
	    int rightDepth = maxDepth(root.right);
	 
	    int bigger = Math.max(leftDepth, rightDepth);
	 
	    return bigger+1;
	}



}
