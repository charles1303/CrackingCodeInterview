package com.career.cup;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAdjacentTreeNodes {

	class Node {
		private int data;
		private Node left;
		private Node right;
		private Node nextRight;

		private State state;

		public LinkedList<Node> getAdjacent() {
			return new LinkedList<Node>();
		}

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getNextRight() {
			return nextRight;
		}

		public void setNextRight(Node nextRight) {
			this.nextRight = nextRight;
		}
	}

	public static void main(String[] args) {
		Node rootNode = null;

		rootNode = addNode(rootNode, 10, true);
		rootNode = addNode(rootNode, 5, true);
		rootNode = addNode(rootNode, 2, true);

		rootNode = addNode(rootNode, 30, true);
		rootNode = addNode(rootNode, 40, true);

		linkNodesAtSameLevelWithExtraSpace(rootNode);
		System.out.println(rootNode);
	}

	private static void linkNodesAtSameLevelWithExtraSpace(Node rootNode) {
		if (rootNode == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode); // Adding Level 1 in Queue
		queue.add(null);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node != null) {
				node.setNextRight(queue.peek()); // setting nextRight to head of
													// Queue.

				if (node.getLeft() != null) // adding entries in Queue for Next
											// Level
					queue.add(node.getLeft());

				if (node.getRight() != null) // adding entries in Queue for Next
												// Level
					queue.add(node.getRight());

			} else {

				// checking if queue head is null, if it is null then this is
				// end of all levels
				// and if queue head is not null then this is end of level and
				// adding null to indicate end of level.
				if (queue.peek() != null)
					queue.add(null);

			}
		}
	}
	
	boolean search(Node nodeRoot, Node start,Node end) {
		while(nodeRoot != null){
			if(nodeRoot.getData() == start.getData() && start.getData() == end.getData())
				return true;
			nodeRoot = nodeRoot.nextRight;
		}
		return false;
	}

	private static Node addNode(Node rootNode, int i, boolean isRootNode) {
		if (rootNode == null) {
			return new ConnectAdjacentTreeNodes().new Node(i);
		} else {
			if (i > rootNode.getData()) {
				if (isRootNode) {
					Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
					rootNode.setRight(nodeToAdd);
				} else {
					Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
					rootNode.setLeft(nodeToAdd);
				}

			} else {
				if (isRootNode) {
					Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
					rootNode.setLeft(nodeToAdd);
				} else {
					Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
					rootNode.setRight(nodeToAdd);
				}
			}
		}
		return rootNode;
	}

	public class Graph {
		private LinkedList<Node> nodes;

		public LinkedList<Node> getNodes() {
			return this.nodes;
		}
	}

	enum State {
		Unvisited, Visited, Visiting;
	}

	boolean search(Graph g, Node start, Node end) {
		if (start == end)
			return true;
		// operates as Queue
		LinkedList<Node> q = new LinkedList<Node>();

		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // i.e., dequeue()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
			}
			u.state = State.Visited;
		}
		return false;
	}
	
}
