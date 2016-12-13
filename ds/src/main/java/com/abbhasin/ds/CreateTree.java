package com.abbhasin.ds;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateTree {
	private final List<Integer> inorderSeq;
	private final List<Integer> preorderSeq;

	public CreateTree(List<Integer> inorder, List<Integer> preorder) {
		this.inorderSeq = inorder;
		this.preorderSeq = preorder;
	}

	public TreeNode createTree() {
		int size = inorderSeq.size();
		AtomicInteger preorderIndex = new AtomicInteger();
		return createTree(0, size - 1, preorderIndex);
	}

	private TreeNode createTree(int inorderStartIndex, int inorderEndIndex, AtomicInteger preorderIndex) {

		if (inorderStartIndex > inorderEndIndex) {
			return null;
		}

		TreeNode head = new TreeNode(preorderSeq.get(preorderIndex.get()));
		preorderIndex.incrementAndGet();
		int i = findIndexInInorderSeq(head.val, inorderStartIndex, inorderEndIndex);
		TreeNode leftSubtree = createTree(inorderStartIndex, i - 1, preorderIndex);
		TreeNode rightSubtree = createTree(i + 1, inorderEndIndex, preorderIndex);
		head.left = leftSubtree;
		head.right = rightSubtree;
		return head;
	}

	private int findIndexInInorderSeq(Integer value, int inorderStartIndex, int inorderEndIndex) {
		for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
			if (inorderSeq.get(i).equals(value))
				return i;
		}
		throw new RuntimeException("unable to find the index");
	}

	public TreeNode createTree(List<Integer> inorder, List<Integer> levelOrder, int inorderStartIndex,
			int inorderEndIndex) {
		if (inorderStartIndex > inorderEndIndex)
			return null;		
		int i = findIndexInInorderSeq(inorderStartIndex, inorderEndIndex, inorder,levelOrder);
		if (i == -1) {
			return null;
		}		
		TreeNode node = new TreeNode(inorder.get(i));
		node.left = createTree(inorder, levelOrder, inorderStartIndex, i - 1);
		node.right = createTree(inorder, levelOrder, i + 1, inorderEndIndex);
		
		
		return node;

	}

	private int findIndexInInorderSeq(int inorderStartIndex, int inorderEndIndex,
			List<Integer> inorderSeq, List<Integer> levelOrderSeq) {
		for (int j = 0; j < levelOrderSeq.size(); j++) {
			
			for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
				if (inorderSeq.get(i).equals(levelOrderSeq.get(j)))
					return i;
			}
		}
		return -1;
	}
}
