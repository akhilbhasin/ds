package com.abbhasin.ds;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSumBWLeaves {

	public int maxSumPath(TreeNode node) {
		AtomicInteger max = new AtomicInteger();
		maxPathSumBWLeaves(node, max, new AtomicBoolean(false));
		return max.get();
	}

	private int maxPathSumBWLeaves(TreeNode node, AtomicInteger maxSum, AtomicBoolean isLeafPresent) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null) {
			isLeafPresent.set(true);
			return node.val;
		}

		AtomicBoolean isLeftLeafPresent = new AtomicBoolean(false);
		AtomicBoolean isRightLeafPresent = new AtomicBoolean(false);
		int lSum = maxPathSumBWLeaves(node.left, maxSum, isLeftLeafPresent);
		int rSum = maxPathSumBWLeaves(node.right, maxSum, isRightLeafPresent);

		if (isLeftLeafPresent.get() && isRightLeafPresent.get() && maxSum.get() < lSum + rSum + node.val) {
			maxSum.set(lSum + rSum + node.val);
		}
		if (isLeftLeafPresent.get() && isRightLeafPresent.get()) {
			return Math.max(lSum, rSum) + node.val;
		}
		isLeafPresent.set(isLeftLeafPresent.get() || isRightLeafPresent.get());
		return isLeftLeafPresent.get() ? lSum + node.val : rSum + node.val;
	}

}
