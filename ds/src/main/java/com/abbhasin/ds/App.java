package com.abbhasin.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.abbhasin.ds.Trie.TrieNode;

/**
 * Hello world! a,b,c,d,e,f 1,2,3,4,5,6
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		List<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3));
		List<Integer> preorder = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3, 6));
		TreeNode head = new CreateTree(inorder, preorder).createTree();
		// for connect TreeNodes at same level
		// TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.left.left.left = new TreeNode(8);
		// root.left.left.right = new TreeNode(9);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		// root.right.right.left = new TreeNode(10);
		// root.right.right.right = new TreeNode(11);

		// TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = (new TreeNode(3));
		// root.left.left = (new TreeNode(4));
		// root.left.right = (new TreeNode(5));
		// root.right.left = (new TreeNode(6));
		// root.right.right = (new TreeNode(7));
		//
		// TreeNode ndoe = new
		// FullBinaryTree().createFullBinaryTree(Arrays.asList(1, 2, 4, 8, 9, 5,
		// 3, 6, 7),
		// Arrays.asList(8, 9, 4, 5, 2, 6, 7, 3, 1));
		// new TreeTraversal(ndoe).inorderTraversal();

		// TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		// System.out.println("LCA(4, 5) = " + LCA(root, 4, 5).val);
		// System.out.println("LCA(4, 6) = " + LCA(root, 4, 6).val);
		// System.out.println("LCA(3, 4) = " + LCA(root, 3, 4).val);
		// System.out.println("LCA(2, 4) = " + LCA(root, 2, 4).val);

		// root = new RemoveNodesNotInPath().removeNodesNotInPathofKSum(root,
		// 45);

		// TreeNode root = new TreeNode(-15);
		// root.left = new TreeNode(5);
		// root.right = new TreeNode(6);
		// root.left.left = new TreeNode(-8);
		// root.left.right = new TreeNode(1);
		// root.left.left.left = new TreeNode(2);
		// root.left.left.right = new TreeNode(6);
		// root.right.left = new TreeNode(3);
		// root.right.right = new TreeNode(9);
		// root.right.right.right = new TreeNode(0);
		// root.right.right.right.left = new TreeNode(4);
		// root.right.right.right.right = new TreeNode(-1);
		// root.right.right.right.right.left = new TreeNode(10);
		//
		// System.out.println("max sum bw leaves:" + new
		// MaxPathSumBWLeaves().maxSumPath(root));

		// leaves
		// NTreeNode node20 = new NTreeNode(20);
		// NTreeNode node19 = new NTreeNode(19);
		// NTreeNode node18 = new NTreeNode(18);
		// NTreeNode node17 = new NTreeNode(17);
		// NTreeNode node16 = new NTreeNode(16);
		// NTreeNode node15 = new NTreeNode(15);
		// NTreeNode node14 = new NTreeNode(14);
		// NTreeNode node13 = new NTreeNode(13);
		// NTreeNode node12 = new NTreeNode(12);
		// NTreeNode node11 = new NTreeNode(11);
		// NTreeNode node10 = new NTreeNode(10);
		// NTreeNode node9 = new NTreeNode(9);
		// NTreeNode node8 = new NTreeNode(8);
		// NTreeNode node7 = new NTreeNode(7);
		// NTreeNode node6 = new NTreeNode(6);
		// NTreeNode node5 = new NTreeNode(5);
		// NTreeNode node4 = new NTreeNode(4);
		// NTreeNode node3 = new NTreeNode(3);
		// NTreeNode node2 = new NTreeNode(2);
		// NTreeNode node1 = new NTreeNode(1);
		// NTreeNode node21 = new NTreeNode(21);
		// NTreeNode node22 = new NTreeNode(22);
		// NTreeNode node23 = new NTreeNode(23);
		// NTreeNode node24 = new NTreeNode(24);
		// NTreeNode node25 = new NTreeNode(25);
		// NTreeNode node26 = new NTreeNode(26);
		// node15.children = new ArrayList<>(Arrays.asList(node21, node25));
		// node21.children = new ArrayList<>(Arrays.asList(node22));
		// node22.children = new ArrayList<>(Arrays.asList(node23));
		// node23.children = new ArrayList<>(Arrays.asList(node24));
		// node24.children = new ArrayList<>(Arrays.asList(node26));
		//
		// node1.children = new ArrayList<>(Arrays.asList(node2, node3, node4,
		// node5, node6, node7));
		// node2.children = new ArrayList<>(Arrays.asList(node8, node9,
		// node10));
		// node5.children = new ArrayList<>(Arrays.asList(node11, node12));
		// node7.children = new ArrayList<>(Arrays.asList(node13));
		// node8.children = new ArrayList<>(Arrays.asList(node14, node15));
		// node11.children = new ArrayList<>(Arrays.asList(node16));
		// node12.children = new ArrayList<>(Arrays.asList(node17));
		// node16.children = new ArrayList<>(Arrays.asList(node18, node19,
		// node20));
		// System.out.println("max number to pass info:"+new
		// MinIterationToPassInfo().minIterationToPassInfo(node1));
//		AVL avl = new AVL();
//		TreeNode root = avl.addNode(null, 10);
//		System.out.println("root:" + root.val);
//		root = avl.addNode(root, 20);
//		System.out.println("root:" + root.val);
//		root = avl.addNode(root, 30);
//		System.out.println("root:" + root.val);
//		root = avl.addNode(root, 40);
//		System.out.println("root:" + root.val);
//		root = avl.addNode(root, 50);
//		System.out.println("root:" + root.val);
//		root = avl.addNode(root, 25);
//		System.out.println("root:" + root.val);
//		new TreeTraversal(root).levelorderTraversal();
		TrieNode n = new TrieNode('a');
		

	}

	private static void printNextRights(TreeNode TreeNode) {
		if (TreeNode == null)
			return;
		System.out.println(String.format("NextRight for %d is %d", TreeNode.val,
				(TreeNode.nextright != null ? TreeNode.nextright.val : -1)));

		printNextRights(TreeNode.left);
		printNextRights(TreeNode.right);
	}

	private static void findSum(TreeNode node, int currentSum, AtomicInteger totalSum) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			totalSum.set(totalSum.get() + currentSum * 10 + node.val);
		}
		findSum(node.left, currentSum * 10 + node.val, totalSum);
		findSum(node.right, currentSum * 10 + node.val, totalSum);
	}

	private static int findSum(TreeNode node, int currSum) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null) {
			return currSum * 10 + node.val;
		}

		return findSum(node.left, currSum * 10 + node.val) + findSum(node.right, currSum * 10 + node.val);
	}

	private static TreeNode LCA(TreeNode node, int a, int b) {
		AtomicReference<TreeNode> nodeRef = new AtomicReference<>(node);
		LCA(node, nodeRef, a, b);
		return nodeRef.get();
	}

	private static boolean LCA(TreeNode node, AtomicReference<TreeNode> nodeRef, int a, int b) {
		if (node == null)
			return false;

		boolean leftHasOne = LCA(node.left, nodeRef, a, b);
		boolean rightHasOne = LCA(node.right, nodeRef, a, b);
		if (nodeRef.get() == null) {
			if (leftHasOne && rightHasOne) {
				nodeRef.set(node);
				return true;
			}
			if (leftHasOne && (node.val == a || node.val == b)) {
				nodeRef.set(node);
				return true;
			}
			if (rightHasOne && (node.val == a || node.val == b)) {
				nodeRef.set(node);
				return true;
			}
			if ((node.val == a || node.val == b))
				return true;
		}

		return leftHasOne || rightHasOne;

	}

	private static void printAllNodesAtKFromNode(TreeNode root, int fromVal, int k) {
		printNodesInSubtreeOfNode(root, fromVal, k, 0, null);
	}

	private static void printNodesInSubtreeOfNode(TreeNode root, int fromVal, int k, int current,
			AtomicReference<TreeNode> fromNode) {
		if (root == null)
			return;
		if (root.val == fromVal) {
			fromNode.set(root);
		}
		if (current == k) {
			System.out.println(root.val + " ");
		}

		printNodesInSubtreeOfNode(root.left, fromVal, k, (fromNode.get() == null) ? current : current + 1, fromNode);
		printNodesInSubtreeOfNode(root.right, fromVal, k, (fromNode.get() == null) ? current : current + 1, fromNode);
	}

}
