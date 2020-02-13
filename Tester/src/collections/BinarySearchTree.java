package collections;

public class BinarySearchTree {
	Node root;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	BinarySearchTree() {
		root = null;
	}

	void insert(int data) {
		root = insert(root, data);
	}

	Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);

		return root;
	}

	void printInOrder(Node node) {
		if (node == null)
			return;
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	void printInOrder() {
		printInOrder(root);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] arr = { 50, 30, 60, 10, 80, 20, 70, 40 };
		for (int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);

		tree.printInOrder();

	}
}
