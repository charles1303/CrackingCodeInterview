package com.java.geeksforgeeks;

import java.util.Stack;

public class PreOrderTree {
	
	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void preOrderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}

	public static void preorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.out.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			root = s.pop();
			root = root.right;
		}
	}

	public static void main(String[] args) {
		Node root = new PreOrderTree().new Node(1);
		root.left = new PreOrderTree().new Node(2);
		root.right = new PreOrderTree().new Node(3);
		root.left.left = new PreOrderTree().new Node(4);
		root.left.right = new PreOrderTree().new Node(5);
		root.right.left = new PreOrderTree().new Node(6);
		root.right.right = new PreOrderTree().new Node(7);
		
		PreOrderTree i = new PreOrderTree();
		i.preOrderRecursive(root);
		System.out.println();
		i.preorderIteration(root);
	}

}

