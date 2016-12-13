package com.abbhasin.ds;

public class ConnectNodesAtSameLevel {

	public void connectNodesAtSameLevel(TreeNode root) {
		connectIteratively(root);
	}

	private void connectNodesRecursively(TreeNode node) {
		if (node == null)
			return;
		if (node.nextright != null) {
			connectNodesRecursively(node.nextright);
		}

		if (node.left != null) {
			if (node.right != null) {
				node.left.nextright = node.right;
			} else {
				node.left = getNextRight(node.nextright);
			}
			connectNodesRecursively(node.left);
		} else if (node.right != null) {
			node.right = getNextRight(node.nextright);
			connectNodesRecursively(node.right);
		}
		connectNodesRecursively(getNextRight(node.nextright));

	}

	private TreeNode getNextRight(TreeNode node) {
		if (node == null)
			return null;
		if (node.left != null)
			return node.left;
		if (node.right != null)
			return node.right;
		return getNextRight(node.nextright);
	}

	private void connectIteratively(TreeNode node) {
		TreeNode cur = node;
		while (cur != null) {
			connectAllChildrenNodesAtLevel(cur);

			if (cur.left != null) {
				cur = cur.left;
				continue;
			} else if (cur.right != null) {
				cur = cur.right;
				continue;
			}
			cur = getNextRight(node.nextright);
		}

	}

	private void connectAllChildrenNodesAtLevel(TreeNode node) {
		while (node != null) {
			if (node.left == null && node.right == null) {
				node = node.nextright;
				continue;
			}
			TreeNode nextRightForChildren = getNextRight(node.nextright);
			if (node.left != null) {
				if (node.right != null) {
					node.left.nextright = node.right;
					node.right.nextright = nextRightForChildren;

				} else {
					node.left.nextright = nextRightForChildren;
				}
			} else if (node.right != null) {
				node.right.nextright = nextRightForChildren;
			}
			node = node.nextright;
		}
	}

}
