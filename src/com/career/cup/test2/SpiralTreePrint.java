package com.career.cup.test2;

import java.util.Stack;

public class SpiralTreePrint{
	
	static Node root;
	public static void main(String[] args) 
    {
		SpiralTreePrint tree = new SpiralTreePrint();
        tree.root = new SpiralTreePrint().new Node(1);
        tree.root.left = new SpiralTreePrint().new Node(2);
        tree.root.right = new SpiralTreePrint().new Node(3);
        tree.root.left.left = new SpiralTreePrint().new Node(7);
        tree.root.left.right = new SpiralTreePrint().new Node(6);
        tree.root.right.left = new SpiralTreePrint().new Node(5);
        tree.root.right.right = new SpiralTreePrint().new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        print(root);
    }
	
	
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

	static void print(Node node){
		if(node == null) return;
		Stack<Node> nodeStack = new Stack<Node>();
		Stack<Node> nodeStack2 = new Stack<Node>();

		nodeStack.push(node);

		while(!nodeStack.isEmpty() || !nodeStack2.isEmpty()){

			while(!nodeStack.isEmpty()){
				//Node n = nodeStack.peek();
				Node n =nodeStack.pop();
				System.out.print(n.data + " ");
			
			
				if(n.right != null)nodeStack2.push(n.right);
				if(n.left != null) nodeStack2.push(n.left);
			}

			while(!nodeStack2.isEmpty()){
				//Node n = nodeStack2.peek();
				Node n = nodeStack2.pop();
				System.out.print(n.data + " ");

				if(n.left != null) nodeStack.push(n.left);
				if(n.right != null) nodeStack.push(n.right);
			}
			
		}
		
	}
}
