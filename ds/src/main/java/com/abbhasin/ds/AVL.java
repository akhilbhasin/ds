package com.abbhasin.ds;

public class AVL {

	public TreeNode addNode(TreeNode node, int val) {
		if (node == null) {
			TreeNode n = new TreeNode(val);
			n.h = 1;
			return n;
		}

		if (node.val > val) {
			node.left = addNode(node.left, val);
		}

		if (node.val < val) {
			node.right = addNode(node.right, val);
		}
		node.h = Math.max(height(node.left), height(node.right)) + 1;
		// check for imbalance
		if (Math.abs(height(node.left) - height(node.right)) > 1) {
			UseCase useCase = findUseCase(node, val);
			switch (useCase) {
			case LeftLeft:
				return rightRotate(node);

			case LeftRight:
				node.left = leftRotate(node.left);
				return rightRotate(node);

			case RightLeft:
				node.right = rightRotate(node.right);
				return leftRotate(node);

			case RightRight:
				return leftRotate(node);

			default:
				throw new IllegalStateException("wrong state");
			}
		}
		return node;
	}

	private TreeNode leftRotate(TreeNode node) {
		TreeNode rightSubTree = node.right;
		TreeNode leftOfRightSubTree = rightSubTree.left;

		// rotate
		node.right = leftOfRightSubTree;
		rightSubTree.left = node;
		// height balancing
		node.h = Math.max(height(node.left), height(node.right)) + 1;
		rightSubTree.h = Math.max(height(rightSubTree.left), height(rightSubTree.right)) + 1;
		
		return rightSubTree;
	}
	
	private TreeNode rightRotate(TreeNode node){
		TreeNode leftSubTree = node.left;
		TreeNode rightOfLeftSubTree = leftSubTree.right;
		
		//rotate
		node.left = rightOfLeftSubTree;
		leftSubTree.right = node;
		
		//height balancing
		node.h = Math.max(height(node.left), height(node.right)) + 1;
		leftSubTree.h = Math.max(height(leftSubTree.left), height(leftSubTree.right)) + 1;
		
		return leftSubTree;
	}

	private int height(TreeNode n) {
		if (n == null) {
			return 0;
		}
		return n.h;
	}

	private static enum UseCase {
		LeftLeft, RightRight, LeftRight, RightLeft;
	}

	private static UseCase findUseCase(TreeNode imbalancedNode, int val) {
		if (imbalancedNode.val < val) { // Right*
			if (imbalancedNode.right.val < val) {// Right
				return UseCase.RightRight;
			}
			return UseCase.RightLeft;
		} else { // left*
			if (imbalancedNode.left.val < val) { // right
				return UseCase.LeftRight;
			}
			return UseCase.LeftLeft;
		}

	}

}
