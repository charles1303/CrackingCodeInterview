package com.career.cup;

public class NodeDistance {
	
	public class Node<E>{
		private Node leftNode;
		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		private Node rightNode;
		private E data;
		
		public Node(E data){
			this.data = data;
		}
	}

	public static int maxDistance(final Node node, final int currentMax, int max) {
        if ((node.getLeftNode() == null) && (node.getRightNode() == null)) {
            if (currentMax > max) {
                max = currentMax;
            }
        } else {
            if (node.getLeftNode() != null) {
                max = maxDistance(node.getLeftNode(), currentMax + 1, max);
            } else if (node.getRightNode() != null) {
                max = maxDistance(node.getRightNode(), currentMax + 1, max);
            }
        }
        return max;
    }
}
