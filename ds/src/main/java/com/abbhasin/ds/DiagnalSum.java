package com.abbhasin.ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DiagnalSum {

	public static class TreeNodeWrapper {
		public TreeNode node;
		public int dd; // diagnalDistance

		public TreeNodeWrapper(TreeNode node, int dd) {
			this.node = node;
			this.dd = dd;
		}

		public TreeNodeWrapper(TreeNode node) {
			this.node = node;
		}

	}

	public void printDiagnalSums(TreeNode node) {
		Queue<TreeNodeWrapper> q = new LinkedList<>();
		Map<Integer, Integer> mapOfDiagnamSum = new HashMap<>();
		TreeNodeWrapper root = new TreeNodeWrapper(node, 0);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNodeWrapper cur = q.remove();
			TreeNode curNode = cur.node;
			int dd = cur.dd;

			while (curNode != null) {
				if(curNode.left!=null){
					TreeNodeWrapper t = new TreeNodeWrapper(curNode.left);
					t.dd = dd +1;
					q.add(t);
				}
				int prevSum = (mapOfDiagnamSum.get(dd)==null)?0:mapOfDiagnamSum.get(dd);
				mapOfDiagnamSum.put(dd, prevSum+curNode.val);
				curNode = curNode.right;
			}
		}
		
		mapOfDiagnamSum.values().stream().forEach(v-> System.out.println("Sum:"+v+ " "));

	}

}
