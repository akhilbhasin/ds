package com.abbhasin.ds;

public class RemoveNodesNotInPath {

	public TreeNode removeNodesNotInPathofKSum(TreeNode node, int k) {
		// boolean isGreater = isSumGreater(node, k, 0);
		// if (isGreater)
		// return node;
		// else
		// return null;
		return removeNodesWithSumLessThanK(node, k, 0);
	}

	private boolean isSumGreater(TreeNode node, int k, int sumTillNow) {
		if (node == null)
			return false;

		if (node.left == null && node.right == null) {
			if (node.val + sumTillNow >= k)
				return true;
		}
		boolean isLeftPathGreater = isSumGreater(node.left, k, sumTillNow + node.val);
		boolean isRightPathGreater = isSumGreater(node.right, k, sumTillNow + node.val);

		if (!isLeftPathGreater) {
			node.left = null;
		}
		if (!isRightPathGreater) {
			node.right = null;
		}
		return isLeftPathGreater || isRightPathGreater;
	}

	private TreeNode removeNodesWithSumLessThanK(TreeNode node, int k, int sumTillNow) {
		if (node == null)
			return null;

		node.left = removeNodesWithSumLessThanK(node.left, k, sumTillNow + node.val);
		node.right = removeNodesWithSumLessThanK(node.right, k, sumTillNow + node.val);

		if (node.left == null && node.right == null && sumTillNow + node.val < k) {
			return null;
		}
		return node;
	}

	public TreeNode removeNodesNotInPathOfLengthGreaterThanK(TreeNode node, int k) {
		if (!isPathLengthGreater(node, 1, k)) {
			return null;
		}
		return node;
	}

	private boolean isPathLengthGreater(TreeNode node, int lengthTillNow, int k) {
		if (node == null) {
			return false;
		}
		if (lengthTillNow > k)
			return true;

		boolean isLeftGreater = isPathLengthGreater(node.left, lengthTillNow + 1, k);
		boolean isRightGreater = isPathLengthGreater(node.right, lengthTillNow + 1, k);
		if (!isLeftGreater) {
			node.left = null;
		}
		if (!isRightGreater) {
			node.right = null;
		}
		return isLeftGreater || isRightGreater;
	}

}
