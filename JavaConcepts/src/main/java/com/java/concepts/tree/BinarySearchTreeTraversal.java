package tree;

public class BinarySearchTreeTraversal {

	public static void preOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			System.out.print(root.getData() + " ");
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}

	}

	public static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.leftChild);
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.rightChild);
	}

	public static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.leftChild);
		postOrderTraversal(root.rightChild);
		System.out.print(root.getData() + " ");
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);

		bst.add(14);
		bst.add(50);
		bst.add(16);

		bst.add(70);
		bst.add(19);
		System.out.println("Preorder");
		preOrderTraversal(bst.root);
		System.out.println("\n Inorder");
		inOrderTraversal(bst.root);
		System.out.println("\n Inorder");
		postOrderTraversal(bst.root);
		
		System.out.println("\n Search node");
		bst.search(bst.root, 18);
		
		System.out.println("\n Delete node");
		bst.delete(bst.root, 16);
		
		preOrderTraversal(bst.root);
	}
}
/**
 * Time complexity of BST
 * 1. In general case or average case TC is O(h) where h is the height of the tree.
 * 2. In worst case TC is O(n) where n is the number of node where we have to traverse all node for insert, search and delete operation.
 * i.e. in this case BST is skewed BST.
 * 3. In best case, tree is balanced BST of height logn & offered all benefits of BST. Hence TC is O(logn).
 * */
