package tree;

public class BinarySearchTree {
	public Node root;

	public BinarySearchTree() {
		root = null;
	}

	public int visited() {
		return root.getData();
	}

	public void add(int value) {
		root = add(root, value);
	}

	private Node add(Node root, int value) {
		if (root == null) {
			root = new Node(value);
		} else if (root.getData() > value) {
			root.leftChild = add(root.leftChild, value);
		} else if (root.getData() < value) {
			root.rightChild = add(root.rightChild, value);
		}
		return root;
	}
	
	public void search(Node root, int value) {
		if(root==null)
			System.out.println("Node not found in tree");
		else if(root.getData() == value) {
			System.out.println("Value found: "+value);
		}else if(root.getData()>value) {
			search(root.leftChild, value);
		}else if(root.getData()<value) {
			search(root.rightChild, value);
		}
	}

	public Node delete(Node node, int value) {
		if (node == null)
			return null;
		if (node.getData() > value) {
			node.leftChild=delete(node.leftChild, value);
		} else if (node.getData() < value) {
			node.rightChild=delete(node.rightChild, value);
		} else {
			if (node.leftChild == null || node.rightChild == null) {
				Node temp = node.leftChild != null ? node.leftChild : node.rightChild;
				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = getSuccessor(node);
				node.setData(successor.getData());
				node.rightChild = delete(node.rightChild, node.getData());
				return node;
				
			}
		}
		return node;
	}

	public Node getSuccessor(Node node) {
		if (node == null)
			return null;
		Node temp = node.rightChild;

		while (temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp;
	}
}
