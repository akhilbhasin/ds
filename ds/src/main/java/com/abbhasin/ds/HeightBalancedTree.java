package com.abbhasin.ds;

public class HeightBalancedTree {

	private final TreeNode root;

	public HeightBalancedTree(TreeNode root) {
		this.root = root;
	}

	public boolean isHeightBalanced() {
		HeightWrapper h = new HeightWrapper();
		boolean val = isHeightBalanced(root, h);
		System.out.println("value of max height is: " + h.get());
		return val;
	}

	private boolean isHeightBalanced(TreeNode node, HeightWrapper h) {
		if (node == null) {
			return true;
		}

		HeightWrapper hl = new HeightWrapper();
		HeightWrapper hr = new HeightWrapper();

		boolean val = isHeightBalanced(node.left, hl) && isHeightBalanced(node.right, hr) && (hl.get() - hr.get() <= 1);
		h.set(Math.max(hl.get(), hr.get()) + 1);
		return val;
	}

	private static class HeightWrapper {
		int height;

		public void set(int v) {
			height = v;
		}

		public int get() {
			return height;
		}
	}

}
