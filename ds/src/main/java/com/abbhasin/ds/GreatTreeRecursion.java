package com.abbhasin.ds;

public class GreatTreeRecursion {

	private final TreeNode root;

	public GreatTreeRecursion(TreeNode node) {
		this.root = node;
	}

	public TreeNode createDoublyLinkedList() {
		return createDoublyLinkedList(root);
	}

	/**
	 * <p>
	 * returns the head of the linked list.
	 * </p>
	 * <p>
	 * left is Next.
	 * </p>
	 * <p>
	 * right is Prev.
	 * </p>
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode createDoublyLinkedList(TreeNode node) {
		if (node == null)
			return null;

		TreeNode leftHead = createDoublyLinkedList(node.left);
		TreeNode rightHead = createDoublyLinkedList(node.right);
		node.left = node;
		node.right = node;
		return concatenate(concatenate(leftHead, node), rightHead);

	}

	private TreeNode concatenate(TreeNode leftHead, TreeNode rightHead) {
		if (leftHead == null)
			return rightHead;
		if (rightHead == null)
			return leftHead;
		/**
		 * leftTail = prev of leftHead rightTail = prev of rightHead leftTail ->
		 * next = rightHead rightTail -> leftHead leftHead -> prev = rightTail
		 * rightHead -> prev = leftTail
		 */
		TreeNode leftTail = leftHead.right;
		TreeNode rightTail = rightHead.right;
		leftTail.left = rightHead;
		rightTail.left = leftHead;
		leftHead.right = rightTail;
		rightHead.right = leftTail;
		return leftHead;
	}

	public TreeNode createDLLOfLeaves() {
		return createDllOfLeaves(root);
	}

	/**
	 * left means next. right means prev.
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode createDllOfLeaves(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null && node.right == null) {
			node.left = node;
			node.right = node;
			return node;
		}

		TreeNode leftLeafHead = createDllOfLeaves(node.left);
		TreeNode rightLeafHead = createDllOfLeaves(node.right);
		return concatenateNodes(leftLeafHead, rightLeafHead);
	}

	private TreeNode concatenateNodes(TreeNode left, TreeNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		TreeNode leftTail = left.right;
		TreeNode rightTail = right.right;
		leftTail.left = right;
		right.right = leftTail;
		left.right = rightTail;
		rightTail.left = left;
		return left;
	}
}
