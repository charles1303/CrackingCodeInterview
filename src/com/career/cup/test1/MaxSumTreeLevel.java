package com.career.cup.test1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumTreeLevel {

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

		public int getData() {
			return this.data;
		}

		public Node createNode(int number) {
			return new Node(number);
		}
	}

	static void maxSumLevelInATree(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);

		int maxSum = 0;
		int level = 0;

		int localLevel = 0;
		int localSum = 0;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n == null) {
				if (!q.isEmpty()) {
					q.offer(null);
				}
				if (localSum > maxSum) {
					maxSum = localSum;
					level = localLevel;
				}
				localSum = 0;
				localLevel++;
			} else {
				if (n.left != null) {
					q.offer(n.left);
				}
				if (n.right != null) {
					q.offer(n.right);
				}
				localSum += n.getData();
			}
		}
		System.out.println("Max Sum = " + maxSum + " is at Level = " + level);

	}

	public static void main(String[] args) {
		// root level 0
		Node A = new MaxSumTreeLevel().new Node(55);
		// Level 1
		Node B = new MaxSumTreeLevel().new Node(50);
		Node C = new MaxSumTreeLevel().new Node(40);
		// Level 2
		Node D = new MaxSumTreeLevel().new Node(25);
		Node E = new MaxSumTreeLevel().new Node(80);
		Node F = new MaxSumTreeLevel().new Node(45);
		Node G = new MaxSumTreeLevel().new Node(90);
		// Level 3
		Node H = new MaxSumTreeLevel().new Node(10);
		Node I = new MaxSumTreeLevel().new Node(35);
		Node J = new MaxSumTreeLevel().new Node(65);
		Node K = new MaxSumTreeLevel().new Node(75);

		// connect Level 0 and 1
		A.left = B;
		A.right = C;
		// connect level 1 and level 2
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		// connect level 2 and level 3
		F.left = H;
		F.right = I;
		G.left = J;
		G.right = K;
		maxSumLevelInATree(A);
	}

	private void addNode(Node rootNode, int data) {

		// First check is there any Nodes present.
		if (rootNode == null) {
			// No Nodes are Present, create one and assign it to startNode
			Node temp1 = new Node(data);
			rootNode = temp1;
		} else {
			// Nodes present, So check the proper position where to add New
			// Node.

			// Checking whether Left child and Right child are present for root
			// Node.
			if (rootNode.left != null && rootNode.right != null) {
				// Left and Right Child exist, Also, we need to add ne Node in
				// Sequential Fashion of Left and Right,
				// We have to scan all Levels one by one to check a proper place
				// for new Node.
				// Also, we for each and every node we need to check whether
				// Left and Right Exist,
				// So we need to store them for later Processing that is why we
				// introduced Queue.

				Queue<Node> queue = new LinkedList<Node>();
				queue.add(rootNode);

				while (!queue.isEmpty()) {
					Node obj = (Node) queue.poll();
					if (obj.left != null && obj.right != null) {
						queue.add(obj.left);
						queue.add(obj.right);
					} else if (obj.left == null) {
						Node temp1 = new Node(data);
						obj.left = temp1;
						break;
					} else {
						Node temp1 = new Node(data);
						obj.right = temp1;
						break;
					}
				}

			} else {
				// We reach this condition when either Left or Right is Null,
				// but not sure which side is Null.
				if (rootNode.left == null) {
					Node temp1 = new Node(data);
					rootNode.left = temp1;
				} else {
					Node temp1 = new Node(data);
					rootNode.right = temp1;
				}
			}
		}
	}

}
