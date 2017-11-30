package com.career.cup;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {
	public static Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public boolean find(int id) {
		Node current = root;
		while (current != null) {
			if (current.data == id) {
				return true;
			} else if (current.data > id) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public boolean delete(int id) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.data != id) {
			parent = current;
			if (current.data > id) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {

			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for
		// sure
		// if it does have the right child, add it to the left of
		// successorParent.
		// successsorParent
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	public void insert(int id) {
		Node newNode = new Node(id);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (id < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.println(" " + root.data);
			display(root.right);
		}
	}

	public static void main2(String arg[]) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);
		b.insert(8);
		b.insert(1);
		b.insert(4);
		b.insert(6);
		b.insert(2);
		b.insert(10);
		b.insert(9);
		b.insert(20);
		b.insert(25);
		b.insert(15);
		b.insert(16);
		System.out.println("Original Tree : ");
		System.out.println("b.root : "+b.root.data);
		b.display(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : "
				+ b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));
		b.display(root);
		System.out
				.println("\n Delete Node with one child (4) : " + b.delete(4));
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : "
				+ b.delete(10));
		b.display(root);
	}
	
	public static void main(String arg[]) {
		BinarySearchTree b = new BinarySearchTree();
		Node root = new Node(3);
		insert2(root,8);
		insert2(root,1);
		insert2(root,4);
		insert2(root,6);
		insert2(root,2);
		insert2(root,10);
		insert2(root,9);
		insert2(root,20);
		insert2(root,25);
		insert2(root,15);
		insert2(root,16);
		System.out.println("Original Tree : ");
		System.out.println("root : "+root.data);
		inOrder(root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : "
				+ b.find(4));
		System.out.println("Delete Node with no children (2) : " + deleteNode(root,2).data);
		inOrder(root);
		System.out
				.println("\n Delete Node with one child (4) : " + deleteNode(root,4).data);
		inOrder(root);
		System.out.println("\n Delete Node with Two children (10) : "
				+ deleteNode(root,10).data);
		inOrder(root);
	}

	// Get minimum element in binary search tree
	public static Node minimumElement(Node root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}

	public static Node deleteNode(Node root, int value) {
		if (root == null)
			return null;
		if (root.data > value) {
			root.left = deleteNode(root.left, value);
		} else if (root.data < value) {
			root.right = deleteNode(root.right, value);

		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				Node temp = root;
				// Finding minimum element from right
				Node minNodeForRight = minimumElement(temp.right);
				// Replacing current node with minimum node from right subtree
				root.data = minNodeForRight.data;
				// Deleting minimum node from right now
				deleteNode(root.right, minNodeForRight.data);

			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}

	public static Node insert(Node root, Node nodeToBeInserted) {
		if (root == null) {
			root = nodeToBeInserted;
			return root;
		}

		if (root.data > nodeToBeInserted.data) {
			if (root.left == null)
				root.left = nodeToBeInserted;
			else
				insert(root.left, nodeToBeInserted);
		} else if (root.data < nodeToBeInserted.data)
			if (root.right == null)
				root.right = nodeToBeInserted;
			else
				insert(root.right, nodeToBeInserted);
		return root;
	}
	
	public static Node insert2(Node root, int valToBeInserted) {
		Node n = new Node(valToBeInserted);
		if (root == null) {
			root = n;
			return root;
		}

		if (root.data > valToBeInserted) {
			if (root.left == null)
				root.left = n;
			else
				insert2(root.left, valToBeInserted);
		} else if (root.data < valToBeInserted)
			if (root.right == null)
				root.right = n;
			else
				insert2(root.right, valToBeInserted);
		return root;
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}
