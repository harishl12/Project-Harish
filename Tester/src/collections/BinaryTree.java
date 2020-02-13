package collections;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;

	}
}

public class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	static void printInOrder(Node node) {
		if (node == null)
			return;
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);

	}

	static void printPreOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	static void printPostOrder(Node node) {
		if (node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	void printInOrder() {
		printInOrder(root);
	}

	void printPreOrder() {
		printPreOrder(root);
	}

	void printPostOrder() {
		printPostOrder(root);
	}

	void printBreadthFirstSearc(Node node) {
		int h = height(node);
		int i = 1;
		for (i = 1; i <= height(node); i++)
			printGivenLevelNode(node, i);
	}

	int height(Node node) {
		if (node == null)
			return 0;
		else {
			int lheight = height(node.left);
			int rheight = height(node.right);
			if (lheight > rheight)
				return lheight + 1;
			else
				return rheight + 1;
		}
	}

	void printGivenLevelNode(Node node, int level) {
		if (node == null)
			return;
		else if (level == 1) {
			System.out.print(node.data + " ");
		} else if (level > 1) {
			printGivenLevelNode(node.left, level - 1);
			printGivenLevelNode(node.right, level - 1);
		}

	}

	void printBreadthFirstSearch() {
		printBreadthFirstSearc(root);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("printInOrder");
		tree.printInOrder();
		System.out.println();
		System.out.println("printPreOrder");
		tree.printPreOrder();
		System.out.println();
		System.out.println("printPostOrder");
		tree.printPostOrder();
		System.out.println();
		System.out.println("Breadth first search");
		tree.printBreadthFirstSearch();

	}

}
