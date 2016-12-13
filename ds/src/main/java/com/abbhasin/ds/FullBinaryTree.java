package com.abbhasin.ds;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FullBinaryTree {

	public TreeNode createFullBinaryTree(List<Integer> pre, List<Integer> post) {
		AtomicInteger preIndex = new AtomicInteger();
		return createFullBinaryTree(pre, post, 0, post.size() - 1, preIndex);
	}

	private TreeNode createFullBinaryTree(List<Integer> pre, List<Integer> post, int postStart, int postEnd,
			AtomicInteger preIndex) {
		TreeNode node = new TreeNode(pre.get(preIndex.get()));
		preIndex.incrementAndGet();
		if(preIndex.get()>=pre.size())
			return node;
		if(postStart==postEnd)
			return node;
		int i = findPreInPost(post, postStart, postEnd-1, pre.get(preIndex.get()));
		node.left = createFullBinaryTree(pre, post, postStart, i, preIndex);
		node.right = createFullBinaryTree(pre, post, i+1, postEnd-1, preIndex);
		return node;
	}

	private int findPreInPost(List<Integer> post, int postStart, int postEnd, int val) {
		System.out.println("finding val:"+val+" for postStart:"+postStart+" postEnd:"+postEnd);
		for (int i = postStart; i <= postEnd; i++) {
			if (post.get(i).equals(val))
				return i;
		}
		throw new RuntimeException("unable to find");
	}

}
