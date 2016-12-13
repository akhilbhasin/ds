package com.abbhasin.ds;

public class AncestorMatrix {

	public int[][] createAncestorMatrix(TreeNode node, int n) {
		Matrix m = new Matrix(n);
		fillMatrix(node, m, n);
		return m.getMatrix();
	}

	private void fillMatrix(TreeNode node, Matrix m, int n) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			m.set(node.val, node.left.val);
			System.out
					.println(String.format("m[%d][%d] = %d", node.val, node.left.val, m.get(node.val, node.left.val)));
			fillAllAncestors(node.left, node, m, n);
		}

		if (node.right != null) {
			m.set(node.val, node.right.val);
			System.out
			.println(String.format("m[%d][%d] = %d", node.val, node.right.val, m.get(node.val, node.right.val)));
			fillAllAncestors(node.right, node, m, n);
		}

		fillMatrix(node.left, m, n);
		fillMatrix(node.right, m, n);

	}

	private void fillAllAncestors(TreeNode child, TreeNode parent, Matrix m, int n) {
		for (int i = 0; i < n; i++) {
			if (m.get(i, parent.val) == 1) {
				System.out.println("ancestor:" + parent.val + " child:" + child.val + " i:" + i);
				m.set(i, child.val);
			}
		}
	}

	private static class Matrix {
		int[][] matrix;

		public Matrix(int n) {
			matrix = new int[n][n];
		}

		public void set(int i, int j) {
			matrix[i][j] = 1;
		}

		public int get(int i, int j) {
			return matrix[i][j];
		}

		public int[][] getMatrix() {
			return matrix;
		}
	}

}
