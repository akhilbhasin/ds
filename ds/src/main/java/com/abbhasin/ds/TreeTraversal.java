package com.abbhasin.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import javax.net.ssl.HostnameVerifier;

public class TreeTraversal {

	private final TreeNode root;

	public TreeTraversal(TreeNode node) {
		this.root = node;
	}

	public void inorderTraversal() {
		inorderTraversal(root);
		System.out.println("############# wihtout rec:");
		inorderTraversalWithoutRec(root);
		System.out.println("############# morris:");
		morrisTraversal(root);
	}

	private void inorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.print(node.val + " ");
		inorderTraversal(node.right);

	}

	private void inorderTraversalWithoutRec(TreeNode node) {
		if (node == null)
			return;
		Stack<TreeNode> s = new Stack<>();
		s.push(node);
		// System.out.print(node.val + " ");
		TreeNode current = node.left;
		while (!s.isEmpty() || current != null) {
			if (current == null) {
				current = s.pop();
				System.out.print(current.val + " ");

				current = current.right;

			} else {
				// System.out.print(current.val + " "); //uncomment this and
				// comment print statement in if to make it preorder traversal
				// using stack
				s.push(current);
				current = current.left;
			}

		}

	}

	private void morrisTraversal(TreeNode node) {
		TreeNode current = node;
		TreeNode pred = null;

		while (current != null) {
			/**
			 * if the left portion of this is null then print this and move to
			 * right side.
			 */
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;
			} else {
				/**
				 * if left side of current is not null, then either we have to
				 * go to left subtree and print everything or we might have
				 * already visited it, then we remove the linkage.
				 */
				// find predecessor in the left subtree
				pred = current.left;
				while (pred.right != null && pred.right != current) {
					pred = pred.right;
				}
				/**
				 * this is the case when we have not yet visited the left
				 * subtree
				 */
				if (pred.right == null) {
					pred.right = current;
					// System.out.print(current.val + " "); // uncomment this
					// and comment print in else to make it preorder traversal
					// using morris
					current = current.left;
					/**
					 * else pred.right == current, i.e. we have already visited
					 * left subtree, so remove linkage and print current
					 */
				} else {
					pred.right = null;
					System.out.print(current.val + " ");
					current = current.right;
				}
			}
		}
	}

	public void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	public void postorderTraversal() {
		postorderTraversal(root);
	}

	private void postorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}

		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.val + " ");

	}

	public void levelorderTraversal() {
		Queue<TreeNode> levelorderStack = new LinkedBlockingQueue<>();
		levelorderStack.add(root);
		levelorderTraversal(levelorderStack);
	}

	private void levelorderTraversal(Queue<TreeNode> s) {
		while (!s.isEmpty()) {
			TreeNode node = s.remove();
			System.out.print(node.val + " ");
			System.out.println(String.format("ht of %d is %d", node.val,node.h));
			if (node.left != null) {
				s.add(node.left);
			}
			if (node.right != null) {
				s.add(node.right);
			}
		}
	}

	public void printAncestors(int val) {
		printAncestors(root, val);
	}

	private TreeNode printAncestors(TreeNode node, int val) {
		if (node == null)
			return null;
		if (node.val == val) {
			return node;

		}

		TreeNode prev = printAncestors(node.left, val);
		if (prev != null) {
			System.out.print(node.val + " ");
			return node;
		}
		prev = printAncestors(node.right, val);
		if (prev != null) {
			System.out.print(node.val + " ");
			return node;
		}
		return null;
	}

	public int sumTree(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int lsum = sumTree(node.left);
		int rsum = sumTree(node.right);
		int current = lsum + rsum;
		int temp = node.val;
		node.val = current;
		return current + temp;
	}

	public void verticalSum() {
		Map<Integer, Integer> map = new HashMap<>();
		verticalSum(root, map, 0);
		map.values().forEach(v -> System.out.print(v + " "));
	}

	private void verticalSum(TreeNode node, Map<Integer, Integer> map, int horDistance) {
		if (node == null)
			return;
		if (map.containsKey(horDistance)) {
			int i = map.get(horDistance);
			map.put(horDistance, i + node.val);
		} else {
			map.put(horDistance, node.val);
		}

		verticalSum(node.left, map, horDistance - 1);
		verticalSum(node.right, map, horDistance + 1);
	}

}
