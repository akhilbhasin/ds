package com.abbhasin.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinIterationToPassInfo {

	public int minIterationToPassInfo(NTreeNode node) {
		return minIteration(node);
	}

	private int minIteration(NTreeNode node) {
		if (node == null)
			return 0;

		int sizeOfChildren = node.children.size();
		List<Integer> numberOfIterationOfChildren = new ArrayList<>(sizeOfChildren);
		System.out.println("size of numOfIter="+numberOfIterationOfChildren.size());
		
		for (int i = 0; i < sizeOfChildren; i++) {
			numberOfIterationOfChildren.add(i, minIteration(node.children.get(i)));
		}

		Collections.sort(numberOfIterationOfChildren, (a, b) -> b - a);
		System.out.println("Sorted List:" + numberOfIterationOfChildren);
		int maxNumOfIteration = 0;
		for (int i = 0; i < sizeOfChildren; i++) {
			int totalNumberOfIterationToPassInfoToIthChild = (i + 1) + numberOfIterationOfChildren.get(i);
			if (maxNumOfIteration < totalNumberOfIterationToPassInfoToIthChild) {
				maxNumOfIteration = totalNumberOfIterationToPassInfoToIthChild;
			}
		}

		return maxNumOfIteration;

	}

}
